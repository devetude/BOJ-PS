package boj_11437

import java.util.LinkedList
import java.util.StringTokenizer

lateinit var adjacencyList: Array<LinkedList<Int>>
lateinit var parentOf: IntArray
lateinit var isVisited: BooleanArray

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
    parentOf = IntArray(size = n + 1)
    findParents()

    val m = readln().toInt()
    val sb = StringBuilder()
    repeat(m) {
        val st = StringTokenizer(readln())
        val a = st.nextToken().toInt()
        val b = st.nextToken().toInt()

        isVisited = BooleanArray(size = n + 1).apply { this[a] = true }
        visitNodesFrom(a)
        val lca = findFirstRevisitedNodeFrom(b)

        sb.appendLine(lca)
    }

    System.out.bufferedWriter().use {
        it.write(sb.toString())
        it.flush()
    }
}

fun findParents(u: Int = 1) {
    adjacencyList[u].forEach { v ->
        if (isVisited[v]) return@forEach

        isVisited[v] = true
        parentOf[v] = u
        findParents(v)
    }
}

fun visitNodesFrom(a: Int) {
    if (a == 1) return

    val parent = parentOf[a]
    isVisited[a] = true
    visitNodesFrom(parent)
}

fun findFirstRevisitedNodeFrom(b: Int): Int {
    if (b == 1 || isVisited[b]) return b

    val parent = parentOf[b]
    return findFirstRevisitedNodeFrom(parent)
}
