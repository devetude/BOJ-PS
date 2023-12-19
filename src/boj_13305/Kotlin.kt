package boj_13305

import java.util.StringTokenizer
import kotlin.math.min

fun main() {
    val n = readln().toInt()

    var st = StringTokenizer(readln())
    val distances = IntArray(size = n - 1)
    repeat(distances.size) { distances[it] = st.nextToken().toInt() }

    st = StringTokenizer(readln())
    val costs = IntArray(n)
    repeat(n) { costs[it] = st.nextToken().toInt() }

    var minCost = costs.first()
    var totalCost = minCost.toLong() * distances.first()
    for (i in 1 until costs.lastIndex) {
        val cost = costs[i]
        minCost = min(minCost, cost)
        totalCost += minCost.toLong() * distances[i]
    }

    println(totalCost)
}
