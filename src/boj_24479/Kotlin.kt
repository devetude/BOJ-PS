package boj_24479

import java.util.StringTokenizer
import java.util.TreeSet

var visitIdx = 0

fun main() {
    var st = StringTokenizer(readln())
    val n = st.nextToken().toInt()
    val m = st.nextToken().toInt()
    val r = st.nextToken().toInt()
    val e = MutableList(size = n + 1) { TreeSet<Int>() }
    repeat(m) {
        st = StringTokenizer(readln())
        val start = st.nextToken().toInt()
        val end = st.nextToken().toInt()
        e[start].add(end)
        e[end].add(start)
    }

    val visitSequences = IntArray(size = n + 1)
    dfs(e, visitSequences, r)
    val result = buildString { for (i in 1..n) appendLine(visitSequences[i]) }

    System.out.bufferedWriter().use {
        it.write(result)
        it.flush()
    }
}

fun dfs(e: MutableList<TreeSet<Int>>, visitSequences: IntArray, start: Int) {
    visitSequences[start] = ++visitIdx

    e[start].forEach { end ->
        if (0 < visitSequences[end]) return@forEach

        dfs(e, visitSequences, end)
    }
}
