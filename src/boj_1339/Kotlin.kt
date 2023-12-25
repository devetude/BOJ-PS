package boj_1339

import kotlin.math.pow

fun main() {
    val n = readln().toInt()

    val values = IntArray(size = 26)
    repeat(n) {
        val word = readln()
        word.forEachIndexed { i, c -> values[c - 'A'] += 10.pow(n = word.lastIndex - i) }
    }

    values.sortDescending()
    var multiplier = 9
    var maxSum = 0
    for (value in values) {
        if (value == 0) break

        maxSum += value * multiplier--
    }

    println(maxSum)
}

private fun Int.pow(n: Int): Int = toDouble().pow(n.toDouble()).toInt()
