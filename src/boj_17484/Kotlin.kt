package boj_17484

import java.util.StringTokenizer
import kotlin.math.min

fun main() {
    var st = StringTokenizer(readln())
    val n = st.nextToken().toInt()
    val m = st.nextToken().toInt()

    val fuels = Array(size = n + 1) { IntArray(size = m + 1) }
    for (row in 1..n) {
        st = StringTokenizer(readln())
        for (col in 1..m) {
            fuels[row][col] = st.nextToken().toInt()
        }
    }

    val maxFuel = n * m * 100
    val minFuels = Array(size = n + 1) { row ->
        Array(size = m + 1) { col ->
            IntArray(size = 3) {
                if (row == 1) fuels[row][col] else maxFuel
            }
        }
    }
    for (row in 1..n) {
        for (col in 1..m) {
            for (dir in -1..1) {
                if (col + dir !in 1..m) continue

                for (previousDir in -1..1) {
                    if (dir == previousDir) continue

                    minFuels[row][col][dir + 1] = min(
                        minFuels[row][col][dir + 1],
                        minFuels[row - 1][col + dir][previousDir + 1] + fuels[row][col]
                    )
                }
            }
        }
    }

    print(minFuels[n].minOf { it.min() })
}
