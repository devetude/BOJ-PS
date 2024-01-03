package boj_16234

import java.util.LinkedList
import java.util.StringTokenizer
import kotlin.math.abs

val DIRECTIONS: Array<Pair<Int, Int>> = arrayOf(1 to 0, -1 to 0, 0 to 1, 0 to -1)

fun main() {
    var st = StringTokenizer(readln())
    val n = st.nextToken().toInt()
    val l = st.nextToken().toInt()
    val r = st.nextToken().toInt()

    val map = Array(n) { IntArray(n) }
    repeat(n) { row ->
        st = StringTokenizer(readln())
        repeat(n) { col -> map[row][col] = st.nextToken().toInt() }
    }

    var isPopulationChanged = false
    var days = 0

    while (true) {
        val isVisited = Array(n) { BooleanArray(n) }
        for (row in 0 until n) {
            for (col in 0 until n) {
                if (isVisited[row][col]) continue

                isVisited[row][col] = true

                val nextCoordinates = LinkedList<Pair<Int, Int>>()
                nextCoordinates.offer(row to col)

                val allianceCoordinates = LinkedList<Pair<Int, Int>>()
                allianceCoordinates.offer(row to col)
                var alliancePopulation = map[row][col]

                while (nextCoordinates.isNotEmpty()) {
                    val currentCoordinate = nextCoordinates.poll()
                    val (currentRow, currentCol) = currentCoordinate

                    DIRECTIONS.asSequence()
                        .map { direction -> currentCoordinate + direction }
                        .filter { nextCoordinate ->
                            if (!nextCoordinate.isInMapSizeOf(n)) return@filter false

                            val (nextRow, nextCol) = nextCoordinate
                            if (isVisited[nextRow][nextCol]) return@filter false

                            val populationDiff =
                                abs(n = map[currentRow][currentCol] - map[nextRow][nextCol])
                            populationDiff in l..r
                        }
                        .forEach { nextCoordinate ->
                            val (nextRow, nextCol) = nextCoordinate
                            isVisited[nextRow][nextCol] = true

                            nextCoordinates.offer(nextCoordinate)

                            allianceCoordinates.offer(nextCoordinate)
                            alliancePopulation += map[nextRow][nextCol]
                        }
                }

                val allianceSize = allianceCoordinates.size
                if (1 < allianceSize) {
                    val newPopulation = alliancePopulation / allianceSize
                    allianceCoordinates.forEach { (row, col) -> map[row][col] = newPopulation }
                    isPopulationChanged = true
                }
            }
        }

        if (!isPopulationChanged) break

        isPopulationChanged = false
        ++days
    }

    println(days)
}

operator fun Pair<Int, Int>.plus(other: Pair<Int, Int>): Pair<Int, Int> =
    first + other.first to second + other.second

fun Pair<Int, Int>.isInMapSizeOf(n: Int): Boolean =
    first in 0 until n && second in 0 until n
