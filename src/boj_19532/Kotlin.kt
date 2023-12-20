package boj_19532

import java.util.StringTokenizer

fun main() {
    val st = StringTokenizer(readln())
    val a = st.nextToken().toInt()
    val b = st.nextToken().toInt()
    val c = st.nextToken().toInt()
    val d = st.nextToken().toInt()
    val e = st.nextToken().toInt()
    val f = st.nextToken().toInt()

    val denominator = b * d - a * e
    val x = (b * f - c * e) / denominator
    val y = (c * d - a * f) / denominator
    val result = buildString { append(x, " ", y) }

    println(result)
}
