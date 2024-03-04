package boj_2512

import java.util.StringTokenizer

fun main() {
    val n = readln().toInt()
    val st = StringTokenizer(readln())
    val budgets = IntArray(n) { st.nextToken().toInt() }
    val m = readln().toInt()

    budgets.sort()
    var min = 1
    var max = budgets.last()
    while (min <= max) {
        val mid = min + max shr 1
        val sum = budgets.sumOf { if (mid < it) mid else it }
        if (m < sum) {
            max = mid - 1
        } else {
            min = mid + 1
        }
    }

    print(max)
}
