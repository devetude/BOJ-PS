package boj_17835

import java.util.PriorityQueue
import java.util.StringTokenizer

fun main() {
    var st = StringTokenizer(readln())
    val n = st.nextToken().toInt()
    val m = st.nextToken().toInt()
    val k = st.nextToken().toInt()

    val reversedAdjacencyList = Array<PriorityQueue<Pair<Int, Int>>>(size = n + 1) {
        PriorityQueue(compareBy { it.second })
    }
    repeat(m) {
        st = StringTokenizer(readln())
        val u = st.nextToken().toInt()
        val v = st.nextToken().toInt()
        val c = st.nextToken().toInt()
        reversedAdjacencyList[v].offer(u to c)
    }

    st = StringTokenizer(readln())
    val pq = PriorityQueue<Int>()
    val costs = LongArray(size = n + 1) { Long.MAX_VALUE }
    repeat(k) {
        val end = st.nextToken().toInt()
        costs[end] = 0L
        pq.offer(end)
    }

    while (pq.isNotEmpty()) {
        val v = pq.poll()
        reversedAdjacencyList[v].forEach { (u, c) ->
            val cost = costs[v] + c
            if (costs[u] <= cost) return@forEach

            costs[u] = cost
            pq.offer(u)
        }
    }

    var num = 0
    var cost = 0L
    for (v in 1..n) {
        if (costs[v] <= cost) continue

        num = v
        cost = costs[v]
    }

    print("$num\n$cost")
}
