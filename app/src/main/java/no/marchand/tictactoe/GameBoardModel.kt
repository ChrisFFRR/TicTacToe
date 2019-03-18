package no.marchand.tictactoe




class GameBoardModel(private var size: Int = 3) {
    var timesPlayed = GameUtil()
    var board: IntArray = IntArray(size * size) { 0 }

    fun setValue(x: Int, y: Int, player: Int) {
        board[x + y * size] = player
    }

    fun readValue(x: Int, y: Int): Int {
        return board[x + y * size]
    }

    fun resetBoard() {
        board.fill(0, 0, board.size - 1)
        timesPlayed.resetTimesPlayed()

    }

    fun determineWinner(): Int {
        // Horizontal winner

        for (row in 0 until size) {
            if (readValue(0, row) == readValue(1, row) && readValue(1, row) == readValue(2, row) && ((readValue(
                    0,
                    row
                ) != 0))
            ) {
                return readValue(0, row)
            }
        }
        // Vertical winner
        for (col in 0 until size) {
            if (readValue(col, 0) == readValue(col, 1) && readValue(col, 1) == readValue(col, 2) && ((readValue(
                    col,
                    0
                ) != 0))
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
        return -1
    }

    /*
    fun checkForDraw(): Int {
        for(col in 0 until size) {
            if(readValue)
        }
    }
    */



}






