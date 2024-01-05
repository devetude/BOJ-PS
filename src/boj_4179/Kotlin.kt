package boj_4179

import java.util.LinkedList
import java.util.StringTokenizer

val DIRECTIONS: Array<Pair<Int, Int>> = arrayOf(1 to 0, -1 to 0, 0 to 1, 0 to -1)

fun main() {
    val st = StringTokenizer(readln())
    val r = st.nextToken().toInt()
    val c = st.nextToken().toInt()

    val map = Array(r) { CharArray(c) }
    var lastFireCoords = LinkedList<Pair<Int, Int>>()
    var myFirstCoord = 0 to 0
    repeat(r) { row ->
        val input = readln()
        repeat(c) { col ->
            map[row][col] = input[col]
            when (map[row][col]) {
                'F' -> lastFireCoords.offer(row to col)
                'J' -> myFirstCoord = row to col
                else -> Unit
            }
        }
    }

    val myNextCoords = LinkedList<Pair<Int, Int>>()
    myNextCoords.offer(myFirstCoord)
    val minDurations = Array(r) { IntArray(c) { Int.MAX_VALUE } }
    minDurations[myFirstCoord.row][myFirstCoord.col] = 0
    var fireDuration = -1

    while (myNextCoords.isNotEmpty()) {
        val currentMyCoord = myNextCoords.poll()
        val (currentRow, currentCol) = currentMyCoord
        if (currentRow == 0 || currentRow == r - 1 || currentCol == 0 || currentCol == c - 1) {
            return print(minDurations[currentRow][currentCol] + 1)
        }

        if (fireDuration < minDurations[currentRow][currentCol]) {
            fireDuration = minDurations[currentRow][currentCol]
            val nextFireCoords = LinkedList<Pair<Int, Int>>()
            while (lastFireCoords.isNotEmpty()) {
                val (lastFireRow, lastFireCol) = lastFireCoords.poll()

                DIRECTIONS.asSequence()
                    .map { lastFireRow + it.row to lastFireCol + it.col }
                    .filter {
                        it.row in 0 until r && it.col in 0 until c &&
                                (map[it.row][it.col] == '.' || map[it.row][it.col] == 'J')
                    }
                    .forEach {
                        map[it.row][it.col] = 'F'
                        nextFireCoords.offer(it)
                    }
            }
            lastFireCoords = nextFireCoords
        }

        DIRECTIONS.asSequence()
            .map { currentRow + it.row to currentCol + it.col }
            .filter {
                it.row in 0 until r && it.col in 0 until c &&
                        map[it.row][it.col] == '.' &&
                        minDurations[currentRow][currentCol] + 1 < minDurations[it.row][it.col]
            }
            .forEach {
                minDurations[it.row][it.col] = minDurations[currentRow][currentCol] + 1
                myNextCoords.offer(it)
            }
    }

    print("IMPOSSIBLE")
}

val Pair<Int, Int>.row: Int
    get() = first

val Pair<Int, Int>.col: Int
    get() = second
