package boj_13023

import java.util.LinkedList
import java.util.StringTokenizer

var result = 0

fun main() {
    var st = StringTokenizer(readln())
    val n = st.nextToken().toInt()
    val m = st.nextToken().toInt()

    val adjacencyList = Array(n) { LinkedList<Int>() }
    repeat(m) {
        st = StringTokenizer(readln())
        val a = st.nextToken().toInt()
        val b = st.nextToken().toInt()
        adjacencyList[a].add(b)
        adjacencyList[b].add(a)
    }

    val isVisited = BooleanArray(n)
    for (startNode in 0 until n) {
        isVisited[startNode] = true
        adjacencyList.dfs(startNode, isVisited)
        isVisited[startNode] = false

        if (result == 1) break
    }

    println(result)
}

fun Array<LinkedList<Int>>.dfs(currentNode: Int, isVisited: BooleanArray, depth: Int = 0) {
    if (3 < depth) {
        result = 1
        return
    }

    this[currentNode].forEach { nextNode ->
        if (isVisited[nextNode]) return@forEach

        isVisited[nextNode] = true
        dfs(nextNode, isVisited, depth = depth + 1)
        isVisited[nextNode] = false
    }
}
