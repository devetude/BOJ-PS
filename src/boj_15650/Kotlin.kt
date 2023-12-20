package boj_15650

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

fun dfs(n: Int, arr: IntArray, startIdx: Int = 1, depth: Int = 0) {
    if (depth == arr.size) {
        arr.forEach { sb.append(it, " ") }
        sb.appendLine()
        return
    }

    for (idx in startIdx..n) {
        arr[depth] = idx
        dfs(n, arr, startIdx = idx + 1, depth = depth + 1)
    }
}
