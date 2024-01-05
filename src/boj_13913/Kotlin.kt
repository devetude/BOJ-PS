package boj_13913

import java.util.LinkedList
import java.util.Stack
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
    val before = IntArray(size = 100_001)
    while (nextXs.isNotEmpty()) {
        val currentX = nextXs.poll()
        if (currentX == k) break
        val nextDuration = minDurations[currentX] + 1
        MOVES.asSequence()
            .map { move -> move(currentX) }
            .filter { nextX -> nextX in 0..100_000 && nextDuration < minDurations[nextX] }
            .forEach { nextX ->
                before[nextX] = currentX
                minDurations[nextX] = nextDuration
                nextXs.offer(nextX)
            }
    }
    val result = buildString {
        appendLine(minDurations[k])
        val stack = Stack<Int>()
        var i = k
        while (i != n) {
            stack.push(i)
            i = before[i]
        }
        stack.push(i)
        while (stack.isNotEmpty()) append(stack.pop(), " ")
    }

    System.out.bufferedWriter().use {
        it.write(result)
        it.flush()
    }
}
