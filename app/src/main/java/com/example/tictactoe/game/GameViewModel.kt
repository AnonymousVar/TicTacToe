package com.example.tictactoe.game

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import android.util.Log
// row * order + column = num
class GameViewModel:ViewModel(){
    val answer = mutableListOf(
          mutableListOf("","",""),
          mutableListOf("","",""),
          mutableListOf("","",""))
    val change = MutableLiveData<String>("start")
    val win = MutableLiveData<String>("Z")
    val order=3
    var turn=true//O

    fun addText(n:Int){
        var row = n/order
        var col = n%order
        Log.i("SpiderMan",answer.toString())
        if(win.value=="Z") {
            if (answer?.get(row)?.get(col) == "" && turn == true) {
                answer!![row][col] = "O"
                turn = false
                Log.i("SpiderMan", answer.toString())
                change.value = "O"
            }
            if (answer?.get(row)?.get(col) == "" && turn == false) {
                answer!![row][col] = "X"
                turn = true
                Log.i("SpiderMan", answer.toString())
                change.value = "X"
            }
        }
    }

    fun winner(){
        if(answer!![0][0]==answer!![0][1]&&answer!![0][0]==answer!![0][2]&&answer!![0][0]!=""){
            win.value="W1"
        }
        if(answer!![1][0]==answer!![1][1]&&answer!![1][0]==answer!![1][2]&&answer!![1][0]!=""){
            win.value="W2"
        }
        if(answer!![2][0]==answer!![2][1]&&answer!![2][0]==answer!![2][2]&&answer!![2][0]!=""){
            win.value="W3"
        }
        if(answer!![0][0]==answer!![1][0]&&answer!![0][0]==answer!![2][0]&&answer!![0][0]!=""){
            win.value="W4"
        }
        if(answer!![0][1]==answer!![1][1]&&answer!![0][1]==answer!![2][1]&&answer!![0][1]!=""){
            win.value="W5"
        }
        if(answer!![0][2]==answer!![1][2]&&answer!![0][2]==answer!![2][2]&&answer!![0][2]!=""){
            win.value="W6"
        }
        if(answer!![0][0]==answer!![1][1]&&answer!![0][0]==answer!![2][2]&&answer!![0][0]!=""){
            win.value="W7"
        }
        if(answer!![0][2]==answer!![1][1]&&answer!![0][2]==answer!![2][0]&&answer!![0][2]!=""){
            win.value="W8"
        }
        if(win.value=="Z"){
            var checker = true
            for (i in 0 until 3){
                for (j in 0 until 3){
                    if(answer!![i][j]==""){
                        checker=false
                        break
                    }
                }
            }
            if(checker==true){
                win.value="D"
            }
        }
    }
}

