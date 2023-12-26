package boj_4796

import java.util.StringTokenizer
import kotlin.math.min

fun main() {
    val result = buildString {
        var case = 1
        while (true) {
            val st = StringTokenizer(readln())
            val l = st.nextToken().toLong()
            val p = st.nextToken().toLong()
            val v = st.nextToken().toLong()
            if (l == 0L && p == 0L && v == 0L) break

            append("Case", " ", case++, ": ", v / p * l + min(a = v % p, l), "\n")
        }
    }

    System.out.bufferedWriter().use {
        it.write(result)
        it.flush()
    }
}
