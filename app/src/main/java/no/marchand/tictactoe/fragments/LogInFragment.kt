package no.marchand.tictactoe.fragments


import android.content.Context

import android.content.SharedPreferences
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import kotlinx.android.synthetic.main.log_in_fragment.*
import no.marchand.tictactoe.R


class LogInFragment : Fragment() {


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.log_in_fragment, container, false)


        val logInPrefs: SharedPreferences = context!!.getSharedPreferences("LoginPrefs", Context.MODE_PRIVATE)
        val editor = logInPrefs.edit()

        val playBtn: Button = view.findViewById(R.id.playBtn)

        playBtn.setOnClickListener {
            editor.putString("UserName", editTextUserName.text.toString())
            editor.apply()

            Log.d("DEBUG", logInPrefs.getString("UserName", ""))
            if (logInPrefs.getString("UserName", "").isNotEmpty()) {
                Navigation.findNavController(view).navigate(R.id.gameScreenFragment)
            }
        }
        return view
    }
}

