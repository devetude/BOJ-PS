package boj_17086

import java.util.LinkedList
import java.util.StringTokenizer
import kotlin.math.max

fun main() {
    var st = StringTokenizer(readln())
    val n = st.nextToken().toInt()
    val m = st.nextToken().toInt()

    val map = Array(n) { IntArray(m) }
    val nextCoords = LinkedList<Pair<Int, Int>>()
    repeat(n) { row ->
        st = StringTokenizer(readln())
        repeat(m) { col ->
            map[row][col] = st.nextToken().toInt()
            if (map[row][col] == 1) nextCoords.offer(row to col)
        }
    }

    val directions = sequenceOf(
        -1 to -1, -1 to 0, -1 to 1,
        0 to -1, 0 to 1,
        1 to -1, 1 to 0, 1 to 1
    )
    val rowRange = 0 until n
    val colRange = 0 until m
    var maxDepth = 1
    while (nextCoords.isNotEmpty()) {
        val (row, col) = nextCoords.poll()
        val nextDepth = map[row][col] + 1

        directions.map { row + it.first to col + it.second }
            .filter { it.first in rowRange }
            .filter { it.second in colRange }
            .filter { map[it.first][it.second] == 0 || nextDepth < map[it.first][it.second] }
            .forEach {
                map[it.first][it.second] = nextDepth
                maxDepth = max(maxDepth, nextDepth)
                nextCoords.offer(it)
            }
    }

    println(maxDepth - 1)
}
