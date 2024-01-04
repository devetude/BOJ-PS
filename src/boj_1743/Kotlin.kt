package boj_1743

import java.util.LinkedList
import java.util.StringTokenizer
import kotlin.math.max

val DIRECTIONS: Array<Pair<Int, Int>> = arrayOf(1 to 0, -1 to 0, 0 to 1, 0 to -1)

fun main() {
    var st = StringTokenizer(readln())
    val n = st.nextToken().toInt()
    val m = st.nextToken().toInt()
    val k = st.nextToken().toInt()

    val map = Array(size = n + 1) { BooleanArray(size = m + 1) }
    repeat(k) {
        st = StringTokenizer(readln())
        val r = st.nextToken().toInt()
        val c = st.nextToken().toInt()
        map[r][c] = true
    }

    var maxSize = 0
    for (row in 1..n) {
        for (col in 1..m) {
            if (!map[row][col]) continue

            val nextCoords = LinkedList<Pair<Int, Int>>()
            nextCoords.offer(row to col)
            map[row][col] = false
            var size = 0
            while (nextCoords.isNotEmpty()) {
                val (currentRow, currentCol) = nextCoords.poll()
                ++size

                DIRECTIONS.asSequence()
                    .map { currentRow + it.first to currentCol + it.second }
                    .filter { (nextRow, nextCol) ->
                        nextRow in 1..n && nextCol in 1..m && map[nextRow][nextCol]
                    }
                    .forEach { (nextRow, nextCol) ->
                        map[nextRow][nextCol] = false
                        nextCoords.offer(nextRow to nextCol)
                    }
            }
            maxSize = max(maxSize, size)
        }
    }

    println(maxSize)
}
