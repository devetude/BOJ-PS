package boj_13907

import java.util.LinkedList
import java.util.PriorityQueue
import java.util.StringTokenizer

fun main() {
    var st = StringTokenizer(readln())
    val n = st.nextToken().toInt()
    val m = st.nextToken().toInt()
    val k = st.nextToken().toInt()

    st = StringTokenizer(readln())
    val s = st.nextToken().toInt()
    val d = st.nextToken().toInt()

    val adjacencyList = Array<LinkedList<Pair<Int, Int>>>(size = n + 1) { LinkedList() }
    repeat(m) {
        st = StringTokenizer(readln())
        val a = st.nextToken().toInt()
        val b = st.nextToken().toInt()
        val w = st.nextToken().toInt()
        adjacencyList[a].add(b to w)
        adjacencyList[b].add(a to w)
    }

    val p = IntArray(size = k + 1)
    repeat(k) { p[it + 1] = readln().toInt() }

    val cities = PriorityQueue<Triple<Int, Int, Int>>(compareBy { it.second })
        .apply { offer(Triple(s, second = 0, third = 0)) }
    val minWeights = Array(size = n + 1) { IntArray(size = n + 1) { Int.MAX_VALUE } }
        .apply { this[s][0] = 0 }
    while (cities.isNotEmpty()) {
        val (a, weight, currentVisitCount) = cities.poll()
        if (a == d || currentVisitCount == n || minWeights[a][currentVisitCount] < weight) continue

        val nextVisitCount = currentVisitCount + 1
        adjacencyList[a].forEach { (b, weight) ->
            val nextWeight = minWeights[a][currentVisitCount] + weight
            for (visitCount in 0 until nextVisitCount) {
                if (minWeights[b][visitCount] < nextWeight) return@forEach
            }
            if (minWeights[b][nextVisitCount] <= nextWeight) return@forEach

            minWeights[b][nextVisitCount] = nextWeight
            cities.offer(Triple(b, nextWeight, nextVisitCount))
        }
    }

    val visitCountToWeight = hashMapOf<Int, Int>().apply {
        minWeights[d].forEachIndexed { visitCount, weight ->
            if (weight < Int.MAX_VALUE) this[visitCount] = weight
        }
    }

    val sb = StringBuilder()
    p.forEach { tax ->
        var minWeight = Int.MAX_VALUE
        visitCountToWeight.forEach { (visitCount, weight) ->
            val newWeight = visitCount * tax + weight
            visitCountToWeight[visitCount] = newWeight
            if (newWeight < minWeight) minWeight = newWeight
        }
        sb.appendLine(minWeight)
    }

    System.out.bufferedWriter().use {
        it.write(sb.toString())
        it.flush()
    }
}
