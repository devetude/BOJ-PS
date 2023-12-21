package boj_2156

import kotlin.math.max

fun main() {
    val n = readln().toInt()
    val quantities = IntArray(size = n + 1)
    repeat(n) { quantities[it + 1] = readln().toInt() }
    if (n == 1) return println(quantities[1])

    val maxQuantities = IntArray(size = n + 1)
    maxQuantities[1] = quantities[1]
    maxQuantities[2] = quantities[1] + quantities[2]

    for (i in 3..n) {
        val case1 = maxQuantities[i - 2] + quantities[i]
        val case2 = maxQuantities[i - 1]
        val case3 = maxQuantities[i - 3] + quantities[i - 1] + quantities[i]
        maxQuantities[i] = max(case1, max(case2, case3))
    }

    println(maxQuantities[n])
}
