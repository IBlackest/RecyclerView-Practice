package com.example.recyclerviewpractice.flags.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.recyclerviewpractice.databinding.FragmentFlagsBinding
import com.example.recyclerviewpractice.DataProvider
import com.example.recyclerviewpractice.flags.model.Flag
import com.example.recyclerviewpractice.flags.ui.adapter.FlagsAdapter

class FlagsFragment : Fragment() {

    private lateinit var binding: FragmentFlagsBinding
    private var flagsAdapter: FlagsAdapter = FlagsAdapter(object : FlagsAdapter.FlagClickListener {
        override fun onCLick(flag: Flag, view: View) {
        }

        override fun onLongClick(flag: Flag, view: View): Boolean {
            return true
        }
    })

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentFlagsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.flagsRecyclerView.apply {
            adapter = flagsAdapter
            layoutManager = LinearLayoutManager(requireContext())
        }
        flagsAdapter.flags.apply {
            clear()
            addAll(DataProvider.getFlags())
        }
        flagsAdapter.notifyDataSetChanged()
    }

    companion object {
        fun newInstance() = FlagsFragment()
    }
}