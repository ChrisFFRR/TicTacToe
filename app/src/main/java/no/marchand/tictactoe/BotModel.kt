package no.marchand.tictactoe



import kotlin.random.Random


class BotModel(private val gameBoard: GameBoardModel) {
    var timesPlayed = GameUtil()

    fun randomMove() {
        val randomNumber = Random.nextInt(0, 8)

         if (timesPlayed.timesPlayed < 9) {
            if (gameBoard.board[randomNumber] == 0) {
                gameBoard.board[randomNumber] = 2
            } else {
                randomMove()
            }
        }
    }
}