package com.example.recyclerviewpractice.ui.flags

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.recyclerviewpractice.databinding.FragmentFlagsBinding
import com.example.recyclerviewpractice.data.DataProvider
import com.example.recyclerviewpractice.ui.flags.adapter.FlagsAdapter

class FlagsFragment : Fragment() {

    private lateinit var binding: FragmentFlagsBinding
    private var flagsAdapter: FlagsAdapter = FlagsAdapter()

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
    }

    companion object {
        fun newInstance() = FlagsFragment()
    }
}