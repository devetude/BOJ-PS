package boj_11659

import java.util.StringTokenizer

fun main() {
    var st = StringTokenizer(readln())
    val n = st.nextToken().toInt()
    val m = st.nextToken().toInt()

    st = StringTokenizer(readln())
    var acc = 0
    val subSums = IntArray(n) { acc += st.nextToken().toInt(); acc }

    val result = buildString {
        repeat(m) {
            st = StringTokenizer(readln())
            val i = st.nextToken().toInt()
            val j = st.nextToken().toInt()
            val sum = subSums[j - 1] - if (1 < i) subSums[i - 2] else 0
            appendLine(sum)
        }
    }

    System.out.bufferedWriter().use {
        it.write(result)
        it.flush()
    }
}
