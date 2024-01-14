package boj_13565

import java.util.LinkedList
import java.util.StringTokenizer

fun main() {
    val st = StringTokenizer(readln())
    val n = st.nextToken().toInt()
    val m = st.nextToken().toInt()

    val map = Array(n) { BooleanArray(m) }
    val nextCoords = LinkedList<Pair<Int, Int>>()
    repeat(n) { row ->
        val line = readln()
        repeat(m) { col ->
            map[row][col] = line[col] == '1'
            if (row == 0 && !map[row][col]) {
                map[row][col] = true
                nextCoords.offer(0 to col)
            }
        }
    }

    val directions = sequenceOf(1 to 0, -1 to 0, 0 to 1, 0 to -1)
    val rowRange = 0 until n
    val colRange = 0 until m
    while (nextCoords.isNotEmpty()) {
        val (row, col) = nextCoords.poll()
        if (row == n - 1) return print("YES")

        directions.map { row + it.first to col + it.second }
            .filter { it.first in rowRange }
            .filter { it.second in colRange }
            .filter { !map[it.first][it.second] }
            .forEach {
                map[it.first][it.second] = true
                nextCoords.offer(it)
            }
    }

    print("NO")
}
