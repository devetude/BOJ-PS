package boj_1926

import java.util.LinkedList
import java.util.StringTokenizer
import kotlin.math.max

val DIRECTIONS: Array<Pair<Int, Int>> = arrayOf(1 to 0, -1 to 0, 0 to 1, 0 to -1)

fun main() {
    var st = StringTokenizer(readln())
    val n = st.nextToken().toInt()
    val m = st.nextToken().toInt()
    val canvas = Array(n) { BooleanArray(m) }
    repeat(n) { row ->
        st = StringTokenizer(readln())
        repeat(m) { col -> canvas[row][col] = st.nextToken() == "1" }
    }

    var groupSize = 0
    var maxVisitSequence = 1
    for (startRow in 0 until n) {
        for (startCol in 0 until m) {
            if (!canvas[startRow][startCol]) continue

            ++groupSize
            canvas[startRow][startCol] = false
            val queue = LinkedList<Pair<Int, Int>>()
            queue.offer(startRow to startCol)
            var visitSequence = 1
            while (queue.isNotEmpty()) {
                val (currentRow, currentCol) = queue.poll()

                DIRECTIONS.asSequence()
                    .map { currentRow + it.first to currentCol + it.second }
                    .filter { (nextRow, nextCol) ->
                        nextRow in 0 until n && nextCol in 0 until m &&
                                canvas[nextRow][nextCol]
                    }
                    .forEach { (nextRow, nextCol) ->
                        canvas[nextRow][nextCol] = false
                        maxVisitSequence = max(maxVisitSequence, ++visitSequence)
                        queue.offer(nextRow to nextCol)
                    }
            }
        }
    }
    if (groupSize == 0) maxVisitSequence = 0
    val result = buildString {
        appendLine(groupSize)
        append(maxVisitSequence)
    }

    println(result)
}
