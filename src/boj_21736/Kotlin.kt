package boj_21736

import java.util.LinkedList
import java.util.StringTokenizer

fun main() {
    val st = StringTokenizer(readln())
    val n = st.nextToken().toInt()
    val m = st.nextToken().toInt()

    val map = Array(n) { CharArray(m) }
    val nextCoords = LinkedList<Pair<Int, Int>>()
    repeat(n) { row ->
        val line = readln()
        repeat(m) { col ->
            map[row][col] = line[col]
            if (map[row][col] == 'I') nextCoords.offer(row to col)
        }
    }

    val directions = sequenceOf(1 to 0, -1 to 0, 0 to 1, 0 to -1)
    val rowRange = 0 until n
    val colRange = 0 until m
    var count = 0
    while (nextCoords.isNotEmpty()) {
        val (row, col) = nextCoords.poll()

        directions.map { row + it.first to col + it.second }
            .filter { it.first in rowRange }
            .filter { it.second in colRange }
            .filter { map[it.first][it.second] == 'O' || map[it.first][it.second] == 'P' }
            .forEach {
                if (map[it.first][it.second] == 'P') ++count
                map[it.first][it.second] = 'X'
                nextCoords.offer(it)
            }
    }

    if (count == 0) return print("TT")
    print(count)
}
