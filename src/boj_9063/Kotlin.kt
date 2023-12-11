package boj_9063

import java.util.StringTokenizer
import kotlin.math.abs

fun main() {
    var minX = Int.MAX_VALUE
    var maxX = Int.MIN_VALUE
    var minY = Int.MAX_VALUE
    var maxY = Int.MIN_VALUE
    repeat(readln().toInt()) {
        val st = StringTokenizer(readln())
        val x = st.nextToken().toInt()
        val y = st.nextToken().toInt()

        minX = minX.coerceAtMost(x)
        maxX = maxX.coerceAtLeast(x)
        minY = minY.coerceAtMost(y)
        maxY = maxY.coerceAtLeast(y)
    }

    val dX = abs(n = maxX - minX)
    val dY = abs(n = maxY - minY)

    println(dX * dY)
}
