package boj_14442

import java.util.LinkedList
import java.util.StringTokenizer
import kotlin.math.min

const val INF: Int = 1_000_001
val DIR: Array<Pair<Int, Int>> = arrayOf(1 to 0, -1 to 0, 0 to 1, 0 to -1)

fun main() {
    val st = StringTokenizer(readln())
    val n = st.nextToken().toInt()
    val m = st.nextToken().toInt()
    val k = st.nextToken().toInt()

    val rowRange = 1..n
    val colRange = 1..m

    val map = Array(size = n + 1) { BooleanArray(size = m + 1) }
    for (row in rowRange) {
        val line = readln()
        for (col in colRange) map[row][col] = line[col - 1] == '1'
    }

    val depths = Array(size = k + 1) { Array(size = n + 1) { IntArray(size = m + 1) { INF } } }
    depths[k][1][1] = 1

    val nextCoordinates = LinkedList<Coordinate>()
    nextCoordinates.offer(Coordinate(k, row = 1, col = 1))

    var minDepth = INF
    while (nextCoordinates.isNotEmpty()) {
        val (leftChance, row, col) = nextCoordinates.poll()
        if (row == n && col == m) {
            minDepth = min(minDepth, depths[leftChance][n][m])
            continue
        }

        for ((rowDir, colDir) in DIR) {
            val nextRow = row + rowDir
            if (nextRow !in rowRange) continue

            val nextCol = col + colDir
            if (nextCol !in colRange) continue

            if (map[nextRow][nextCol]) {
                if (0 < leftChance) {
                    val nextDepth = depths[leftChance][row][col] + 1
                    val nextLeftChance = leftChance - 1
                    if (nextDepth < depths[nextLeftChance][nextRow][nextCol]) {
                        depths[nextLeftChance][nextRow][nextCol] = nextDepth
                        val nextCoordinate = Coordinate(nextLeftChance, nextRow, nextCol)
                        nextCoordinates.offer(nextCoordinate)
                    }
                }
            } else {
                val nextDepth = depths[leftChance][row][col] + 1
                if (nextDepth < depths[leftChance][nextRow][nextCol]) {
                    depths[leftChance][nextRow][nextCol] = nextDepth
                    val nextCoordinate = Coordinate(leftChance, nextRow, nextCol)
                    nextCoordinates.offer(nextCoordinate)
                }
            }
        }
    }

    print(if (minDepth < INF) minDepth else -1)
}

data class Coordinate(val leftChance: Int, val row: Int, val col: Int)
