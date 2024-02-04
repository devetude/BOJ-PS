package boj_2467

import java.util.StringTokenizer
import kotlin.math.abs

fun main() {
    val n = readln().toInt()

    val st = StringTokenizer(readln())
    val a = IntArray(n) { st.nextToken().toInt() }

    var left = 0
    var right = a.lastIndex
    var b = Int.MAX_VALUE
    var matchedLeft = 0
    var matchedRight = right
    while (left < right) {
        val sum = a[left] + a[right]
        if (abs(sum) < abs(b)) {
            matchedLeft = left
            matchedRight = right
            b = sum
        }

        when {
            sum < 0 -> ++left
            0 < sum -> --right
            else -> break
        }
    }

    print("${a[matchedLeft]} ${a[matchedRight]}")
}
