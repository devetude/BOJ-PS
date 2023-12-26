package boj_1449

import java.util.StringTokenizer

fun main() {
    var st = StringTokenizer(readln())
    val n = st.nextToken().toInt()
    val l = st.nextToken().toInt()
    st = StringTokenizer(readln())
    val positions = IntArray(n)
    repeat(n) { positions[it] = st.nextToken().toInt() }

    positions.sort()
    var startPosition = positions.first()
    var count = 1
    for (i in 1 until n) {
        val position = positions[i]
        if (position < startPosition + l) continue

        startPosition = position
        ++count
    }

    println(count)
}
