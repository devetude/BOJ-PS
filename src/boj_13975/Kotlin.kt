package boj_13975

import java.util.PriorityQueue
import java.util.StringTokenizer

fun main() {
    val sb = StringBuilder()
    repeat(readln().toInt()) {
        val k = readln().toInt()
        val st = StringTokenizer(readln())
        val pq = PriorityQueue<Long>()
        repeat(k) { pq.offer(st.nextToken().toLong()) }

        var totalCost = 0L
        while (1 < pq.size) {
            val cost = pq.poll() + pq.poll()
            totalCost += cost
            pq.offer(cost)
        }
        sb.appendLine(totalCost)
    }

    System.out.bufferedWriter().use {
        it.write(sb.toString())
        it.flush()
    }
}
