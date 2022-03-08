package com.example.tictactoe.game

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.tictactoe.R
import com.example.tictactoe.databinding.FragmentGameBinding


class GameFragment : Fragment() {

    private lateinit var binding : FragmentGameBinding

    private lateinit var viewModel: GameViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?): View? {

        binding=DataBindingUtil.inflate(inflater,R.layout.fragment_game,container,false)

        viewModel=ViewModelProvider(this).get(GameViewModel::class.java)

        binding.again.setOnClickListener {
            findNavController().navigate(R.id.action_gameFragment_to_titleFragment)
        }
        binding.box1.setOnClickListener {
            viewModel.addText(0)
        }
        binding.box2.setOnClickListener {
            viewModel.addText(1)
        }
        binding.box3.setOnClickListener {
            viewModel.addText(2)
        }
        binding.box4.setOnClickListener {
            viewModel.addText(3)
        }
        binding.box5.setOnClickListener {
            viewModel.addText(4)
        }
        binding.box6.setOnClickListener {
            viewModel.addText(5)
        }
        binding.box7.setOnClickListener {
            viewModel.addText(6)
        }
        binding.box8.setOnClickListener {
            viewModel.addText(7)
        }
        binding.box9.setOnClickListener {
            viewModel.addText(8)
        }
        viewModel.change.observe(viewLifecycleOwner) {
            change()
            viewModel.winner()
            if(viewModel.win.value=="Z") {
                if (viewModel.turn == true) {
                    binding.turn.text = "O"
                } else {
                    binding.turn.text = "X"
                }
            }
        }
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.win.observe(viewLifecycleOwner) {
            winn()
        }
    }

    fun change(){
        for (i in 0..8) {
            val r = i / 3
            val c = i % 3
            if (i == 0) {
                binding.box1.text = viewModel.answer[r][c].toString()
                Log.i("Spider",viewModel.answer.toString())
            } else if (i == 1) {
                binding.box2.text = viewModel.answer[r][c].toString()
                Log.i("Spider",viewModel.answer.toString())
            } else if (i == 2) {
                binding.box3.text = viewModel.answer[r][c].toString()
                Log.i("Spider",viewModel.answer.toString())
            } else if (i == 3) {
                binding.box4.text = viewModel.answer[r][c].toString()
                Log.i("Spider",viewModel.answer.toString())
            } else if (i == 4) {
                binding.box5.text = viewModel.answer[r][c].toString()
                Log.i("Spider",viewModel.answer.toString())
            } else if (i == 5) {
                binding.box6.text = viewModel.answer[r][c].toString()
                Log.i("Spider",viewModel.answer.toString())
            } else if (i == 6) {
                binding.box7.text = viewModel.answer[r][c].toString()
                Log.i("Spider",viewModel.answer.toString())
            } else if (i == 7) {
                binding.box8.text = viewModel.answer[r][c].toString()
                Log.i("Spider",viewModel.answer.toString())
            } else if (i == 8) {
                binding.box9.text = viewModel.answer[r][c].toString()
                Log.i("Spider",viewModel.answer.toString())
            } else {
                binding.result.text="abc"
                Log.i("Spider",viewModel.answer.toString())
            }
        }
    }

    fun winn(){
        val colorValue = context?.let { ContextCompat.getColor(it, R.color.green) }
        if (viewModel.win.value!="Z"){
            binding.again.visibility=View.VISIBLE
        }
        Log.i("ErrorErrorError",viewModel.win.value.toString())
        if (viewModel.win.value=="W1"){
            binding.box1.setBackgroundColor(colorValue!!)
            binding.box2.setBackgroundColor(colorValue!!)
            binding.box3.setBackgroundColor(colorValue!!)
        }
        if (viewModel.win.value=="W2"){
            binding.box4.setBackgroundColor(colorValue!!)
            binding.box5.setBackgroundColor(colorValue!!)
            binding.box6.setBackgroundColor(colorValue!!)
        }
        if (viewModel.win.value=="W3"){
            binding.box7.setBackgroundColor(colorValue!!)
            binding.box8.setBackgroundColor(colorValue!!)
            binding.box9.setBackgroundColor(colorValue!!)
        }
        if (viewModel.win.value=="W4"){
            binding.box1.setBackgroundColor(colorValue!!)
            binding.box4.setBackgroundColor(colorValue!!)
            binding.box7.setBackgroundColor(colorValue!!)
        }
        if (viewModel.win.value=="W5"){
            binding.box2.setBackgroundColor(colorValue!!)
            binding.box5.setBackgroundColor(colorValue!!)
            binding.box8.setBackgroundColor(colorValue!!)
        }
        if (viewModel.win.value=="W6"){
            binding.box3.setBackgroundColor(colorValue!!)
            binding.box6.setBackgroundColor(colorValue!!)
            binding.box9.setBackgroundColor(colorValue!!)
        }
        if (viewModel.win.value=="W7"){
            binding.box1.setBackgroundColor(colorValue!!)
            binding.box5.setBackgroundColor(colorValue!!)
            binding.box9.setBackgroundColor(colorValue!!)
        }
        if (viewModel.win.value=="W8"){
            binding.box3.setBackgroundColor(colorValue!!)
            binding.box5.setBackgroundColor(colorValue!!)
            binding.box7.setBackgroundColor(colorValue!!)
        }
        if(viewModel.turn==false && viewModel.win.value!="D" && viewModel.win.value!="Z"){
            binding.turn.text="O Wins"
        }
        if(viewModel.turn==true && viewModel.win.value!="D" && viewModel.win.value!="Z"){
            binding.turn.setText("X Wins")
        }
        if(viewModel.win.value=="D"){
            binding.turn.text="Draw"
        }
    }
}

