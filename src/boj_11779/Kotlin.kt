package boj_11779

import java.util.LinkedList
import java.util.PriorityQueue
import java.util.StringTokenizer

fun main() {
    val n = readln().toInt()
    val m = readln().toInt()

    val adjacencyList = Array<PriorityQueue<Pair<Int, Int>>>(size = n + 1) {
        PriorityQueue(compareBy { it.second })
    }
    repeat(m) {
        val st = StringTokenizer(readln())
        val u = st.nextToken().toInt()
        val v = st.nextToken().toInt()
        val w = st.nextToken().toInt()
        adjacencyList[u].add(v to w)
    }

    val st = StringTokenizer(readln())
    val s = st.nextToken().toInt()
    val e = st.nextToken().toInt()

    val weights = IntArray(size = n + 1) { Int.MAX_VALUE }.apply { this[s] = 0 }
    val pq = PriorityQueue<Int>().apply { offer(s) }
    val parents = IntArray(size = n + 1)
    while (pq.isNotEmpty()) {
        val u = pq.poll()
        adjacencyList[u].forEach { (v, w) ->
            val nextCost = weights[u] + w
            if (nextCost < weights[v]) {
                weights[v] = nextCost
                parents[v] = u
                pq.offer(v)
            }
        }
    }

    val paths = LinkedList<Int>().apply {
        var v = e
        while (0 < v) {
            add(v)
            v = parents[v]
        }
        reverse()
    }

    val result = buildString {
        appendLine(weights[e])
        appendLine(paths.size)
        append(paths.joinToString(separator = " "))
    }
    System.out.bufferedWriter().use {
        it.write(result)
        it.flush()
    }
}
