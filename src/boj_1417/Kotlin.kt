package boj_1417

import java.util.PriorityQueue

fun main() {
    val n = readln().toInt()
    val myPoint = readln().toInt()
    val otherPoints = PriorityQueue<Int>(compareByDescending { it })
    repeat(times = n - 1) { otherPoints.offer(readln().toInt()) }

    var buyCount = 0
    while (otherPoints.isNotEmpty() && myPoint + buyCount <= otherPoints.peek()) {
        val firstOtherPoint = otherPoints.poll()
        otherPoints.offer(firstOtherPoint - 1)
        ++buyCount
    }

    println(buyCount)
}
