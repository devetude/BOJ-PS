package boj_11279

import java.util.PriorityQueue

fun main() {
    val n = readln().toInt()

    val pq = PriorityQueue<Int>(n, reverseOrder())
    val result = buildString {
        repeat(n) {
            when (val x = readln().toInt()) {
                0 -> {
                    val max = if (pq.isEmpty()) 0 else pq.poll()
                    appendLine(max)
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
