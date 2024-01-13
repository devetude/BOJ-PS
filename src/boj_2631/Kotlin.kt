package boj_2631

import kotlin.math.max

fun main() {
    val n = readln().toInt()

    val nums = IntArray(n)
    val maxSizes = IntArray(n)
    var maxSize = 0
    repeat(n) {
        nums[it] = readln().toInt()
        maxSizes[it] = 1
        for (i in 0..<it) {
            if (nums[i] < nums[it]) maxSizes[it] = max(maxSizes[it], b = maxSizes[i] + 1)
        }
        maxSize = max(maxSize, maxSizes[it])
    }

    print(n - maxSize)
}
