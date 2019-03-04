package no.marchand.tictactoe

import android.media.Image
import android.os.Bundle
import android.os.SystemClock
import android.support.v4.app.Fragment
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import kotlinx.android.synthetic.main.game_screen_fragment.*

var board = mutableListOf<Array<Int>>()
var buttonsArray = mutableListOf<ImageView>()
var gameInProgress = false

private val TAG = "The debugger is saying"
private var currentPlayer = 1


class GameScreenFragment: Fragment(), View.OnClickListener {

    private var timerRunning: Boolean = false
    private var timerPauseOffset: Long = 0



    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        val view = inflater.inflate(R.layout.game_screen_fragment, container, false)

        val gameDisplay: TextView = view.findViewById(R.id.displayTxtView)

        val btn00: ImageView = view.findViewById(R.id.btn00)
        buttonsArray.add(btn00)

        val btn01: ImageView = view.findViewById(R.id.btn01)
        buttonsArray.add(btn01)

        val btn02: ImageView = view.findViewById(R.id.btn02)
        buttonsArray.add(btn02)

        val btn03: ImageView = view.findViewById(R.id.btn03)
        buttonsArray.add(btn03)

        val btn04: ImageView = view.findViewById(R.id.btn04)
        buttonsArray.add(btn04)

        val btn05: ImageView = view.findViewById(R.id.btn05)
        buttonsArray.add(btn05)

        val btn06: ImageView = view.findViewById(R.id.btn06)
        buttonsArray.add(btn06)

        val btn07: ImageView = view.findViewById(R.id.btn07)
        buttonsArray.add(btn07)

        val btn08: ImageView = view.findViewById(R.id.btn08)
        buttonsArray.add(btn08)



        val startBtn: Button = view.findViewById(R.id.startBtn)
        val pauseBtn: Button = view.findViewById(R.id.pauseBtn)

        btn00.setOnClickListener(this)
        btn01.setOnClickListener(this)
        btn02.setOnClickListener(this)
        btn03.setOnClickListener(this)
        btn04.setOnClickListener(this)
        btn05.setOnClickListener(this)
        btn06.setOnClickListener(this)
        btn07.setOnClickListener(this)
        btn08.setOnClickListener(this)

        startBtn.setOnClickListener {
            if(!timerRunning && timesPlayed == 0 && !gameInProgress) {
                newGame()
                startTimer()
            }
            else {
                startTimer()
            }
        }
        pauseBtn.setOnClickListener {
            pauseTimer()
        }

        initializeBlocksToZero()
        return view
    }

    override fun onClick(v: View?) {
        if(gameInProgress) {
            var idBtn = 0
            val selectedBlock = v as ImageView
            when (selectedBlock.id) {
                R.id.btn00 -> {
                    idBtn = 1
                    btn00.isClickable = false
                }
                R.id.btn01 -> {
                    idBtn = 2
                    btn01.isClickable = false
                }

                R.id.btn02 -> {
                    idBtn = 3
                    btn02.isClickable = false
                }
                R.id.btn03 -> {
                    idBtn = 4
                    btn03.isClickable = false
                }
                R.id.btn04 -> {
                    idBtn = 5
                    btn04.isClickable = false
                }
                R.id.btn05 -> {
                    idBtn = 6
                    btn05.isClickable = false
                }
                R.id.btn06 -> {
                    idBtn = 7
                    btn06.isClickable = false
                }
                R.id.btn07 -> {
                    idBtn = 8
                    btn07.isClickable = false
                }
                R.id.btn08 -> {
                    idBtn = 9
                    btn08.isClickable = false
                }
            }
            displayCurrentPlayer()
            playTurn(idBtn, selectedBlock)
        }

    }

    private fun newGame() {
        gameInProgress = true
        displayTxtView.setBackgroundResource(android.R.color.transparent)
        displayCurrentPlayer()
        for(button in buttonsArray) {
            button.isClickable = true
        }
        resetBoard()
        resetTimer()

    }


    private fun playTurn(idBtn: Int, block: ImageView) {
        Log.d(TAG, idBtn.toString())
        currentPlayer = if (currentPlayer == 1) {
            block.setImageResource(R.drawable.xpng)
            mapToBoard(1, idBtn)
            sysOutPrintBoard()
            2
        } else {

            block.setImageResource(R.drawable.opng)
            mapToBoard(2, idBtn)
            sysOutPrintBoard()
            1
        }
        displayCurrentPlayer()
        val winner = didWin()

        if(winner != 0) displayWinner(winner)
    }

    private fun displayCurrentPlayer() {
        if(currentPlayer == 1 ) {
            displayTxtView.text = "Player: You"
        } else {
            displayTxtView.text = "Player: TTTBot"
        }
    }

    private fun displayWinner(winner: Int) {
        if(winner.equals(1)) {
            displayTxtView.text = "Player One Wins!"
            Log.d("WINNER", "PLAYER ONE")
        }
        if(winner.equals(2)) {
            displayTxtView.text = "Player Two Wins!"
            Log.d("WINNER", "PLAYER TWO")
        }
        if(winner.equals(3)) {
            displayTxtView.text = "Draw! Try Again"
            Log.d("WINNER", "DRAW")
        }
        pauseTimer()
    }


    private fun initializeBlocksToZero() {

        for (col in 0..2) {
            var tempArray = arrayOf<Int>()
            for (row in 0..2) {
                tempArray += 0
            }
            board.plusAssign(tempArray)
        }
    }

    private fun resetBoard() {

        for(button in buttonsArray) {
            button.setImageResource(0)
        }

        for (i in 0..2) {
            board[0][i] = 0
            for (j in 0..2) {
                board[1][j] = 0
                for (k in 0..2) {
                    board[2][k] = 0
                }
            }
        }
        currentPlayer = 1
    }


    private fun mapToBoard(player: Int, block: Int) {
        when (block) {
            1 -> board[0][0] = player
            2 -> board[0][1] = player
            3 -> board[0][2] = player
            4 -> board[1][0] = player
            5 -> board[1][1] = player
            6 -> board[1][2] = player
            7 -> board[2][0] = player
            8 -> board[2][1] = player
            9 -> board[2][2] = player

        }
    }

    private fun sysOutPrintBoard() {
        for (array in board) {
            for (value in array) {
                print("$value")
            }
            println()
        }
    }

    private fun startTimer() {
        if (!timerRunning) {
            timer.base = SystemClock.elapsedRealtime() - timerPauseOffset
            timer.start()
            timerRunning = true
            gameInProgress = true
        }
    }

    private fun pauseTimer() {
        if (timerRunning) {
            timer.stop()
            timerPauseOffset = SystemClock.elapsedRealtime() - timer.base

            timerRunning = false
            gameInProgress = false
        }
    }

    private fun resetTimer() {
        timer.base = SystemClock.elapsedRealtime()
        timerPauseOffset = 0
    }


}