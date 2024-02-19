package boj_2776

import java.util.StringTokenizer

fun main() {
    val sb = StringBuilder()
    repeat(readln().toInt()) {
        val n = readln().toInt()
        var st = StringTokenizer(readln())
        val set = HashSet<Int>(n).apply { repeat(n) { add(st.nextToken().toInt()) } }

        val m = readln().toInt()
        st = StringTokenizer(readln())
        repeat(m) { sb.appendLine(if (st.nextToken().toInt() in set) 1 else 0) }
    }

    System.out.bufferedWriter().use {
        it.write(sb.toString())
        it.flush()
    }
}
