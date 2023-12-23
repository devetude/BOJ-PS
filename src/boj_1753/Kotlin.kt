package boj_1753

import java.util.LinkedList
import java.util.PriorityQueue
import java.util.StringTokenizer

fun main() {
    var st = StringTokenizer(readln())
    val v = st.nextToken().toInt()
    val e = st.nextToken().toInt()

    val k = readln().toInt()

    val adjacentList = List(size = v + 1) { LinkedList<Vertex>() }
    repeat(e) {
        st = StringTokenizer(readln())
        val u = st.nextToken().toInt()
        val v = st.nextToken().toInt()
        val w = st.nextToken().toInt()
        adjacentList[u].add(Vertex(v, w))
    }

    val minWeights = IntArray(size = v + 1) { Int.MAX_VALUE }
    minWeights[k] = 0
    val pq = PriorityQueue<Vertex>()
    pq.offer(Vertex(k, w = 0))
    while (pq.isNotEmpty()) {
        val vertex = pq.poll()

        adjacentList[vertex.v].forEach { nextVertex ->
            val nextWeight = minWeights[vertex.v] + nextVertex.w
            if (minWeights[nextVertex.v] <= nextWeight) return@forEach

            minWeights[nextVertex.v] = nextWeight
            pq.offer(Vertex(nextVertex.v, nextWeight))
        }
    }
    val result = buildString {
        for (i in 1..v) {
            val minWeight = minWeights[i]
            if (minWeight < Int.MAX_VALUE) {
                appendLine(minWeight)
                continue
            }

            appendLine(value = "INF")
        }
    }

    System.out.bufferedWriter().use {
        it.write(result)
        it.flush()
    }
}

data class Vertex(val v: Int, val w: Int) : Comparable<Vertex> {
    override fun compareTo(other: Vertex): Int = compareValuesBy(a = this, other) { it.w }
}
