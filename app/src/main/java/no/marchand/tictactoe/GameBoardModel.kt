package no.marchand.tictactoe

import no.marchand.tictactoe.fragments.GameScreenFragment


class GameBoardModel(private var size: Int = 3) {
    var board: IntArray = IntArray(size * size) { 0 }

    fun setValue(x: Int, y: Int, player: Int) {
        board[x + y * size] = player
    }

    fun readValue(x: Int, y: Int): Int {
        return board[x + y * size]
    }

    fun resetBoard() {
        board.fill(0, 0, board.size)


    }

    fun determineWinner(): Int {


            // Horizontal winner
            for (row in 0 until size) {
                if (readValue(0, row) == readValue(1, row) && readValue(1, row) == readValue(2, row) && ((readValue(0, row) != 0))) {
                    return readValue(0, row)
                }
            }
            // Vertical winner
            for (col in 0 until size) {
                if (readValue(col, 0) == readValue(col, 1) && readValue(col, 1) == readValue(col, 2) && ((readValue(col, 0) != 0))
                ) {
                    return readValue(0, col)
                }
            }
            // Diagonal winner
            if ((readValue(0, 0) == readValue(1, 1) && readValue(1, 1) == readValue(2, 2)) ||
                (readValue(0, 2) == readValue(1, 1) && readValue(1, 1) == readValue(2, 0))
            ) {

                if (readValue(1, 1) != 0) {
                    return readValue(1, 1)
                }
            }
        if(checkForDraw()) {
            return 3
        }

        return -1
    }


   private fun checkForDraw(): Boolean {
       var i = 0
       if(i < 2) {
           for (value in 0 until board.size) {
               if (board[value] != 1 && board[value] != 2) {
                   return false
               }
           }
           i++
       }
       return true
   }




}






