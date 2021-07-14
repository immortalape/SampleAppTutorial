package com.example.sampleapptutorial.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.sampleapptutorial.databinding.FragmentFirstBinding

class FirstFragment : Fragment() {

    private lateinit var binding: FragmentFirstBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        binding = FragmentFirstBinding.inflate(inflater, container, false)

        binding.submitUsernameButton.setOnClickListener {

            val userName = binding.usernameEditText.text
            val action = FirstFragmentDirections.actionFirstFragmentToSecondFragment(userName.toString())
            findNavController().navigate(action)

        }

        return binding.root
    }

}