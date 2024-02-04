package boj_2512

import java.util.StringTokenizer

fun main() {
    val n = readln().toInt()

    val st = StringTokenizer(readln())
    val budgets = IntArray(n) { st.nextToken().toInt() }.apply { sort() }
    val subSums = budgets.runningReduce { acc, budget -> acc + budget }

    val m = readln().toInt()

    var low = 0
    var high = budgets.last()
    while (low <= high) {
        val mid = low + high shr 1
        val idx = budgets.binarySearch(mid)
        val sum = when {
            idx < -1 -> subSums[-idx - 2] + (n + idx + 1) * mid
            idx == -1 -> n * mid
            else -> subSums[idx] + (n - idx - 1) * mid
        }
        if (sum <= m) low = mid + 1 else high = mid - 1
    }

    print(high)
}
