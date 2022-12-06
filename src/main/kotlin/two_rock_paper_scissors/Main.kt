package two_rock_paper_scissors

/***
 * A/X      Rock        1
 * B/Y      Paper       2
 * C/Z      Scissors    3
 *
 * loss                 0
 * draw                 3
 * win                  6
 */
fun main() {
    print("total score: ${
        input.parse().fold(0) { score, (opponent, me) ->
            score + me.points + me.play(opponent)
        }       
    }\n")

    val allMoves = Move.all()
    print("fixed score: ${
        input.parse().fold(0) { score, (opponent, instruction) ->
            val result = when (instruction) {
                Move.Rock -> 0
                Move.Paper -> 3
                Move.Scissors -> 6
            }
            score + result + allMoves[(opponent.points + instruction.points) % allMoves.size].points
        }
    }")
}

private fun String.parse(): List<Pair<Move, Move>> =
    split("\n").map { round ->
        val moves = round.split(" ")
        Move.parse(moves[0][0]) to Move.parse(moves[1][0])
    }

sealed class Move(val points: Int)
{
    abstract fun play(opponent: Move): Int
    object Rock: Move(1) {
        override fun play(opponent: Move): Int {
            return when (opponent) {
                Rock -> 3
                Paper -> 0
                Scissors -> 6
            }
        }
    }
    object Paper: Move(2) {
        override fun play(opponent: Move): Int {
            return when (opponent) {
                Rock -> 6
                Paper -> 3
                Scissors -> 0
            }
        }
    }
    object Scissors: Move(3) {
        override fun play(opponent: Move): Int {
            return when (opponent) {
                Rock -> 0
                Paper -> 6
                Scissors -> 3
            }
        }
    }

    companion object {
        fun parse(input: Char): Move = when (input) {
            'A', 'X' -> Rock
            'B', 'Y' -> Paper
            else -> Scissors
        }

        fun all(): List<Move> = listOf(Rock, Paper, Scissors)
    }
}
