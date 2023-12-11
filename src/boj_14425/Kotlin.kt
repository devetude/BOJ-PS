package boj_14425

import java.util.StringTokenizer

fun main() {
    val st = StringTokenizer(readln())
    val n = st.nextToken().toInt()
    val m = st.nextToken().toInt()
    val set = HashSet<String>()
    repeat(n) { set.add(readln()) }

    var count = 0
    repeat(m) { if (readln() in set) ++count }

    println(count)
}
