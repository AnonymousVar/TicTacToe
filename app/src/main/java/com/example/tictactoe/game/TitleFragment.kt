package com.example.tictactoe.game

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.tictactoe.R
import com.example.tictactoe.databinding.FragmentTitleBinding
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.findNavController


class TitleFragment : Fragment() {

    private lateinit var binding: FragmentTitleBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?): View? {
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_title,container,false)

        binding.play.setOnClickListener {
            findNavController().navigate(R.id.action_titleFragment_to_gameFragment)
        }

        return binding.root
    }


}