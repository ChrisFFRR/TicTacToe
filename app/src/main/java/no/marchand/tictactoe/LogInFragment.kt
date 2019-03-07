package no.marchand.tictactoe


import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.support.v4.app.Fragment
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import kotlinx.android.synthetic.main.log_in_fragment.*


class LogInFragment : Fragment() {




    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.log_in_fragment, container, false)


        val logInPrefs: SharedPreferences = activity!!.getSharedPreferences("LoginPrefs", Context.MODE_PRIVATE)
        val editor = logInPrefs.edit()

        val userNameTxtView: EditText = view.findViewById(R.id.editTextUserName)
        val playBtn: Button = view.findViewById(R.id.playBtn)

        playBtn.setOnClickListener {

            editor.putString("UserName", editTextUserName.text.toString())
            editor.commit()
            Log.d("DEBUG", "CLICK")
            Log.d("DEBUG", userNameTxtView.text.toString())

            val goToGame = Intent()
            goToGame.setClass(activity, MainActivity::class.java)
            startActivity(goToGame)
        }

        return view
    }

}

