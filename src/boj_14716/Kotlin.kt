package boj_14716

import java.util.LinkedList
import java.util.StringTokenizer

fun main() {
    var st = StringTokenizer(readln())
    val n = st.nextToken().toInt()
    val m = st.nextToken().toInt()

    val map = Array(n) { BooleanArray(m) }
    val nextCoords = LinkedList<Pair<Int, Int>>()
    repeat(n) { row ->
        st = StringTokenizer(readln())
        repeat(m) { col -> map[row][col] = st.nextToken() == "1" }
    }

    val directions = sequenceOf(
        -1 to -1, -1 to 0, -1 to 1,
        0 to -1, 0 to 1,
        1 to -1, 1 to 0, 1 to 1
    )
    val rowRange = 0 until n
    val colRange = 0 until m
    var length = 0
    for (startRow in rowRange) {
        for (startCol in colRange) {
            if (!map[startRow][startCol]) continue

            map[startRow][startCol] = false
            nextCoords.offer(startRow to startCol)
            ++length

            while (nextCoords.isNotEmpty()) {
                val (row, col) = nextCoords.poll()

                directions.map { row + it.first to col + it.second }
                    .filter { it.first in rowRange }
                    .filter { it.second in colRange }
                    .filter { map[it.first][it.second] }
                    .forEach {
                        map[it.first][it.second] = false
                        nextCoords.offer(it)
                    }
            }
        }
    }

    print(length)
}
