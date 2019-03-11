package no.marchand.tictactoe.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import no.marchand.tictactoe.R
import no.marchand.tictactoe.highscoreDb.HighscoreViewModel

class HighscoreFragment : Fragment() {

    lateinit var highscoreViewModel: HighscoreViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        val view = inflater.inflate(R.layout.high_score_fragment, container, false)

        highscoreViewModel = HighscoreViewModel(activity!!.application)

        val recyclerView = view.findViewById<RecyclerView>(R.id.HighscoreRecyclerView)
        val adapter = HighscoreAdapter(this.context!!)

        highscoreViewModel.allUsers.observe(this, Observer { users ->
            users.forEach { _ ->
                adapter.setUsers(users)


            }
        })

        recyclerView.layoutManager = LinearLayoutManager(this.context!!)
        recyclerView.adapter = adapter
        return view
    }
}