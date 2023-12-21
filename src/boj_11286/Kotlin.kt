package boj_11286

import java.util.PriorityQueue
import kotlin.math.abs

fun main() {
    val n = readln().toInt()

    val pq = PriorityQueue(n, compareBy<Int>(::abs).thenBy { it })
    val result = buildString {
        repeat(n) {
            when (val x = readln().toInt()) {
                0 -> {
                    val absMin = if (pq.isEmpty()) 0 else pq.poll()
                    appendLine(absMin)
                }

                else -> pq.offer(x)
            }
        }
    }

    System.out.bufferedWriter().use {
        it.write(result)
        it.flush()
    }
}
