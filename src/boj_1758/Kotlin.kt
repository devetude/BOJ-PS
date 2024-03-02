package boj_1758

fun main() = IntArray(readln().toInt()) { readln().toInt() }
    .apply { sortDescending() }
    .foldIndexed(initial = 0L) { i, acc, tip -> acc + (tip - i).coerceAtLeast(minimumValue = 0) }
    .run(::print)
