package boj_14503

import java.util.LinkedList
import java.util.StringTokenizer

fun main() {
    var st = StringTokenizer(readln())
    val n = st.nextToken().toInt()
    val m = st.nextToken().toInt()

    st = StringTokenizer(readln())
    val r = st.nextToken().toInt()
    val c = st.nextToken().toInt()
    val d = st.nextToken().toInt()

    val map = Array(n) { IntArray(m) }
    repeat(n) { row ->
        st = StringTokenizer(readln())
        repeat(m) { col -> map[row][col] = st.nextToken().toInt() }
    }

    val queue = LinkedList<Robot>()
    queue.offer(Robot(r, c, d))

    val isCleaned = Array(n) { BooleanArray(m) }
    var cleanedSize = 0

    val rowRange = 0 until n
    val colRange = 0 until m

    while (queue.isNotEmpty()) {
        val current = queue.poll()
        if (!isCleaned[current.row][current.col]) {
            isCleaned[current.row][current.col] = true
            ++cleanedSize
        }

        val uncleanedCoords = sequenceOf(1 to 0, -1 to 0, 0 to 1, 0 to -1)
            .map { current.row + it.row to current.col + it.col }
            .filter { it.row in rowRange }
            .filter { it.col in colRange }
            .filter { map[it.row][it.col] == 0 }
            .filter { !isCleaned[it.row][it.col] }
            .toSet()

        if (uncleanedCoords.isEmpty()) {
            val nextCoord = when (current.dir) {
                0 -> current.row + 1 to current.col
                1 -> current.row to current.col - 1
                2 -> current.row - 1 to current.col
                else -> current.row to current.col + 1
            }
            if (nextCoord.row in rowRange && nextCoord.col in colRange &&
                map[nextCoord.row][nextCoord.col] == 0
            ) {
                queue.offer(Robot(nextCoord.row, nextCoord.col, current.dir))
            }
        } else {
            val nextDir = if (current.dir == 0) 3 else current.dir - 1
            val nextCoord = when (nextDir) {
                0 -> current.row - 1 to current.col
                1 -> current.row to current.col + 1
                2 -> current.row + 1 to current.col
                else -> current.row to current.col - 1
            }
            if (nextCoord.row in rowRange && nextCoord.col in colRange &&
                map[nextCoord.row][nextCoord.col] == 0 &&
                !isCleaned[nextCoord.row][nextCoord.col]
            ) {
                queue.offer(Robot(nextCoord.row, nextCoord.col, nextDir))
            } else {
                queue.offer(Robot(current.row, current.col, nextDir))
            }
        }
    }

    print(cleanedSize)
}

data class Robot(val row: Int, val col: Int, val dir: Int)

val Pair<Int, Int>.row: Int
    get() = first

val Pair<Int, Int>.col: Int
    get() = second
