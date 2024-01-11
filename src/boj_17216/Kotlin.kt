package boj_17216

import java.util.StringTokenizer
import kotlin.math.max

fun main() {
    val n = readln().toInt()
    val st = StringTokenizer(readln())
    val nums = IntArray(n)
    val maxSums = IntArray(n)
    var maxSum = 1
    for (i in 0 until n) {
        nums[i] = st.nextToken().toInt()
        maxSums[i] = nums[i]

        for (j in 0 until i) {
            if (nums[i] < nums[j]) {
                maxSums[i] = max(maxSums[i], b = maxSums[j] + nums[i])
            }
        }

        maxSum = max(maxSum, maxSums[i])
    }

    print(maxSum)
}
