package boj_20924

import java.util.LinkedList
import java.util.StringTokenizer

fun main() {
    var st = StringTokenizer(readln())
    val n = st.nextToken().toInt()
    val r = st.nextToken().toInt()

    val adjacencyList = Array<LinkedList<Pair<Int, Int>>>(size = n + 1) { LinkedList() }
    repeat(times = n - 1) {
        st = StringTokenizer(readln())
        val a = st.nextToken().toInt()
        val b = st.nextToken().toInt()
        val d = st.nextToken().toInt()
        adjacencyList[a].add(b to d)
        adjacencyList[b].add(a to d)
    }

    val distances = IntArray(size = n + 1) { Int.MIN_VALUE }
    distances[r] = 0
    val nodes = LinkedList<Int>().apply { offer(r) }
    var gigaNode = -1
    var maxBranchDistance = 0
    while (nodes.isNotEmpty()) {
        val aNode = nodes.poll()

        var childrenSize = 0
        adjacencyList[aNode].forEach { (bNode, distance) ->
            if (distances[bNode] != Int.MIN_VALUE) return@forEach

            distances[bNode] = distances[aNode] + distance
            ++childrenSize
            nodes.offer(bNode)
        }

        if (gigaNode == -1 && (2 <= childrenSize || (childrenSize == 0 && nodes.isEmpty()))) {
            gigaNode = aNode
        }

        if (childrenSize == 0) {
            val branchDistance = distances[aNode] - distances[gigaNode]
            if (maxBranchDistance < branchDistance) maxBranchDistance = branchDistance
        }
    }

    print("${distances[gigaNode]} $maxBranchDistance")
}
