package boj_9466

import java.util.StringTokenizer

private lateinit var child: IntArray
private lateinit var isVisited: BooleanArray
private lateinit var isCycleChecked: BooleanArray

private var count: Int = 0

fun main() {
    val sb = StringBuilder()
    repeat(readln().toInt()) {
        val n = readln().toInt()

        val st = StringTokenizer(readln())
        child = IntArray(size = n + 1)
        for (i in 1..n) child[i] = st.nextToken().toInt()

        isVisited = BooleanArray(size = n + 1)
        isCycleChecked = BooleanArray(size = n + 1)
        count = 0
        for (start in 1..n) if (!isVisited[start]) dfs(start)

        sb.appendLine(value = n - count)
    }

    System.out.bufferedWriter().use {
        it.write(sb.toString())
        it.flush()
    }
}

fun dfs(cur: Int) {
    if (!isVisited[cur]) {
        isVisited[cur] = true
        dfs(child[cur])
    } else {
        if (isCycleChecked[cur]) return

        var next = child[cur]
        while (next != cur) {
            ++count
            next = child[next]
        }
        ++count
    }

    isCycleChecked[cur] = true
}
