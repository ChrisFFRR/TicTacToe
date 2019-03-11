package no.marchand.tictactoe.highscoreDb

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import kotlin.coroutines.CoroutineContext

class HighscoreViewModel(application: Application) : AndroidViewModel(application) {

    private val repository: HighscoreRepository
     val allUsers: LiveData<List<User>>

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

    fun deleteAll() = scope.launch(Dispatchers.IO) {
        repository.deleteAll()
    }

    fun getAll(): LiveData<List<User>> {
        return repository.allUsers
    }

    override fun onCleared() {
        super.onCleared()
        parentJob.cancel()
    }


}