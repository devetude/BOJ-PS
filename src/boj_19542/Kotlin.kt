package boj_19542

import java.util.LinkedList
import java.util.StringTokenizer
import kotlin.math.max

var s: Int = 0
var d: Int = 0
lateinit var adjacencyList: Array<LinkedList<Int>>
lateinit var maxDepthFrom: IntArray
var visitCount: Int = 0

fun main() {
    var st = StringTokenizer(readln())
    val n = st.nextToken().toInt()
    s = st.nextToken().toInt()
    d = st.nextToken().toInt()

    adjacencyList = Array(size = n + 1) { LinkedList() }
    repeat(times = n - 1) {
        st = StringTokenizer(readln())
        val x = st.nextToken().toInt()
        val y = st.nextToken().toInt()
        adjacencyList[x].add(y)
        adjacencyList[y].add(x)
    }

    maxDepthFrom = IntArray(size = n + 1)
    dfs(s)
    val totalDistance = visitCount shl 1

    print(totalDistance)
}

fun dfs(x: Int, parent: Int = 0): Int {
    adjacencyList[x].forEach { y ->
        if (y != parent) maxDepthFrom[x] = max(maxDepthFrom[x], b = dfs(y, x) + 1)
    }

    if (x != s && d <= maxDepthFrom[x]) ++visitCount

    return maxDepthFrom[x]
}
