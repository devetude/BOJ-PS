package boj_1260

import java.util.LinkedList
import java.util.StringTokenizer
import java.util.TreeSet

private lateinit var adjacencyList: Array<TreeSet<Int>>
private lateinit var isVisited: BooleanArray

private val resultBuilder: StringBuilder = StringBuilder()

fun main() {
    var st = StringTokenizer(readln())
    val n = st.nextToken().toInt()
    val m = st.nextToken().toInt()
    val v = st.nextToken().toInt()

    adjacencyList = Array(size = n + 1) { TreeSet<Int>() }
    repeat(m) {
        st = StringTokenizer(readln())
        val s = st.nextToken().toInt()
        val e = st.nextToken().toInt()
        adjacencyList[s].add(e)
        adjacencyList[e].add(s)
    }

    isVisited = BooleanArray(size = n + 1).apply { this[v] = true }
    dfs(v)
    resultBuilder.appendLine()
    isVisited = BooleanArray(size = n + 1).apply { this[v] = true }
    bfs(v)

    System.out.bufferedWriter().use {
        it.write(resultBuilder.toString())
        it.flush()
    }
}

private fun dfs(u: Int) {
    resultBuilder.append(u, ' ')

    adjacencyList[u].forEach { v ->
        if (isVisited[v]) return@forEach

        isVisited[v] = true
        dfs(v)
    }
}

private fun bfs(s: Int) {
    val nextNodes = LinkedList<Int>().apply { offer(s) }
    while (nextNodes.isNotEmpty()) {
        val u = nextNodes.poll()
        resultBuilder.append(u, ' ')

        adjacencyList[u].forEach { v ->
            if (isVisited[v]) return@forEach

            isVisited[v] = true
            nextNodes.offer(v)
        }
    }
}
