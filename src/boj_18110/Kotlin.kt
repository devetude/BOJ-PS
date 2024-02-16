package boj_18110

import kotlin.math.roundToInt

fun main() {
    val n = readln().toInt()
    if (n == 0) return print(0)

    val ranks = IntArray(n) { readln().toInt() }.apply { sort() }
    val except = (n * 0.15).roundToInt()
    val sum = ranks.foldIndexed(initial = 0) { i, acc, rank ->
        acc + if (i in except until n - except) rank else 0
    }
    val avg = (sum.toDouble() / (n - (except shl 1))).roundToInt()

    print(avg)
}
