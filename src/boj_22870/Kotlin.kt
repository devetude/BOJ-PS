package boj_22870

import java.util.LinkedList
import java.util.PriorityQueue
import java.util.StringTokenizer

fun main() {
    var st = StringTokenizer(readln())
    val n = st.nextToken().toInt()
    val m = st.nextToken().toInt()

    val adjacencyList = Array<LinkedList<Pair<Int, Int>>>(size = n + 1) { LinkedList() }
    repeat(m) {
        st = StringTokenizer(readln())
        val a = st.nextToken().toInt()
        val b = st.nextToken().toInt()
        val c = st.nextToken().toInt()
        adjacencyList[a].add(b to c)
        adjacencyList[b].add(a to c)
    }

    st = StringTokenizer(readln())
    val s = st.nextToken().toInt()
    val e = st.nextToken().toInt()

    val nodes = PriorityQueue<Pair<Int, Int>>(compareBy { it.second }).apply { offer(s to 0) }
    var costs = IntArray(size = n + 1) { Int.MAX_VALUE }.apply { this[s] = 0 }
    while (nodes.isNotEmpty()) {
        val (a, cost) = nodes.poll()
        if (a == e || costs[a] < cost) continue

        adjacencyList[a].forEach { (b, cost) ->
            val nextCost = costs[a] + cost
            if (nextCost < costs[b]) {
                costs[b] = nextCost
                nodes.offer(b to nextCost)
            }
        }
    }
    val forwardMinCost = costs[e]

    val parents = IntArray(size = n + 1) { Int.MAX_VALUE }
    val backtrackingNodes = LinkedList<Int>().apply { offer(e) }
    while (backtrackingNodes.isNotEmpty()) {
        val a = backtrackingNodes.poll()
        adjacencyList[a].forEach { (b, cost) ->
            if (costs[a] - costs[b] == cost && a < parents[b]) {
                parents[b] = a
                backtrackingNodes.offer(b)
            }
        }
    }

    val visitedNodes = hashSetOf<Int>()
    var node = s
    while (node != e) {
        node = parents[node]
        visitedNodes.add(node)
    }

    nodes.offer(e to 0)
    costs = IntArray(size = n + 1) { Int.MAX_VALUE }.apply { this[e] = 0 }
    while (nodes.isNotEmpty()) {
        val (a, cost) = nodes.poll()
        if (a == s || costs[a] < cost) continue

        adjacencyList[a].forEach { (b, cost) ->
            if (b in visitedNodes) return@forEach

            val nextCost = costs[a] + cost
            if (nextCost < costs[b]) {
                costs[b] = nextCost
                nodes.offer(b to nextCost)
            }
        }
    }
    val backwardMinCost = costs[s]

    print(forwardMinCost + backwardMinCost)
}
