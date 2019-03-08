package no.marchand.tictactoe.highscoreDb


import androidx.annotation.WorkerThread
import androidx.lifecycle.LiveData

class HighscoreRepository(private val userDao: UserDao) {

    val allUsers: LiveData<List<User>> = userDao.getAllUsers()

    @WorkerThread
     fun insert(user: User) {
        userDao.insert(user)
    }
}