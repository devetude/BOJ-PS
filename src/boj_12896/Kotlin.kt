package boj_12896

import java.util.LinkedList
import java.util.StringTokenizer

lateinit var adjacencyList: Array<LinkedList<Int>>
lateinit var isVisited: BooleanArray
var maxDepth: Int = 0
var deepestNode: Int = 1

fun main() {
    val n = readln().toInt()

    adjacencyList = Array(size = n + 1) { LinkedList() }
    repeat(times = n - 1) {
        val st = StringTokenizer(readln())
        val u = st.nextToken().toInt()
        val v = st.nextToken().toInt()
        adjacencyList[u].add(v)
        adjacencyList[v].add(u)
    }

    isVisited = BooleanArray(size = n + 1).apply { this[1] = true }
    dfs(u = 1)

    isVisited = BooleanArray(size = n + 1).apply { this[deepestNode] = true }
    dfs(deepestNode)

    print(1 + maxDepth shr 1)
}

fun dfs(u: Int, depth: Int = 0) {
    if (maxDepth < depth) {
        maxDepth = depth
        deepestNode = u
    }

    adjacencyList[u].forEach { v ->
        if (isVisited[v]) return@forEach

        isVisited[v] = true
        dfs(v, depth = depth + 1)
        isVisited[v] = false
    }
}
