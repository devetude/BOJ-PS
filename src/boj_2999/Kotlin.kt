package boj_2999

import kotlin.math.sqrt

fun main() {
    val m = readln()

    val n = m.length
    var r = 1
    var c = n
    for (i in sqrt(n.toDouble()).toInt() downTo 1) {
        r = i
        c = n / r
        if (r * c != n) continue
        if (r <= c) break
    }

    val matrix = Array(r) { CharArray(c) }
    var i = 0
    for (col in 0 until c) {
        for (row in 0 until r) matrix[row][col] = m[i++]
    }

    val sb = StringBuilder()
    for (row in 0 until r) {
        for (col in 0 until c) sb.append(matrix[row][col])
    }

    print(sb.toString())
}
