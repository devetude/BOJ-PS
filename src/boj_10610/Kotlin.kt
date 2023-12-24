package boj_10610

import java.util.PriorityQueue

fun main() {
    val n = readln()

    val pq = PriorityQueue<Char>(compareByDescending { it })
    n.forEach(pq::offer)

    var placeValueSum = 0
    val result = buildString {
        while (pq.isNotEmpty()) {
            val num = Character.getNumericValue(pq.poll())
            placeValueSum += num
            append(num)
        }
    }

    if (placeValueSum % 3 != 0 || result.last() != '0') return println(-1)

    println(result)
}
