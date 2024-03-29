package no.marchand.tictactoe.fragments

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.os.SystemClock
import android.preference.PreferenceManager
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import kotlinx.android.synthetic.main.game_screen_fragment.*
import no.marchand.tictactoe.BotModel
import no.marchand.tictactoe.GameBoardModel
import no.marchand.tictactoe.R
import no.marchand.tictactoe.highscoreDb.HighscoreViewModel
import no.marchand.tictactoe.highscoreDb.User



private val TAG = "The debugger is saying"

    var timesPlayed = 0

class GameScreenFragment : Fragment(), View.OnClickListener {

    var board = GameBoardModel()
    var bot = BotModel(board)

    var gameInProgress = false
    private var currentPlayer = 1

    private var timerRunning: Boolean = false
    private var timerPauseOffset: Long = 0
    private lateinit var loadPrefs: SharedPreferences
    private lateinit var highScoreModel: HighscoreViewModel
    private var userName = ""
    private var gameType = ""
    private var buttonsArray = mutableListOf<ImageView>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        highScoreModel = HighscoreViewModel(activity!!.application)

    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        loadPrefs = PreferenceManager.getDefaultSharedPreferences(context)!!
        userName = loadPrefs.getString("USERNAME", "")!!
        gameType = loadPrefs.getString("GAMETYPE", "")!!
        Log.d("USERNAME ", userName)
        Log.d("GAMETYPE  ", gameType)





        val view = inflater.inflate(R.layout.game_screen_fragment, container, false)

        buttonsArray.clear()

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
        val logoutBtn: Button = view.findViewById(R.id.logoutBtn)
        val highscoreBtn: Button = view.findViewById(R.id.highscoreBtn)

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
            if ((!timerRunning) && (timesPlayed == 0) && (!gameInProgress)) {
                newGame()
                startTimer()
            } else {
                startTimer()
            }
        }
        pauseBtn.setOnClickListener {
            pauseTimer()
        }

        logoutBtn.setOnClickListener {
            loadPrefs.edit().remove("USERNAME")
            loadPrefs.edit().remove("GAMETYPE")
            loadPrefs.edit().apply()
            timesPlayed = 0
            board.resetBoard()
            Navigation.findNavController(view).navigate(R.id.logInFragment)
        }

        highscoreBtn.setOnClickListener {
            Navigation.findNavController(view).navigate(R.id.highscoreFragment)
        }

        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        if (userName.isEmpty()) {
            Navigation.findNavController(view).navigate(R.id.logInFragment)
        }
    }

    override fun onClick(v: View?) {
        if (gameInProgress) {
            val selectedBlock = v as ImageView
            val xCoordinate: Int = selectedBlock.contentDescription.substring(1, 2).toInt()
            val yCoordinate: Int = selectedBlock.contentDescription.substring(2, 3).toInt()

            if (board.readValue(xCoordinate, yCoordinate) == 0) {
                board.setValue(xCoordinate, yCoordinate, currentPlayer)
                gameLoop()
            }
        }
    }

    private fun newGame() {
        timesPlayed = 0
        gameInProgress = true
        currentPlayer = 1


        displayCurrentPlayer()

        for (button in buttonsArray) {
            button.isClickable = true
        }
        board.resetBoard()
        reDrawBoard()
        resetTimer()

    }


    private fun gameLoop() {
        timesPlayed++
        Log.d("times played ", timesPlayed.toString())
        displayCurrentPlayer()
        reDrawBoard()
        var winner = board.determineWinner()

        if (winner != -1) {
            gameInProgress = false
            displayWinner(winner)
        }

        if(gameInProgress) {
            if (currentPlayer == 1) {
                currentPlayer = 2
                if(gameType == "bot") {

                    bot.randomMove()
                    gameLoop()
                }
                if(gameType == "friend") {
                    displayCurrentPlayer()
                }
            } else {
                currentPlayer = 1
                displayCurrentPlayer()
            }
        }
    }

    private fun reDrawBoard() {
        for (index in 0 until board.board.size) {
            val imageView = buttonsArray[index]
            val player = board.board[index]
            if (player == 1) {
                imageView.setImageResource(R.drawable.xpng)
                imageView.isClickable = false
            } else if (player == 2) {
                imageView.setImageResource(R.drawable.opng)
                imageView.isClickable = false
            } else {
                imageView.setImageResource(0)
            }
        }

    }


    private fun displayCurrentPlayer() {
        if(gameType == "bot") {
            if (currentPlayer == 1) {
                textViewCurrentPlayer.text = getString(R.string.display_current_playerOne) + userName
            } else {
                textViewCurrentPlayer.text = getString(R.string.display_current_tttBot)
            }
        }
        if(gameType == "friend") {
            if (currentPlayer == 1) {
                textViewCurrentPlayer.text = "Player: " + userName
            } else {
                textViewCurrentPlayer.text = "Player: $userName's friend"
            }
        }
    }


    private fun displayWinner(winner: Int) {
        timesPlayed = 0
        gameInProgress = false

        if (winner == 1) {
            textViewCurrentPlayer.text = "$userName Wins!"
            Log.d("WINNER", "PLAYER ONE")
            highScoreModel.insert(User(0, userName, ((SystemClock.elapsedRealtime() - timer.base) / 1000)))
        }
        if (winner == 2) {
            if (gameType == "bot") {
                textViewCurrentPlayer.text = getString(R.string.result_display_tttBot_win)
                Log.d("WINNER", "PLAYER TWO")
                highScoreModel.insert(User(0, "TTTbot", (SystemClock.elapsedRealtime() - timer.base) / 1000))
            } else {
                textViewCurrentPlayer.text = userName + getString(R.string.result_display_friend_win)
                Log.d("WINNER", "PLAYER TWO")
                highScoreModel.insert(
                    User(
                        0,
                        "$userName's friend",
                        (SystemClock.elapsedRealtime() - timer.base) / 1000
                    )
                )
            }
        }


        if (winner == 3) {
            textViewCurrentPlayer.text = getString(R.string.result_display_draw)
            currentPlayer = 1

            Log.d("WINNER", "DRAW")
        }

        pauseTimer()
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