package boj_3584

import java.util.StringTokenizer

fun main() {
    val sb = StringBuilder()
    repeat(readln().toInt()) {
        val n = readln().toInt()

        val parents = IntArray(size = n + 1)
        repeat(times = n - 1) {
            val st = StringTokenizer(readln())
            val parent = st.nextToken().toInt()
            val child = st.nextToken().toInt()
            parents[child] = parent
        }

        val st = StringTokenizer(readln())
        var aParent = st.nextToken().toInt()
        var bParent = st.nextToken().toInt()

        val isVisited = BooleanArray(size = n + 1)
        while (0 < aParent) {
            isVisited[aParent] = true
            aParent = parents[aParent]
        }
        while (0 < bParent && !isVisited[bParent]) bParent = parents[bParent]
        sb.appendLine(bParent)
    }

    System.out.bufferedWriter().use {
        it.write(sb.toString())
        it.flush()
    }
}
