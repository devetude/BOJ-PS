package boj_18310

import java.util.StringTokenizer

fun main() {
    val n = readln().toInt()
    val st = StringTokenizer(readln())
    val x = IntArray(n)
    repeat(n) { x[it] = st.nextToken().toInt() }

    if (x.size == 1) return println(x.first())

    x.sort()

    println(x[(n - 1) shr 1])
}
