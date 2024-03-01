package boj_2012

import kotlin.math.abs

fun main() = IntArray(readln().toInt()) { readln().toInt() }
    .apply { sort() }
    .foldIndexed(initial = 0L) { i, acc, rank -> acc + abs(n = i + 1 - rank) }
    .run(::print)
