package boj_2206

import java.util.LinkedList
import java.util.StringTokenizer

val DIRECTIONS = arrayOf(arrayOf(0, 1), arrayOf(0, -1), arrayOf(1, 0), arrayOf(-1, 0))

fun main() {
    val st = StringTokenizer(readln())
    val n = st.nextToken().toInt()
    val m = st.nextToken().toInt()
    val map = Array(size = n + 1) { CharArray(size = m + 1) }
    for (row in 1..n) {
        val input = readln()
        for (col in 1..m) {
            map[row][col] = input[col - 1]
        }
    }

    val startPoint = Point(row = 1, col = 1, depth = 1, hasBreakChance = true)
    val queue = LinkedList<Point>()
    queue.offer(startPoint)
    val isVisited = Array(size = n + 1) { Array(size = m + 1) { BooleanArray(size = 2) } }
    isVisited[1][1][0] = true
    while (queue.isNotEmpty()) {
        val point = queue.poll()
        if (point.row == n && point.col == m) return println(point.depth)

        val nextPoints = DIRECTIONS.asSequence()
            .map { (rowDiff, colDiff) ->
                val nextRow = point.row + rowDiff
                val nextCol = point.col + colDiff
                val nextDepth = point.depth + 1
                Point(nextRow, nextCol, nextDepth, point.hasBreakChance)
            }
            .filter { it.row in 1..n && it.col in 1..m }
            .toList()

        nextPoints.forEach { nextPoint ->
            if (map[nextPoint.row][nextPoint.col] == '0') {
                if (nextPoint.hasBreakChance && !isVisited[nextPoint.row][nextPoint.col][0]) {
                    isVisited[nextPoint.row][nextPoint.col][0] = true
                    queue.offer(nextPoint)
                } else if (!isVisited[nextPoint.row][nextPoint.col][1]) {
                    isVisited[nextPoint.row][nextPoint.col][1] = true
                    queue.offer(nextPoint)
                }
            } else {
                if (nextPoint.hasBreakChance) {
                    isVisited[nextPoint.row][nextPoint.col][1] = true
                    queue.offer(nextPoint.copy(hasBreakChance = false))
                }
            }
        }
    }

    println(-1)
}

data class Point(
    val row: Int,
    val col: Int,
    val depth: Int,
    val hasBreakChance: Boolean
)
