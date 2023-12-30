package boj_14502

import java.util.LinkedList
import java.util.StringTokenizer
import kotlin.math.max

const val REQUIRED_WALL_INSTALLATION_COUNT: Int = 3

const val SAFE_AREA: Int = 0
const val WALL_AREA: Int = 1
const val VIRUS_AREA: Int = 2

val DIRECTIONS: Array<Pair<Int, Int>> = arrayOf(1 to 0, -1 to 0, 0 to -1, 0 to 1)

var maxSafeAreaSize: Int = 0

fun main() {
    var st = StringTokenizer(readln())
    val n = st.nextToken().toInt()
    val m = st.nextToken().toInt()
    val map = Array(n) { IntArray(m) }
    repeat(n) { row ->
        st = StringTokenizer(readln())
        repeat(m) { col -> map[row][col] = st.nextToken().toInt() }
    }
    map.installWallsAndUpdateMaxSafeAreaSize()

    println(maxSafeAreaSize)
}

fun Array<IntArray>.installWallsAndUpdateMaxSafeAreaSize(installedCount: Int = 0) {
    if (installedCount == REQUIRED_WALL_INSTALLATION_COUNT) return updateMaxSafeAreaSize()

    for (row in indices) {
        for (col in this[row].indices) {
            if (this[row][col] != SAFE_AREA) continue

            this[row][col] = WALL_AREA
            installWallsAndUpdateMaxSafeAreaSize(installedCount = installedCount + 1)
            this[row][col] = SAFE_AREA
        }
    }
}

fun Array<IntArray>.updateMaxSafeAreaSize() {
    val virusCoordinates = LinkedList<VirusCoordinate>()
    val copiedMap = Array(size) { row ->
        IntArray(first().size) { col ->
            val area = this[row][col]
            if (area == VIRUS_AREA) virusCoordinates.offer(VirusCoordinate(row, col))
            area
        }
    }
    while (virusCoordinates.isNotEmpty()) {
        val virusCoordinate = virusCoordinates.poll()
        DIRECTIONS.asSequence()
            .map {
                val nextRow = virusCoordinate.row + it.first
                val nextCol = virusCoordinate.col + it.second
                VirusCoordinate(nextRow, nextCol)
            }
            .filter { it.isSpreadableIn(copiedMap) }
            .forEach {
                copiedMap[it.row][it.col] = VIRUS_AREA
                virusCoordinates.offer(it)
            }
    }

    var safeAreaSize = 0
    for (row in copiedMap.indices) {
        for (col in copiedMap[row].indices) {
            if (copiedMap[row][col] == 0) ++safeAreaSize
        }
    }
    maxSafeAreaSize = max(maxSafeAreaSize, safeAreaSize)
}

data class VirusCoordinate(val row: Int, val col: Int) {
    fun isSpreadableIn(map: Array<IntArray>): Boolean {
        val rowSize = map.size
        val colSize = map.first().size
        if (row !in (0 until rowSize) || col !in (0 until colSize)) return false

        return map[row][col] == SAFE_AREA
    }
}
