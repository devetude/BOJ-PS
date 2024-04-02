package boj_2170

import java.util.StringTokenizer

fun main() {
    val points = MutableList(readln().toInt()) {
        val st = StringTokenizer(readln())
        Point(st.nextToken().toInt(), st.nextToken().toInt())
    }.apply { sort() }

    var prevY = -1_000_000_000
    var length = 0
    points.forEach { point ->
        when {
            prevY <= point.x -> {
                length += point.y - point.x
                prevY = point.y
            }

            prevY < point.y -> {
                length += point.y - prevY
                prevY = point.y
            }

            else -> return@forEach
        }
    }

    print(length)
}

private data class Point(val x: Int, val y: Int) : Comparable<Point> {
    override fun compareTo(other: Point): Int =
        compareValuesBy(a = this, other, { it.x }, { it.y })
}
