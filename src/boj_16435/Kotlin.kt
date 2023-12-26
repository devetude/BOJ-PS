package boj_16435

import java.util.StringTokenizer

fun main() {
    var st = StringTokenizer(readln())
    val n = st.nextToken().toInt()
    val m = st.nextToken().toInt()
    st = StringTokenizer(readln())
    val treeHeights = IntArray(n)
    repeat(n) { treeHeights[it] = st.nextToken().toInt() }

    treeHeights.sort()
    var currentHeight = m
    for (treeHeight in treeHeights) {
        if (currentHeight < treeHeight) break

        ++currentHeight
    }

    println(currentHeight)
}
