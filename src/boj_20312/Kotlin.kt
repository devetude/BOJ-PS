package boj_20312

import java.util.StringTokenizer

fun main() {
    val n = readln().toInt()

    val st = StringTokenizer(readln())
    var sum = 0L
    var previous = 0L
    for (i in 0 until n - 1) {
        previous = (previous + 1) * st.nextToken().toLong() % 1_000_000_007L
        sum += previous
        sum %= 1_000_000_007L
    }

    print(sum)
}
