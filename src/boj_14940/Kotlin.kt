package boj_14940

import java.util.LinkedList
import java.util.StringTokenizer

val DIRECTIONS: Array<Pair<Int, Int>> = arrayOf(1 to 0, -1 to 0, 0 to 1, 0 to -1)

fun main() {
    var st = StringTokenizer(readln())
    val n = st.nextToken().toInt()
    val m = st.nextToken().toInt()

    val map = Array(n) { IntArray(m) }
    var firstCoord = 0 to 0
    val depths = Array(n) { IntArray(m) { -1 } }
    repeat(n) { row ->
        st = StringTokenizer(readln())
        repeat(m) { col ->
            map[row][col] = st.nextToken().toInt()
            when (map[row][col]) {
                0 -> depths[row][col] = 0
                2 -> {
                    depths[row][col] = 0
                    firstCoord = row to col
                }

                else -> Unit
            }
        }
    }

    val nextCoords = LinkedList<Pair<Int, Int>>()
    nextCoords.offer(firstCoord)
    while (nextCoords.isNotEmpty()) {
        val currentCoord = nextCoords.poll()

        DIRECTIONS.asSequence()
            .map { currentCoord.row + it.row to currentCoord.col + it.col }
            .filter {
                it.row in 0 until n && it.col in 0 until m &&
                        depths[it.row][it.col] == -1
            }
            .forEach {
                depths[it.row][it.col] = depths[currentCoord.row][currentCoord.col] + 1
                nextCoords.offer(it)
            }
    }

    System.out.bufferedWriter().use {
        for (row in 0 until n) {
            for (col in 0 until m) {
                it.write(depths[row][col].toString())
                it.write(" ")
            }
            it.write("\n")
        }
        it.flush()
    }
}

val Pair<Int, Int>.row: Int
    get() = first

val Pair<Int, Int>.col: Int
    get() = second
