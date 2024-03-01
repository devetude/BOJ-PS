package boj_2217

fun main() = IntArray(readln().toInt()) { readln().toInt() }
    .apply { sortDescending() }
    .foldIndexed(initial = 0) { i, maxWeight, weight -> maxOf(maxWeight, b = (i + 1) * weight) }
    .run(::print)
