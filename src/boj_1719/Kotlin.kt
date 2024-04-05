package boj_1719

import java.io.BufferedWriter
import java.io.OutputStreamWriter
import java.util.StringTokenizer

private const val INF: Int = Int.MAX_VALUE shr 1

fun main() {
    var st = StringTokenizer(readln())
    val n = st.nextToken().toInt()
    val m = st.nextToken().toInt()

    val minTimeBetween = Array(n) { i -> IntArray(n) { j -> if (i == j) 0 else INF } }
    repeat(m) {
        st = StringTokenizer(readln())
        val i = st.nextToken().toInt() - 1
        val j = st.nextToken().toInt() - 1
        val time = st.nextToken().toInt()
        minTimeBetween[i][j] = time
        minTimeBetween[j][i] = time
    }

    val viaBetween = Array(n) { i -> Array(n) { j -> if (i == j) "-" else (j + 1).toString() } }
    for (via in 0 until n) {
        for (i in 0 until n) {
            for (j in 0 until n) {
                val viaTime = minTimeBetween[i][via] + minTimeBetween[via][j]
                if (viaTime < minTimeBetween[i][j]) {
                    minTimeBetween[i][j] = viaTime
                    viaBetween[i][j] = viaBetween[i][via]
                }
            }
        }
    }

    BufferedWriter(OutputStreamWriter(System.out)).use { bw ->
        bw.write(viaBetween.joinToString(separator = "\n") { it.joinToString(separator = " ") })
        bw.flush()
    }
}
