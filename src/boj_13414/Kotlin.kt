package boj_13414

import java.util.StringTokenizer

fun main() {
    val st = StringTokenizer(readln())
    val k = st.nextToken().toInt()
    val l = st.nextToken().toInt()

    val set = LinkedHashSet<String>()
    repeat(l) { readln().also(set::remove).also(set::add) }
    val result = set.joinToString(separator = "\n", limit = k, truncated = "")

    System.out.bufferedWriter().use {
        it.write(result)
        it.flush()
    }
}
