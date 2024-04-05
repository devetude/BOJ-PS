package boj_1507

import java.util.StringTokenizer

private const val INF: Int = Int.MAX_VALUE shr 1

fun main() {
    val n = readln().toInt()

    val minTimeBetween = Array(n) {
        val st = StringTokenizer(readln())
        IntArray(n) { st.nextToken().toInt() }
    }

    for (via in 0 until n) {
        for (a in 0 until n) {
            if (via == a) continue

            for (b in 0 until n) {
                if (b == via) continue

                val viaTime = minTimeBetween[a][via] + minTimeBetween[via][b]
                if (minTimeBetween[a][b] in (viaTime + 1 until INF)) return print(-1)

                if (minTimeBetween[a][b] == viaTime) minTimeBetween[a][b] = INF
            }
        }
    }

    var totalTime = 0
    for (a in 0 until n - 1) {
        for (b in a + 1 until n) {
            if (minTimeBetween[a][b] < INF) totalTime += minTimeBetween[a][b]
        }
    }

    print(totalTime)
}
