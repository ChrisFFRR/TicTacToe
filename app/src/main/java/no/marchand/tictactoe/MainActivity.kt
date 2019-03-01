package no.marchand.tictactoe

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.SystemClock
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.Chronometer
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.DataSource
import com.bumptech.glide.load.engine.GlideException
import com.bumptech.glide.load.resource.gif.GifDrawable
import com.bumptech.glide.request.RequestListener
import com.bumptech.glide.request.target.Target
import kotlinx.android.synthetic.main.activity_main.*

var board = mutableListOf<Array<Int>>()

private val TAG = "The debugger is saying"
private var currentPlayer = 1

class MainActivity : AppCompatActivity(), View.OnClickListener {
    private var timerRunning: Boolean = false
    private var timerPauseOffset: Long = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initializeBlocksToZero()


        val btn00: ImageView = findViewById(R.id.btn00)
        btn00.isClickable = false
        val btn01: ImageView = findViewById(R.id.btn01)
        btn01.isClickable = false
        val btn02: ImageView = findViewById(R.id.btn02)
        btn02.isClickable = false
        val btn03: ImageView = findViewById(R.id.btn03)
        btn03.isClickable = false
        val btn04: ImageView = findViewById(R.id.btn04)
        btn04.isClickable = false
        val btn05: ImageView = findViewById(R.id.btn05)
        btn05.isClickable = false
        val btn06: ImageView = findViewById(R.id.btn06)
        btn06.isClickable = false
        val btn07: ImageView = findViewById(R.id.btn07)
        btn07.isClickable = false
        val btn08: ImageView = findViewById(R.id.btn08)
        btn08.isClickable = false


        val startBtn: Button = findViewById(R.id.startBtn)
        val pauseBtn: Button = findViewById(R.id.pauseBtn)

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
            newGame()
            startTimer()
        }
        pauseBtn.setOnClickListener {
            pauseTimer()
        }

    }

    override fun onClick(v: View?) {
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
        playTurn(idBtn, selectedBlock)

    }

    private fun newGame() {
        currentPlayer = 1
        btn00.isClickable = true
        btn01.isClickable = true
        btn02.isClickable = true
        btn03.isClickable = true
        btn04.isClickable = true
        btn05.isClickable = true
        btn06.isClickable = true
        btn07.isClickable = true
        btn08.isClickable = true
        resetBoard()

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
        val winner = didWin()

        if(winner != 0) displayWinner(winner)
    }

    private fun displayWinner(winner: Int) {
        if(winner.equals(1)) {
            Log.d("WINNER", "PLAYER ONE")
        }
        if(winner.equals(2)) {
            Log.d("WINNER", "PLAYER TWO")
        }
        if(winner.equals(3)) {
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
        }
    }

    private fun pauseTimer() {
        if (timerRunning) {
            timer.stop()
            timerPauseOffset = SystemClock.elapsedRealtime() - timer.base

            timerRunning = false
        }
    }
}
