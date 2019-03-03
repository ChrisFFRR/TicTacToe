package no.marchand.tictactoe

import android.util.Log

var timesPlayed = 0


fun didWin(): Int {


    if (timesPlayed < 7 && gameInProgress) {
        for (col in 0..2) {
            for (i in 0..2) {

                //Check for 3 in a row horizontal first row - X or O
                if (board[0][0].equals(1) && board[0][1].equals(1) && board[0][2].equals(1)) {
                    Log.d("debug", "player one wins")
                    //gameInProgress = false
                    return 1
                } else if (board[0][0].equals(2) && board[0][1].equals(2) && board[0][2].equals(2)) {
                    Log.d("debug", "player one wins")
                   // gameInProgress = false
                    return 2
                }

                //Check for 3 in a row horizontal second row - X or O
                if (board[1][0].equals(1) && board[1][1].equals(1) && board[1][2].equals(1)) {
                    Log.d("debug", "player one wins")
                   // gameInProgress = false
                    return 1
                } else if (board[1][0].equals(2) && board[1][1].equals(2) && board[1][2].equals(2)) {
                    Log.d("debug", "player two wins")
                    //gameInProgress = false
                    return 2
                }

                //Check for 3 in a row horizontal third row - X or O
                if (board[2][0].equals(1) && board[2][1].equals(1) && board[2][2].equals(1)) {
                    Log.d("debug", "player one wins")
                    //gameInProgress = false
                    return 1
                } else if (board[2][0].equals(2) && board[2][1].equals(2) && board[2][2].equals(2)) {
                    Log.d("debug", "player two wins")
                    //gameInProgress = false
                    return 2
                }

                //Check for 3 in a row vertical first column - X or O
                if (board[0][0].equals(1) && board[1][0].equals(1) && board[2][0].equals(1)) {
                    Log.d("debug", "player one wins")
                   // gameInProgress = false
                    return 1
                } else if (board[0][0].equals(2) && board[1][0].equals(2) && board[2][0].equals(2)) {
                    Log.d("debug", "player two wins")
                   // gameInProgress = false
                    return 2
                }

                //Check for 3 in a row vertical second column - X or O
                if (board[0][1].equals(1) && board[1][1].equals(1) && board[2][1].equals(1)) {
                    Log.d("debug", "player one wins")
                    //gameInProgress = false
                    return 1
                } else if (board[0][1].equals(2) && board[1][1].equals(2) && board[2][1].equals(2)) {
                    Log.d("debug", "player two wins")
                   // gameInProgress = false
                    return 2
                }

                //Check for 3 in a row vertical third column - X or O
                if (board[0][2].equals(1) && board[1][2].equals(1) && board[2][2].equals(1)) {
                    Log.d("debug", "player one wins")
                   // gameInProgress = false
                    return 1
                } else if (board[0][2].equals(2) && board[1][2].equals(2) && board[2][2].equals(2)) {
                    Log.d("debug", "player two wins")
                    //gameInProgress = false
                    return 2
                }

                //Check for 3 in a row horizontal - X or O
                if (board[0][0].equals(1) && board[1][1].equals(1) && board[2][2].equals(1)
                    || (board[0][2].equals(1) && board[1][1].equals(1) && board[2][0].equals(1))
                ) {
                    Log.d("debug", "player one wins")
                   // gameInProgress = false
                    return 1
                } else if (board[0][0].equals(2) && board[1][1].equals(2) && board[2][2].equals(2)
                    || (board[0][2].equals(2) && board[1][1].equals(2) && board[2][0].equals(2))
                ) {
                    Log.d("debug", "player two wins")
                   // gameInProgress = false
                    return 2
                }
            }
        }
        timesPlayed = timesPlayed.inc()
        Log.d("times played", timesPlayed.toString())
        return 0
    } else {
        Log.d("debug", "draw")
       // gameInProgress = false
        return 3
        timesPlayed = 0
    }

}



