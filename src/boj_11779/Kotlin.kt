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

    val minDistanceTo = IntArray(size = n + 1) { Int.MAX_VALUE }.apply { this[s] = 0 }
    val nextVertexes = PriorityQueue<Pair<Int, Int>>(compareBy { it.second })
        .apply { offer(s to 0) }
    val parentOf = IntArray(size = n + 1)
    while (nextVertexes.isNotEmpty()) {
        val (u, distance) = nextVertexes.poll()
        if (minDistanceTo[u] < distance) continue

        adjacencyList[u].forEach { (v, distance) ->
            val nextDistance = minDistanceTo[u] + distance
            if (minDistanceTo[v] <= nextDistance) return@forEach

            minDistanceTo[v] = nextDistance
            parentOf[v] = u
            nextVertexes.offer(v to nextDistance)
        }
    }

    val paths = LinkedList<Int>().apply {
        var v = e
        while (0 < v) {
            add(v)
            v = parentOf[v]
        }
        reverse()
    }

    val result = buildString {
        appendLine(minDistanceTo[e])
        appendLine(paths.size)
        append(paths.joinToString(separator = " "))
    }

    System.out.bufferedWriter().use {
        it.write(result)
        it.flush()
    }
}
