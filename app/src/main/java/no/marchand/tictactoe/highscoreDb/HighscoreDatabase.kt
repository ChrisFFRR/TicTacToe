package no.marchand.tictactoe.highscoreDb

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [User::class], version = 3, exportSchema = false)
abstract class HighscoreDatabase : RoomDatabase() {

    abstract fun userDao(): UserDao


    companion object {
        @Volatile
        private var INSTANCE: HighscoreDatabase? = null

        fun getDatabase(context: Context): HighscoreDatabase {
            return INSTANCE ?: synchronized(this) {
                // Create database here
                val instance = Room.databaseBuilder(
                context.applicationContext,
                HighscoreDatabase::class.java,
                "Highscore_database"
            ).fallbackToDestructiveMigration().build()
                    INSTANCE = instance
                instance
            }
        }

    }
}

