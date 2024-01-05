package boj_3184

import java.util.LinkedList
import java.util.StringTokenizer

val DIRECTIONS: Array<Pair<Int, Int>> = arrayOf(1 to 0, -1 to 0, 0 to 1, 0 to -1)

fun main() {
    val st = StringTokenizer(readln())
    val n = st.nextToken().toInt()
    val m = st.nextToken().toInt()

    val map = Array(n) { CharArray(m) }
    repeat(n) { row ->
        val input = readln()
        repeat(m) { col ->
            map[row][col] = input[col]
        }
    }

    val isVisited = Array(n) { BooleanArray(m) }

    var sheepCountSum = 0
    var wolfCountSum = 0

    for (row in 0 until n) {
        for (col in 0 until m) {
            if (map[row][col] == '#' || isVisited[row][col]) continue

            isVisited[row][col] = true

            val nextCoords = LinkedList<Pair<Int, Int>>()
            nextCoords.offer(row to col)

            var sheepCount = 0
            var wolfCount = 0

            while (nextCoords.isNotEmpty()) {
                val (currentRow, currentCol) = nextCoords.poll()

                when (map[currentRow][currentCol]) {
                    'o' -> ++sheepCount
                    'v' -> ++wolfCount
                    else -> Unit
                }

                DIRECTIONS.asSequence()
                    .map { currentRow + it.row to currentCol + it.col }
                    .filter {
                        it.row in 0 until n && it.col in 0 until m &&
                                map[it.row][it.col] != '#' && !isVisited[it.row][it.col]
                    }
                    .forEach {
                        isVisited[it.row][it.col] = true
                        nextCoords.offer(it)
                    }
            }

            if (wolfCount < sheepCount) wolfCount = 0 else sheepCount = 0
            sheepCountSum += sheepCount
            wolfCountSum += wolfCount
        }
    }

    print("$sheepCountSum $wolfCountSum")
}

val Pair<Int, Int>.row: Int
    get() = first

val Pair<Int, Int>.col: Int
    get() = second
