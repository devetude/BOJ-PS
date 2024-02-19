package boj_14675

import java.util.StringTokenizer

fun main() {
    val n = readln().toInt()

    val degree = IntArray(size = n + 1)
    repeat(times = n - 1) {
        val st = StringTokenizer(readln())
        val a = st.nextToken().toInt()
        ++degree[a]
        val b = st.nextToken().toInt()
        ++degree[b]
    }

    val q = readln().toInt()
    val sb = StringBuilder()
    repeat(q) {
        val st = StringTokenizer(readln())
        val t = st.nextToken().toInt()
        val k = st.nextToken().toInt()

        val result = if (t == 1 && 1 == degree[k]) {
            "no"
        } else {
            "yes"
        }
        sb.appendLine(result)
    }

    System.out.bufferedWriter().use {
        it.write(sb.toString())
        it.flush()
    }
}
