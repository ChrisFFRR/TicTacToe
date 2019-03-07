package no.marchand.tictactoe

import android.content.Context
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

private var EMPTY = ""

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val logInPreferences = getSharedPreferences("loginPref", Context.MODE_PRIVATE)

        if (logInPreferences.getString("UserName", EMPTY) !== EMPTY) {
            setContentView(R.layout.activity_main)
        } else {
            setContentView(R.layout.log_in_fragment)
            Log.d("DEBUG", "LOGIN")
        }
    }
}
