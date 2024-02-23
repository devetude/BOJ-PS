package boj_5347

import java.util.StringTokenizer

fun main() {
    val sb = StringBuilder()
    repeat(readln().toInt()) {
        val st = StringTokenizer(readln())
        val a = st.nextToken().toLong()
        val b = st.nextToken().toLong()
        sb.appendLine(lcm(a, b))
    }

    System.out.bufferedWriter().use {
        it.write(sb.toString())
        it.flush()
    }
}

fun lcm(a: Long, b: Long): Long = a * b / gcd(maxOf(a, b), minOf(a, b))

fun gcd(max: Long, min: Long): Long {
    var a = max
    var b = min
    while (true) {
        val r = a % b
        if (r == 0L) break

        a = b
        b = r
    }

    return b
}
