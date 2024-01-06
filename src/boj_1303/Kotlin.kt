package boj_1303

import java.util.LinkedList
import java.util.StringTokenizer

val DIRECTIONS: Array<Pair<Int, Int>> = arrayOf(1 to 0, -1 to 0, 0 to 1, 0 to -1)

fun main() {
    val st = StringTokenizer(readln())
    val m = st.nextToken().toInt()
    val n = st.nextToken().toInt()
    val map = Array(n) { CharArray(m) }
    repeat(n) { row ->
        val input = readln()
        repeat(m) { col ->
            map[row][col] = input[col]
        }
    }

    val isVisited = Array(n) { BooleanArray(m) }

    var wPowerSum = 0
    var bPowerSum = 0

    for (row in 0 until n) {
        for (col in 0 until m) {
            if (isVisited[row][col]) continue

            isVisited[row][col] = true

            val nextCoords = LinkedList<Pair<Int, Int>>()
            nextCoords.offer(row to col)

            val color = map[row][col]
            var power = 0

            while (nextCoords.isNotEmpty()) {
                val (currentRow, currentCol) = nextCoords.poll()
                ++power

                DIRECTIONS.asSequence()
                    .map { currentRow + it.first to currentCol + it.second }
                    .filter {
                        it.first in 0 until n && it.second in 0 until m &&
                                map[it.first][it.second] == color && !isVisited[it.first][it.second]
                    }
                    .forEach {
                        isVisited[it.first][it.second] = true
                        nextCoords.offer(it)
                    }
            }

            if (color == 'W') {
                wPowerSum += power * power
            } else {
                bPowerSum += power * power
            }
        }
    }

    print("$wPowerSum $bPowerSum")
}
