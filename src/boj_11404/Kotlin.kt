package boj_11404

import java.util.StringTokenizer
import kotlin.math.min

fun main() {
    val n = readln().toInt()
    val m = readln().toInt()
    val minCosts = Array(size = n + 1) { IntArray(size = n + 1) { Int.MAX_VALUE } }
    repeat(m) {
        val st = StringTokenizer(readln())
        val a = st.nextToken().toInt()
        val b = st.nextToken().toInt()
        val c = st.nextToken().toInt()
        minCosts[a][b] = min(minCosts[a][b], c)
    }

    for (via in 1..n) {
        for (start in 1..n) {
            for (end in 1..n) {
                if (start == end) continue

                val startToViaCost = minCosts[start][via]
                if (startToViaCost == Int.MAX_VALUE) continue

                val viaToEndCost = minCosts[via][end]
                if (viaToEndCost == Int.MAX_VALUE) continue

                val directCost = minCosts[start][end]
                val viaCost = minCosts[start][via] + minCosts[via][end]
                if (directCost <= viaCost) continue

                minCosts[start][end] = viaCost
            }
        }
    }

    val result = buildString {
        for (start in 1..n) {
            for (end in 1..n) {
                val minCost = minCosts[start][end]
                append(if (minCost == Int.MAX_VALUE) 0 else minCost, " ")
            }
            appendLine()
        }
    }

    System.out.bufferedWriter().use {
        it.write(result)
        it.flush()
    }
}
