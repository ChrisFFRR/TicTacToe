package no.marchand.tictactoe.highscoreDb


import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Highscore_table")

data class User(
    @PrimaryKey var id: Int = 0,
    @ColumnInfo(name = "name") var user: String?,
    @ColumnInfo(name = "time") var time: Long?

    )