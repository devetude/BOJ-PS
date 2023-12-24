package boj_1715

import java.util.PriorityQueue

fun main() {
    val n = readln().toInt()
    val pq = PriorityQueue<Int>()
    repeat(n) { pq.offer(readln().toInt()) }

    var totalCompareTimes = 0
    while (1 < pq.size) {
        val first = pq.poll()
        val second = pq.poll()
        val compareTimes = first + second
        totalCompareTimes += compareTimes
        pq.offer(compareTimes)
    }

    println(totalCompareTimes)
}
