package boj_11508

fun main() = IntArray(readln().toInt()) { readln().toInt() }
    .apply { sortDescending() }
    .foldIndexed(initial = 0) { i, acc, cost -> acc + if (i % 3 == 2) 0 else cost }
    .run(::print)
