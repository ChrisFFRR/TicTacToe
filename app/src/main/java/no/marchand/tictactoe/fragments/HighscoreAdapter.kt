package no.marchand.tictactoe.fragments


import android.app.Application
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TableRow
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import no.marchand.tictactoe.R
import no.marchand.tictactoe.highscoreDb.HighscoreRepository
import no.marchand.tictactoe.highscoreDb.HighscoreViewModel
import no.marchand.tictactoe.highscoreDb.User

class HighscoreAdapter internal constructor (context: Context) : RecyclerView.Adapter<HighscoreAdapter.HighscoreHolder>() {

    private val inflater: LayoutInflater = LayoutInflater.from(context)
    private var users = emptyList<User>()


    inner class HighscoreHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val userItemView: TableRow = itemView.findViewById(R.id.UserItemViewTableRow)
        val userPos: TextView = itemView.findViewById(R.id.highScorePositionView)
        val userName: TextView = itemView.findViewById(R.id.highScorePlayerNameView)
        val userTime: TextView = itemView.findViewById(R.id.highscoreTimeView)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HighscoreHolder {
       val userView = inflater.inflate(R.layout.high_score_item, parent, false)
        return HighscoreHolder(userView)
    }

    override fun getItemCount(): Int {
     return users.size
    }

    //Sikkert feil
    override fun onBindViewHolder(holder: HighscoreHolder, pos: Int) {
      val current = users[pos]
        holder.userPos.text = current.user
        holder.userName.text = current.user
        holder.userTime.text = current.user
    }

    internal fun setUsers(users: List<User>) {
        this.users = users
        notifyDataSetChanged()
    }
}