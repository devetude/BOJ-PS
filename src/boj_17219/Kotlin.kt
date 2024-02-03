package boj_17219

import java.util.StringTokenizer

fun main() {
    var st = StringTokenizer(readln())
    val n = st.nextToken().toInt()
    val m = st.nextToken().toInt()

    val map = HashMap<String, String>()
    repeat(n) {
        st = StringTokenizer(readln())
        map[st.nextToken()] = st.nextToken()
    }
    val result = buildString { repeat(m) { appendLine(map[readln()]) } }

    System.out.bufferedWriter().use {
        it.write(result)
        it.flush()
    }
}
