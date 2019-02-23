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

class MainActivity : AppCompatActivity(), View.OnClickListener {

    private val TAG = "The debugger is saying"

    private val playerX = 1
    private val playerO = 2
    private val emptyBlock = 0


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


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

    private fun loadXGif(imageView: ImageView) {

        Glide.with(this)
            .asGif()
            .listener(listenerStopGif())
            .load(R.drawable.x)
            .fitCenter()
            .into(imageView)

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
        if (v != null) {
            when(v.id) {
               R.id.btn00 -> {
                   loadXGif(btn00)
                   btn00.isClickable = false
                   Log.d(TAG, "click")
               }
                R.id.btn01 -> {
                    loadOGif(btn01)
                }
                R.id.btn02 -> {

                }
            }
        }
    }
}
