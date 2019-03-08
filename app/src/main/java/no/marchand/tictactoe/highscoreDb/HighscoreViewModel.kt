package no.marchand.tictactoe.highscoreDb

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import no.marchand.tictactoe.highscoreDb.HighscoreDatabase
import no.marchand.tictactoe.highscoreDb.HighscoreRepository
import no.marchand.tictactoe.highscoreDb.User
import kotlin.coroutines.CoroutineContext

class HighscoreViewModel(application: Application) : AndroidViewModel(application) {

    private val repository: HighscoreRepository
    private val allUsers: LiveData<List<User>>

    init {
        val userDao = HighscoreDatabase.getDatabase(application).userDao()
        repository = HighscoreRepository(userDao)
        allUsers = repository.allUsers
    }

    private var parentJob = Job()
    private val coroutineContext: CoroutineContext
        get() = parentJob + Dispatchers.Main
    private val scope = CoroutineScope(coroutineContext)

    fun insert(user: User) = scope.launch(Dispatchers.IO) {
        repository.insert(user)
    }

    override fun onCleared() {
        super.onCleared()
        parentJob.cancel()
    }


}