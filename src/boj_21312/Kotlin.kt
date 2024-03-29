package boj_21312

import java.util.StringTokenizer

fun main() {
    val st = StringTokenizer(readln())
    val nums = IntArray(size = 3) { st.nextToken().toInt() }

    val odds = nums.filter { it and 1 == 1 }
    if (odds.isNotEmpty()) return print(odds.fold(initial = 1) { acc, num -> acc * num })

    print(nums.fold(initial = 1) { acc, num -> acc * num })
}
