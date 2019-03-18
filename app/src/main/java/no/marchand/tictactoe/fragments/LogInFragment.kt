package no.marchand.tictactoe.fragments


import android.content.Context

import android.content.SharedPreferences
import android.os.Bundle
import android.preference.PreferenceManager
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import kotlinx.android.synthetic.main.log_in_fragment.*
import no.marchand.tictactoe.R


class LogInFragment : Fragment() {


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.log_in_fragment, container, false)

        val logInPrefs: SharedPreferences = PreferenceManager.getDefaultSharedPreferences(context)
        val editor = logInPrefs.edit()




        val playWithBotBtn: Button = view.findViewById(R.id.playBtn)
        val playAlonebtn: Button = view.findViewById(R.id.onePlayerBtn)

        playAlonebtn.setOnClickListener {
            saveToSharedPref(editor)
            if (logInPrefs.getString("USERNAME", "").isNotEmpty()) {
                editor.putString("GAMETYPE", "friend")
                editor.apply()
                Navigation.findNavController(view).navigate(R.id.gameScreenFragment)
            }
        }

        playWithBotBtn.setOnClickListener {
            saveToSharedPref(editor)
            editor.putString("GAMETYPE", "bot")
            editor.apply()
            Log.d("DEBUG", logInPrefs.getString("USERNAME", ""))
            Log.d("DEBUG", logInPrefs.getString("GAMETYPE", ""))
            if (logInPrefs.getString("UserName", "").isNotEmpty()) {

                Navigation.findNavController(view).navigate(R.id.gameScreenFragment)
            }
        }
        return view
    }

    private fun saveToSharedPref(editor: SharedPreferences.Editor) {
        editor.putString("USERNAME", editTextUserName.text.toString())
        editor.apply()
    }
}

