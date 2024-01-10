package boj_11568

import java.util.StringTokenizer
import kotlin.math.max

fun main() {
    val n = readln().toInt()
    val st = StringTokenizer(readln())
    val nums = IntArray(n)
    repeat(n) { nums[it] = st.nextToken().toInt() }

    val maxLengths = IntArray(n)
    var maxLength = 0
    for (i in nums.indices) {
        maxLengths[i] = 1
        for (j in 0..<i) {
            if (nums[j] < nums[i]) {
                maxLengths[i] = max(maxLengths[i], b = maxLengths[j] + 1)
            }
        }
        maxLength = max(maxLength, maxLengths[i])
    }

    print(maxLength)
}
