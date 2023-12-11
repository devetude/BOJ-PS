package boj_14215

import java.util.StringTokenizer

fun main() {
    val sides = buildList {
        val st = StringTokenizer(readln())
        repeat(times = 3) { add(st.nextToken().toInt()) }
    }.sorted()

    val maxSide = (sides[0] + sides[1] - 1).coerceAtMost(sides[2])

    println(sides[0] + sides[1] + maxSide)
}
