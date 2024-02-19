package boj_9934

import java.util.LinkedList
import java.util.StringTokenizer

var k: Int = 0
val visits: MutableList<Int> = mutableListOf()
lateinit var results: Array<LinkedList<Int>>

fun main() {
    k = readln().toInt()

    val st = StringTokenizer(readln())
    while (st.hasMoreTokens()) visits.add(st.nextToken().toInt())

    results = Array(size = k + 1) { LinkedList() }
    dfs()

    val sb = StringBuilder()
    for (i in 1..k) sb.appendLine(results[i].joinToString(separator = " "))

    System.out.bufferedWriter().use {
        it.write(sb.toString())
        it.flush()
    }
}

fun dfs(left: Int = 0, right: Int = visits.lastIndex, depth: Int = 1) {
    if (k < depth) return

    val mid = left + right shr 1
    results[depth].add(visits[mid])

    val nextDepth = depth + 1
    dfs(left, mid, nextDepth)
    dfs(left = mid + 1, right, nextDepth)
}
