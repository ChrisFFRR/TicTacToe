package no.marchand.tictactoe.highscoreDb


import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface UserDao{


    @Query("SELECT * FROM Highscore_table ORDER BY time ASC")
    fun getAllUsers(): LiveData<List<User>>

    @Insert
    fun insert(user: User)

    @Query("DELETE FROM Highscore_table")
    fun deleteAllUsers()
}