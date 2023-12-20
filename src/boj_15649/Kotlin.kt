package boj_15649

import java.util.StringTokenizer

val sb = StringBuilder()

fun main() {
    val st = StringTokenizer(readln())
    val n = st.nextToken().toInt()
    val m = st.nextToken().toInt()

    val arr = IntArray(m)
    val isVisited = BooleanArray(n)
    dfs(arr, isVisited)

    System.out.bufferedWriter().use {
        it.write(sb.toString())
        it.flush()
    }
}

fun dfs(arr: IntArray, isVisited: BooleanArray, depth: Int = 0) {
    if (depth == arr.size) {
        arr.forEach { sb.append(it, " ") }
        sb.appendLine()
        return
    }

    repeat(isVisited.size) {
        if (isVisited[it]) return@repeat

        isVisited[it] = true
        arr[depth] = it + 1
        dfs(arr, isVisited, depth = depth + 1)
        isVisited[it] = false
    }
}
