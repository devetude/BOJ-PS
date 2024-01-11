package boj_22857

import java.util.StringTokenizer
import kotlin.math.max

fun main() {
    var st = StringTokenizer(readln())
    val n = st.nextToken().toInt()
    val k = st.nextToken().toInt()

    st = StringTokenizer(readln())
    val nums = IntArray(n)
    repeat(n) { nums[it] = st.nextToken().toInt() }

    var start = 0
    var oddCount = 0
    var maxLength = 0
    for (end in 0 until n) {
        if (nums[end] and 1 == 1) {
            if (oddCount < k) {
                ++oddCount
            } else {
                while (nums[start] and 1 == 0) ++start
                ++start
            }
        }
        maxLength = max(maxLength, b = end - start + 1 - oddCount)
    }

    print(maxLength)
}
