package boj_21940

import java.io.BufferedWriter
import java.io.OutputStreamWriter
import java.util.StringTokenizer

private const val INF: Int = Int.MAX_VALUE shr 1

fun main() {
    var st = StringTokenizer(readln())
    val n = st.nextToken().toInt()
    val m = st.nextToken().toInt()

    val minDistBetween = Array(size = n + 1) { a ->
        IntArray(size = n + 1) { b -> if (a == b) 0 else INF }
    }
    repeat(m) {
        st = StringTokenizer(readln())
        val a = st.nextToken().toInt()
        val b = st.nextToken().toInt()
        val t = st.nextToken().toInt()
        minDistBetween[a][b] = t
    }

    val k = readln().toInt()

    st = StringTokenizer(readln())
    val c = IntArray(k) { st.nextToken().toInt() }

    for (via in 1..n) {
        for (a in 1..n) {
            for (b in 1..n) {
                minDistBetween[a][b] = minOf(
                    minDistBetween[a][b],
                    b = minDistBetween[a][via] + minDistBetween[via][b]
                )
            }
        }
    }

    var minRoundDist = INF
    val x = mutableListOf<Int>()
    for (a in 1..n) {
        var maxRoundDist = 0
        c.forEach { b ->
            val roundDist = minDistBetween[a][b] + minDistBetween[b][a]
            maxRoundDist = maxOf(maxRoundDist, roundDist)
        }
        if (minRoundDist < maxRoundDist) continue

        if (maxRoundDist < minRoundDist) {
            minRoundDist = maxRoundDist
            x.clear()
        }

        x.add(a)
    }

    BufferedWriter(OutputStreamWriter(System.out)).use {
        it.write(x.joinToString(separator = " "))
        it.flush()
    }
}
