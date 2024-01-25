package boj_16933

import java.util.LinkedList
import java.util.StringTokenizer
import kotlin.math.min

const val INF: Int = 1_000_001
const val DAY: Int = 0
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

    val depths = Array(size = 2) {
        Array(size = k + 1) {
            Array(size = n + 1) {
                IntArray(size = m + 1) { INF }
            }
        }
    }

    val startCoordinate = Coordinate(DAY, k, row = 1, col = 1)
    with(startCoordinate) { depths[time][leftChance][row][col] = 1 }

    val nextCoordinates = LinkedList<Coordinate>()
    nextCoordinates.offer(startCoordinate)

    var minDepth = INF
    while (nextCoordinates.isNotEmpty()) {
        val (time, leftChance, row, col) = nextCoordinates.poll()
        if (row == n && col == m) {
            minDepth = min(minDepth, depths[time][leftChance][n][m])
            continue
        }

        val nextTime = time xor 1
        var nextDepth = depths[time][leftChance][row][col] + 1
        if (nextDepth < depths[nextTime][leftChance][row][col]) {
            depths[nextTime][leftChance][row][col] = nextDepth
            val nextCoordinate = Coordinate(nextTime, leftChance, row, col)
            nextCoordinates.offer(nextCoordinate)
        }

        for ((rowDir, colDir) in DIR) {
            val nextRow = row + rowDir
            if (nextRow !in rowRange) continue

            val nextCol = col + colDir
            if (nextCol !in colRange) continue

            nextDepth = depths[time][leftChance][row][col] + 1
            if (map[nextRow][nextCol]) {
                if (0 < leftChance && time == DAY) {
                    val nextLeftChance = leftChance - 1
                    if (nextDepth < depths[nextTime][nextLeftChance][nextRow][nextCol]) {
                        depths[nextTime][nextLeftChance][nextRow][nextCol] = nextDepth
                        val nextCoordinate = Coordinate(nextTime, nextLeftChance, nextRow, nextCol)
                        nextCoordinates.offer(nextCoordinate)
                    }
                }
            } else {
                if (nextDepth < depths[nextTime][leftChance][nextRow][nextCol]) {
                    depths[nextTime][leftChance][nextRow][nextCol] = nextDepth
                    val nextCoordinate = Coordinate(nextTime, leftChance, nextRow, nextCol)
                    nextCoordinates.offer(nextCoordinate)
                }
            }
        }
    }

    print(if (minDepth < INF) minDepth else -1)
}

data class Coordinate(val time: Int, val leftChance: Int, val row: Int, val col: Int)
