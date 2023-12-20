package boj_15651

import java.util.StringTokenizer

val sb = StringBuilder()

fun main() {
    val st = StringTokenizer(readln())
    val n = st.nextToken().toInt()
    val m = st.nextToken().toInt()

    val arr = IntArray(m)
    dfs(n, arr)

    System.out.bufferedWriter().use {
        it.write(sb.toString())
        it.flush()
    }
}

fun dfs(n: Int, arr: IntArray, depth: Int = 0) {
    if (depth == arr.size) {
        arr.forEach { sb.append(it, " ") }
        sb.appendLine()
        return
    }

    for (idx in 1..n) {
        arr[depth] = idx
        dfs(n, arr, depth = depth + 1)
    }
}
