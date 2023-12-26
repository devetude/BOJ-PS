package boj_2437

import java.util.StringTokenizer

fun main() {
    val n = readln().toInt()
    val st = StringTokenizer(readln())

    val weights = IntArray(n)
    repeat(n) { weights[it] = st.nextToken().toInt() }

    weights.sort()
    var sum = 0
    for (weight in weights) {
        if (sum + 1 < weight) break

        sum += weight
    }

    println(sum + 1)
}
