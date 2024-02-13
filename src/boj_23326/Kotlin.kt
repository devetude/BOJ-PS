package boj_23326

import java.util.StringTokenizer
import java.util.TreeSet

fun main() {
    var st = StringTokenizer(readln())
    val n = st.nextToken().toInt()
    val q = st.nextToken().toInt()

    val set = TreeSet<Int>()
    st = StringTokenizer(readln())
    repeat(n) { if (st.nextToken() == "1") set.add(it) }

    var x = 0
    val sb = StringBuilder()
    repeat(q) {
        st = StringTokenizer(readln())
        when (st.nextToken()) {
            "1" -> {
                val i = st.nextToken().toInt() - 1
                if (!set.remove(i)) set.add(i)
            }

            "2" -> {
                x = (x + st.nextToken().toInt()) % n
            }

            else -> {
                val move = if (set.isNotEmpty()) {
                    set.ceiling(x)?.let { it - x } ?: (n - x + set.first())
                } else {
                    -1
                }
                sb.appendLine(move)
            }
        }
    }

    System.out.bufferedWriter().use {
        it.write(sb.toString())
        it.flush()
    }
}
