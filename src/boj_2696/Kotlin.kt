package boj_2696

import java.util.PriorityQueue
import java.util.StringTokenizer

fun main() {
    val sb = StringBuilder()
    repeat(readln().toInt()) {
        var m = readln().toInt()

        val minHeap = PriorityQueue<Int>(m)
        val maxHeap = PriorityQueue<Int>(m, reverseOrder())
        val medians = mutableListOf<Int>()
        var seq = 1
        while (0 < m) {
            m -= 10

            val st = StringTokenizer(readln())
            while (st.hasMoreTokens()) {
                val num = st.nextToken().toInt()
                val heap = if (minHeap.size == maxHeap.size) maxHeap else minHeap
                heap.offer(num)

                if (minHeap.isNotEmpty() && minHeap.peek() < maxHeap.peek()) {
                    minHeap.offer(maxHeap.poll())
                    maxHeap.offer(minHeap.poll())
                }

                if (seq++ and 1 == 1) medians.add(maxHeap.peek())
            }
        }

        var size = medians.size
        var i = 0
        sb.appendLine(size)
        while (0 < size) {
            size -= 10
            val from = i++ * 10
            val to = (from + 10).coerceAtMost(medians.size)
            sb.appendLine(medians.subList(from, to).joinToString(separator = " "))
        }
    }

    System.out.bufferedWriter().use {
        it.write(sb.toString())
        it.flush()
    }
}
