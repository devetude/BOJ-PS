package boj_16948

import java.util.LinkedList
import java.util.StringTokenizer

fun main() {
    val n = readln().toInt()

    val st = StringTokenizer(readln())
    val r1 = st.nextToken().toInt()
    val c1 = st.nextToken().toInt()
    val r2 = st.nextToken().toInt()
    val c2 = st.nextToken().toInt()

    val depths = Array(n) { IntArray(n) { -1 } }
    depths[r1][c1] = 0

    val nextCoords = LinkedList<Pair<Int, Int>>()
    nextCoords.offer(r1 to c1)

    val directions = sequenceOf(-2 to -1, -2 to 1, 0 to -2, 0 to 2, 2 to -1, 2 to 1)
    val range = 0 until n

    while (nextCoords.isNotEmpty()) {
        val (row, col) = nextCoords.poll()
        if (row == r2 && col == c2) break

        val nextDepth = depths[row][col] + 1

        directions.map { row + it.first to col + it.second }
            .filter { it.first in range }
            .filter { it.second in range }
            .filter { depths[it.first][it.second] == -1 }
            .forEach {
                depths[it.first][it.second] = nextDepth
                nextCoords.offer(it)
            }
    }

    print(depths[r2][c2])
}
