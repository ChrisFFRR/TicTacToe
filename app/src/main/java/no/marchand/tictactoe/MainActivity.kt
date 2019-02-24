package no.marchand.tictactoe

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.DataSource
import com.bumptech.glide.load.engine.GlideException
import com.bumptech.glide.load.resource.gif.GifDrawable
import com.bumptech.glide.request.RequestListener
import com.bumptech.glide.request.target.Target
import kotlinx.android.synthetic.main.activity_main.*

//var board = arrayOf<Array<Int>>()
var board = mutableListOf<Array<Int>>()

private val TAG = "The debugger is saying"
private var currentPlayer = 1

class MainActivity : AppCompatActivity(), View.OnClickListener {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initializeBlocksToZero()



        val btn00: ImageView = findViewById(R.id.btn00)
        btn00.isClickable = true
        val btn01: ImageView = findViewById(R.id.btn01)
        btn01.isClickable = true
        val btn02: ImageView = findViewById(R.id.btn02)
        btn02.isClickable = true
        val btn03: ImageView = findViewById(R.id.btn03)
        btn03.isClickable = true
        val btn04: ImageView = findViewById(R.id.btn04)
        btn04.isClickable = true
        val btn05: ImageView = findViewById(R.id.btn05)
        btn05.isClickable = true
        val btn06: ImageView = findViewById(R.id.btn06)
        btn06.isClickable = true
        val btn07: ImageView = findViewById(R.id.btn07)
        btn07.isClickable = true
        val btn08: ImageView = findViewById(R.id.btn08)
        btn08.isClickable = true

        btn00.setOnClickListener(this)
        btn01.setOnClickListener(this)
        btn02.setOnClickListener(this)
        btn03.setOnClickListener(this)
        btn04.setOnClickListener(this)
        btn05.setOnClickListener(this)
        btn06.setOnClickListener(this)
        btn07.setOnClickListener(this)
        btn08.setOnClickListener(this)
    }

    fun loadXGif(imageView: ImageView) {

        Glide.with(this)
            .asGif()
            .listener(listenerStopGif())
            .load(R.drawable.x)
            .fitCenter()
            .into(imageView)
        /*.into(object : ImageViewTarget<GifDrawable>(imageView) {
            override fun setResource(resource: GifDrawable?) {
                resource?.setLoopCount(1)

            }

        })*/
    }


    private fun loadOGif(imageView: ImageView) {

        Glide.with(this)
            .asGif()
            .listener(listenerStopGif())
            .load(R.drawable.o)
            .fitCenter()
            .into(imageView)
    }

    private fun listenerStopGif(): RequestListener<GifDrawable> {
        return object : RequestListener<GifDrawable> {
            override fun onLoadFailed(
                e: GlideException?,
                model: Any?,
                target: Target<GifDrawable>?,
                isFirstResource: Boolean
            ): Boolean {
                return false
            }

            override fun onResourceReady(
                resource: GifDrawable?,
                model: Any?,
                target: Target<GifDrawable>?,
                dataSource: DataSource?,
                isFirstResource: Boolean
            ): Boolean {
                resource?.setLoopCount(1)

                return false
            }

        }
    }


    override fun onClick(v: View?) {
        var idBtn = 0
        var selectedBlock = v as ImageView
        if (selectedBlock != null) {
            when (selectedBlock.id) {
                R.id.btn00 -> {
                    idBtn = 1
                    btn00.isClickable = false
                    Log.d(TAG, "click")
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
        }
        playTurn(idBtn, selectedBlock)

    }

    private fun playTurn(idBtn: Int, block: ImageView) {

        Log.d(TAG, idBtn.toString())
        if (currentPlayer == 1) {
            //loadXGif(block)
            block.setImageResource(R.drawable.xpng)
            mapToBoard(1, idBtn)
            sysOutPrintBoard()
            //currentPlayer = 2
        } else {
            block.setImageResource(R.drawable.opng)
            mapToBoard(2, idBtn)
            currentPlayer = 1
        }

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
            for(j in 0..2) {
                board[1][j] = 0
                for(k in 0..2) {
                    board[2][k] = 0
                }
            }
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
}
