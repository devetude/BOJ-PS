package boj_23286

import java.io.BufferedWriter
import java.io.OutputStreamWriter
import java.util.StringTokenizer

private const val INF: Int = Int.MAX_VALUE shr 1

fun main() {
    var st = StringTokenizer(readln())
    val n = st.nextToken().toInt()
    val m = st.nextToken().toInt()
    val t = st.nextToken().toInt()

    val heightBetween = Array(size = n + 1) { u ->
        IntArray(size = n + 1) { v -> if (u == v) 0 else INF }
    }
    repeat(m) {
        st = StringTokenizer(readln())
        val u = st.nextToken().toInt()
        val v = st.nextToken().toInt()
        val h = st.nextToken().toInt()
        heightBetween[u][v] = h
    }

    for (via in 1..n) {
        for (u in 1..n) {
            for (v in 1..n) {
                heightBetween[u][v] = minOf(
                    heightBetween[u][v],
                    maxOf(heightBetween[u][via], heightBetween[via][v])
                )
            }
        }
    }

    val sb = StringBuilder()
    repeat(t) {
        st = StringTokenizer(readln())
        val s = st.nextToken().toInt()
        val e = st.nextToken().toInt()
        sb.appendLine(if (heightBetween[s][e] < INF) heightBetween[s][e] else -1)
    }

    BufferedWriter(OutputStreamWriter(System.out)).use {
        it.write(sb.toString())
        it.flush()
    }
}
