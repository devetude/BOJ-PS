package boj_11286

import java.util.PriorityQueue
import kotlin.math.abs

fun main() {
    val n = readln().toInt()

    val pq = PriorityQueue(n, compareBy<Int>(::abs).thenBy { it })
    val sb = StringBuilder()
    repeat(n) {
        val x = readln().toInt()
        if (x != 0) {
            pq.offer(x)
            return@repeat
        }

        val min = if (pq.isEmpty()) 0 else pq.poll()
        sb.appendLine(min)
    }

    System.out.bufferedWriter().use {
        it.write(sb.toString())
        it.flush()
    }
}
