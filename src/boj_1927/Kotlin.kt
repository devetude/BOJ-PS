package boj_1927

import java.util.PriorityQueue

fun main() {
    val n = readln().toInt()

    val pq = PriorityQueue<Int>(n)
    val result = buildString {
        repeat(n) {
            when (val x = readln().toInt()) {
                0 -> {
                    val min = if (pq.isEmpty()) 0 else pq.poll()
                    appendLine(min)
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
