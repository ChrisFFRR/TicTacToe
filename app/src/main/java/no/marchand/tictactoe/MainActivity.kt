package no.marchand.tictactoe


import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import no.marchand.tictactoe.highscoreDb.HighscoreViewModel
import no.marchand.tictactoe.highscoreDb.User

private lateinit var highscoreModel: HighscoreViewModel

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        highscoreModel = HighscoreViewModel(application)

        highscoreModel.deleteAll()

    }
}

