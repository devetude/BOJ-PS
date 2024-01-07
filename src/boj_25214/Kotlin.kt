package boj_25214

import java.util.StringTokenizer
import kotlin.math.max
import kotlin.math.min

fun main() {
    val n = readln().toInt()
    val st = StringTokenizer(readln())

    val maxDiffs = IntArray(n)
    var minValue = st.nextToken().toInt()
    for (i in 1 until n) {
        val num = st.nextToken().toInt()
        maxDiffs[i] = max(maxDiffs[i - 1], b = num - minValue)
        minValue = min(minValue, num)
    }

    System.out.bufferedWriter().use { bw ->
        maxDiffs.forEach {
            bw.write(it.toString())
            bw.write(" ")
        }

        bw.flush()
    }
}
