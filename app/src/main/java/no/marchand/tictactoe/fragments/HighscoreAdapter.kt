package no.marchand.tictactoe.fragments



import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import no.marchand.tictactoe.R
import no.marchand.tictactoe.highscoreDb.User

class HighscoreAdapter internal constructor (context: Context) : RecyclerView.Adapter<HighscoreAdapter.HighscoreHolder>() {

    private val inflater: LayoutInflater = LayoutInflater.from(context)
    private var users = emptyList<User>()


    inner class HighscoreHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

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


    override fun onBindViewHolder(holder: HighscoreHolder, pos: Int) {
      val current = users[pos]

        holder.userName.text = current.user
        holder.userTime.text = current.time.toString() + "  " + "seconds"
    }

    internal fun setUsers(users: List<User>) {
        this.users = users
        notifyDataSetChanged()
    }
}