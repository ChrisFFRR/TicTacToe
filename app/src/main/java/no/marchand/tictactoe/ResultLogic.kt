package no.marchand.tictactoe

import android.util.Log

var timesPlayed = 0

fun didWin() {


    if (timesPlayed < 8) {
        for (col in 0..2) {
            for (i in 0..2) {

                /*
                111
                000
                000
                 */
                if (board[0][0] === 1 && board[0][1] === 1 && board[0][2] === 1) {
                    Log.d("debug", "player one wins")
                }
                /*
                000
                111
                000
                 */
                if (board[1][0] === 1 && board[1][1] === 1 && board[1][2] === 1) {
                    Log.d("debug", "player one wins")
                }
                /*
                000
                000
                111
                 */
                if (board[2][0] === 1 && board[2][1] === 1 && board[2][2] === 1) {
                    Log.d("debug", "player one wins")
                }
                /*
                100
                100
                100
                 */
                if (board[0][0] === 1 && board[1][0] === 1 && board[2][0] === 1) {
                    Log.d("debug", "player one wins")
                }
                /*
                010
                010
                010
                 */
                if (board[0][1] === 1 && board[1][1] === 1 && board[2][1] === 1) {
                    Log.d("debug", "player one wins")
                }
                /*
                001
                001
                001
                 */
                if (board[0][2] === 1 && board[1][2] === 1 && board[2][2] === 1) {
                    Log.d("debug", "player one wins")
                }
                /*
               100   001
               010 & 010
               001   100
                */

                if ((board[0][0] === 1 && board[1][1] === 1 && board[2][2] === 1)
                    || (board[0][2] === 1 && board[1][1] === 1 && board[2][0] === 1)
                ) {
                    Log.d("debug", "player one wins")
                }
            }
        }
        timesPlayed = timesPlayed.inc()
        Log.d("times played", timesPlayed.toString())
    } else {
        Log.d("debug", "draw")
        timesPlayed = 0
    }

}



