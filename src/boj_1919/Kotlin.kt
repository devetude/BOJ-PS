package boj_1919

import kotlin.math.abs

fun main() {
    val counts = IntArray(size = 26)
    readln().forEach { ++counts[it - 'a'] }
    readln().forEach { --counts[it - 'a'] }

    print(counts.sumOf(::abs))
}
