package boj_14921

import java.util.StringTokenizer
import kotlin.math.abs

fun main() {
    val n = readln().toInt()

    val st = StringTokenizer(readln())
    val a = IntArray(n) { st.nextToken().toInt() }

    var left = 0
    var right = a.lastIndex
    var b = Int.MAX_VALUE
    while (left < right) {
        val sum = a[left] + a[right]
        if (abs(sum) < abs(b)) b = sum

        when {
            sum < 0 -> ++left
            0 < sum -> --right
            else -> break
        }
    }

    print(b)
}
