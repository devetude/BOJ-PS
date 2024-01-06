package boj_1058

import kotlin.math.max
import kotlin.math.min

fun main() {
    val n = readln().toInt()
    val minDistances = Array(n) { IntArray(n) }
    repeat(n) { row ->
        val input = readln()
        repeat(n) { col ->
            minDistances[row][col] = if (input[col] == 'Y') 1 else 50
        }
    }

    for (via in 0 until n) {
        for (start in 0 until n) {
            if (via == start) continue
            for (end in 0 until n) {
                if (start == end || via == end) continue

                val viaDistance = minDistances[start][via] + minDistances[via][end]
                minDistances[start][end] = min(minDistances[start][end], viaDistance)
            }
        }
    }

    var maxFriendCount = 0
    for (start in 0 until n) {
        var friendCount = 0
        for (end in 0 until n) {
            if (start == end || 2 < minDistances[start][end]) continue
            maxFriendCount = max(maxFriendCount, ++friendCount)
        }
    }

    print(maxFriendCount)
}
