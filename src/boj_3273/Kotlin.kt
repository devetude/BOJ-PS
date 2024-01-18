package boj_3273

import java.util.StringTokenizer

fun main() {
    val n = readln().toInt()

    val st = StringTokenizer(readln())
    val a = IntArray(n) { st.nextToken().toInt() }

    val x = readln().toInt()

    val checks = BooleanArray(size = 1_000_001)
    var count = 0
    a.forEach {
        val diff = x - it
        if (diff in 1..1_000_000 && checks[diff]) ++count else checks[it] = true
    }

    print(count)
}
