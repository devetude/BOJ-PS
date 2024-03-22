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

    val minDistanceTo = IntArray(size = v + 1) { Int.MAX_VALUE }.apply { this[k] = 0 }
    val nextVertexes = PriorityQueue<Vertex>().apply { offer(Vertex(k, distance = 0)) }
    while (nextVertexes.isNotEmpty()) {
        val vertex = nextVertexes.poll()
        if (minDistanceTo[vertex.num] < vertex.distance) continue

        adjacentList[vertex.num].forEach { nextVertex ->
            val distanceToNext = minDistanceTo[vertex.num] + nextVertex.distance
            if (minDistanceTo[nextVertex.num] <= distanceToNext) return@forEach

            minDistanceTo[nextVertex.num] = distanceToNext
            nextVertexes.offer(Vertex(nextVertex.num, distanceToNext))
        }
    }

    val result = buildString {
        for (i in 1..v) {
            if (minDistanceTo[i] < Int.MAX_VALUE) {
                appendLine(minDistanceTo[i])
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

private data class Vertex(val num: Int, val distance: Int) : Comparable<Vertex> {
    override fun compareTo(other: Vertex): Int = compareValuesBy(a = this, other) { it.distance }
}
