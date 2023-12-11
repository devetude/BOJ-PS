package boj_1085

import java.util.StringTokenizer

fun main() {
    val st = StringTokenizer(readln())
    val x = st.nextToken().toInt()
    val y = st.nextToken().toInt()
    val w = st.nextToken().toInt()
    val h = st.nextToken().toInt()

    val min = x.coerceAtMost(y)
        .coerceAtMost(maximumValue = w - x)
        .coerceAtMost(maximumValue = h - y)

    println(min)
}
