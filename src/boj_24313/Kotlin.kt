package boj_24313

import java.util.StringTokenizer

fun main() {
    val st = StringTokenizer(readln())
    val a1 = st.nextToken().toInt()
    val a0 = st.nextToken().toInt()
    val c = readln().toInt()
    val n0 = readln().toInt()

    val result = if (a1 * n0 + a0 <= c * n0 && a1 <= c) 1 else 0

    println(result)
}
