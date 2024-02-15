package boj_1655

import java.util.PriorityQueue

fun main() {
    val n = readln().toInt()

    val minHeap = PriorityQueue<Short>(n)
    val maxHeap = PriorityQueue<Short>(n, reverseOrder())
    val sb = StringBuilder()
    repeat(n) {
        val num = readln().toShort()
        val heap = if (minHeap.size == maxHeap.size) maxHeap else minHeap
        heap.offer(num)

        if (minHeap.isNotEmpty() && minHeap.peek() < maxHeap.peek()) {
            val tmp = minHeap.poll()
            minHeap.offer(maxHeap.poll())
            maxHeap.offer(tmp)
        }

        sb.appendLine(maxHeap.peek())
    }

    System.out.bufferedWriter().use {
        it.write(sb.toString())
        it.flush()
    }
}
