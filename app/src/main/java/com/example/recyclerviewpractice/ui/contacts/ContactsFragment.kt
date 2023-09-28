package com.example.recyclerviewpractice.ui.contacts

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.recyclerviewpractice.data.DataProvider
import com.example.recyclerviewpractice.domain.Model
import com.example.recyclerviewpractice.R
import com.example.recyclerviewpractice.ui.contacts.adapter.ContactsAdapter
import com.example.recyclerviewpractice.databinding.FragmentContactsBinding
import com.google.android.material.bottomsheet.BottomSheetBehavior

class ContactsFragment : Fragment() {

    private lateinit var binding: FragmentContactsBinding
    private lateinit var contactsAdapter: ContactsAdapter
    private lateinit var bottomSheetBehavior: BottomSheetBehavior<ConstraintLayout>
    private var lastId = 0
    private var indexClicked = -1

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentContactsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        bottomSheetBehavior = BottomSheetBehavior.from(binding.bottomSheetContainer).apply {
            state = BottomSheetBehavior.STATE_HIDDEN
        }

        bottomSheetBehavior.addBottomSheetCallback(object :
            BottomSheetBehavior.BottomSheetCallback() {
            override fun onStateChanged(bottomSheet: View, newState: Int) {
                when (newState) {
                    BottomSheetBehavior.STATE_HIDDEN -> {
                        binding.grayOverlay.visibility = View.GONE
                        indexClicked = -1
                    }

                    else -> binding.grayOverlay.visibility = View.VISIBLE
                }
            }

            override fun onSlide(bottomSheet: View, slideOffset: Float) {
            }
        })

        contactsAdapter = ContactsAdapter { contact, position ->
            bottomSheetBehavior.state = BottomSheetBehavior.STATE_HALF_EXPANDED
            binding.apply {
                grayOverlay.visibility = View.VISIBLE
                indexClicked = position
            }
            setContactProperties(contact)
        }

        binding.contactsRecyclerView.apply {
            adapter = contactsAdapter
            layoutManager = LinearLayoutManager(requireContext())
        }

        contactsAdapter.apply {
            contacts.clear()
            contacts.addAll(DataProvider.getContacts())
            observeDeleteButtonState().observe(viewLifecycleOwner) { isActive ->
                binding.deleteButton.visibility = if (isActive) View.VISIBLE else View.INVISIBLE
            }
        }

        lastId = contactsAdapter.contacts.size

        binding.deleteButton.setOnClickListener {
            contactsAdapter.deleteSelectedContacts()
        }

        binding.addButton.setOnClickListener {
            bottomSheetBehavior.state = BottomSheetBehavior.STATE_EXPANDED
            binding.grayOverlay.visibility = View.VISIBLE
            setContactProperties(Model.Contact())
        }

        binding.createEditContact.setOnClickListener {
            createOrEditContact()
        }
    }

    private fun setContactProperties(contact: Model.Contact) {
        binding.apply {
            grayOverlay.visibility = View.VISIBLE
            contactId.text = contact.id
            contactName.setText(contact.name)
            contactSecondName.setText(contact.secondName)
            contactPhoneNumber.setText(if (contact.phoneNumber == 0L) "" else contact.phoneNumber.toString())
        }
    }

    private fun createOrEditContact() {
        if (binding.name.text.isEmpty()) {
            showToast()
        } else {
            if (binding.contactId.text.isEmpty()) {
                val newId = lastId + 1
                val newContact = Model.Contact(
                    (newId).toString(),
                    binding.contactName.text.toString(),
                    binding.contactSecondName.text.toString(),
                    binding.contactPhoneNumber.text.toString().toLong(),
                    false
                )
                lastId = newId
                contactsAdapter.contacts.add(newContact)
            } else {
                val newContact = contactsAdapter.contacts[indexClicked].copy(
                    name = binding.contactName.text.toString(),
                    secondName = binding.contactSecondName.text.toString(),
                    phoneNumber = binding.contactPhoneNumber.text.toString().toLong(),
                )
                contactsAdapter.apply {
                    contacts[indexClicked] = newContact
                    contactsAdapter.notifyItemChanged(indexClicked)
                }
            }
            bottomSheetBehavior.state = BottomSheetBehavior.STATE_HIDDEN
        }
    }

    private fun showToast() {
        Toast.makeText(context, resources.getText(R.string.empty_name), Toast.LENGTH_LONG).show()
    }

    companion object {
        fun newInstance() = ContactsFragment()
    }
}