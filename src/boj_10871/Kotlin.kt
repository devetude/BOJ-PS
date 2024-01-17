package boj_10871

import java.util.StringTokenizer

fun main() {
    var st = StringTokenizer(readln())
    val n = st.nextToken().toInt()
    val x = st.nextToken().toShort()

    System.out.bufferedWriter().use { bw ->
        st = StringTokenizer(readln())
        repeat(n) {
            val a = st.nextToken()
            if (a.toShort() < x) {
                bw.write(a)
                bw.write(" ")
            }
        }
        bw.flush()
    }
}
