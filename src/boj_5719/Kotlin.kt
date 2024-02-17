package boj_5719

import java.util.LinkedList
import java.util.PriorityQueue
import java.util.StringTokenizer

fun main() {
    val sb = StringBuilder()
    while (true) {
        var st = StringTokenizer(readln())
        val n = st.nextToken().toInt()
        val m = st.nextToken().toInt()
        if (n == 0 && m == 0) break

        st = StringTokenizer(readln())
        val s = st.nextToken().toInt()
        val d = st.nextToken().toInt()

        val adjacencyList = Array<HashMap<Int, Int>>(size = n + 1) { hashMapOf() }
        repeat(m) {
            st = StringTokenizer(readln())
            val u = st.nextToken().toInt()
            val v = st.nextToken().toInt()
            val p = st.nextToken().toInt()
            adjacencyList[u][v] = p
        }

        val pq = PriorityQueue<Pair<Int, Int>>(compareBy { it.second }).apply { offer(s to 0) }
        var weights = IntArray(size = n + 1) { Int.MAX_VALUE }.apply { this[s] = 0 }
        val parents = Array<LinkedList<Int>>(size = n + 1) { LinkedList() }
        while (pq.isNotEmpty()) {
            val (u, p) = pq.poll()
            if (weights[u] < p) continue

            adjacencyList[u].forEach { (v, p) ->
                val weight = weights[u] + p
                if (weight < weights[v]) {
                    parents[v].clear()
                    parents[v].add(u)

                    weights[v] = weight
                    pq.offer(v to weight)
                } else if (weight == weights[v]) {
                    parents[v].add(u)
                }
            }
        }

        val q = LinkedList<Int>().apply { offer(d) }
        val isVisited = BooleanArray(n)
        while (q.isNotEmpty()) {
            val v = q.poll()
            if (isVisited[v]) continue

            isVisited[v] = true
            parents[v].forEach { u ->
                adjacencyList[u].remove(v)
                q.offer(u)
            }
        }

        pq.offer(s to 0)
        weights = IntArray(size = n + 1) { Int.MAX_VALUE }.apply { this[s] = 0 }
        while (pq.isNotEmpty()) {
            val (u, p) = pq.poll()
            if (weights[u] < p) continue

            adjacencyList[u].forEach { (v, p) ->
                val weight = weights[u] + p
                if (weights[v] <= weight) return@forEach

                weights[v] = weight
                pq.offer(v to weight)
            }
        }

        val result = if (weights[d] == Int.MAX_VALUE) -1 else weights[d]
        sb.appendLine(result)
    }

    System.out.bufferedWriter().use {
        it.write(sb.toString())
        it.flush()
    }
}
