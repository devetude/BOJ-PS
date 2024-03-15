package boj_11725

import java.util.LinkedList
import java.util.StringTokenizer

private lateinit var adjacencyList: Array<LinkedList<Int>>
private lateinit var parentOf: MutableList<Int>

fun main() {
    val n = readln().toInt()

    adjacencyList = Array(size = n + 1) { LinkedList<Int>() }
    repeat(times = n - 1) {
        val st = StringTokenizer(readln())
        val u = st.nextToken().toInt()
        val v = st.nextToken().toInt()
        adjacencyList[u].add(v)
        adjacencyList[v].add(u)
    }

    parentOf = MutableList(size = n + 1) { 0 }.apply { this[1] = -1 }
    dfs()

    val result = parentOf.subList(fromIndex = 2, toIndex = parentOf.size)
        .joinToString(separator = "\n")

    System.out.bufferedWriter().use {
        it.write(result)
        it.flush()
    }
}

private fun dfs(u: Int = 1) {
    adjacencyList[u].forEach { v ->
        if (parentOf[v] != 0) return@forEach

        parentOf[v] = u
        dfs(v)
    }
}
