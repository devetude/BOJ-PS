package boj_12851

import java.util.LinkedList
import java.util.StringTokenizer

val MOVES: Array<(Int) -> (Int)> = arrayOf({ it + 1 }, { it - 1 }, { it shl 1 })

fun main() {
    val st = StringTokenizer(readln())
    val n = st.nextToken().toInt()
    val k = st.nextToken().toInt()

    val nextXs = LinkedList<Int>()
    nextXs.offer(n)
    val minDurations = IntArray(size = 100_001) { Int.MAX_VALUE }
    minDurations[n] = 0
    var minCases = 0
    while (nextXs.isNotEmpty()) {
        val currentX = nextXs.poll()
        if (currentX == k) ++minCases
        val nextDuration = minDurations[currentX] + 1
        MOVES.asSequence()
            .map { move -> move(currentX) }
            .filter { nextX -> nextX in 0..100_000 && nextDuration <= minDurations[nextX] }
            .forEach { nextX ->
                minDurations[nextX] = nextDuration
                nextXs.offer(nextX)
            }
    }

    println(minDurations[k])
    println(minCases)
}
