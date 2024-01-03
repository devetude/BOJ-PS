package boj_2210

import java.util.StringTokenizer

val VALID_COORDINATE_RANGE: IntRange = 0 until 5
val DIRECTIONS: Array<Pair<Int, Int>> = arrayOf(1 to 0, -1 to 0, 0 to 1, 0 to -1)

fun main() {
    val board = Array(size = 5) { IntArray(size = 5) }
    repeat(times = 5) { row ->
        val st = StringTokenizer(readln())
        repeat(times = 5) { col -> board[row][col] = st.nextToken().toInt() }
    }

    val result = HashSet<Int>()
    repeat(times = 5) { row ->
        repeat(times = 5) { col ->
            val startCoordinate = row to col
            search(board, startCoordinate, result)
        }
    }

    println(result.size)
}

fun search(
    board: Array<IntArray>,
    currentCoordinate: Pair<Int, Int>,
    result: HashSet<Int>,
    sb: StringBuilder = StringBuilder()
) {
    if (sb.length == 6) {
        result.add(sb.toString().toInt())
        return
    }

    DIRECTIONS.asSequence()
        .map { direction -> currentCoordinate + direction }
        .filter { nextCoordinate -> nextCoordinate.isInValidRange() }
        .forEach { nextCoordinate ->
            sb.append(board[nextCoordinate.row][nextCoordinate.col])
            search(board, nextCoordinate, result, sb)
            sb.deleteAt(sb.lastIndex)
        }
}

val Pair<Int, Int>.row: Int
    get() = first

val Pair<Int, Int>.col: Int
    get() = second

operator fun Pair<Int, Int>.plus(other: Pair<Int, Int>): Pair<Int, Int> =
    row + other.row to col + other.col

fun Pair<Int, Int>.isInValidRange(): Boolean =
    row in VALID_COORDINATE_RANGE && col in VALID_COORDINATE_RANGE
