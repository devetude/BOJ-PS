package boj_11003

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.StringTokenizer

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))

    var st = StringTokenizer(br.readLine(), " ")
    val n = st.nextToken().toInt()
    val l = st.nextToken().toInt()

    st = StringTokenizer(br.readLine(), " ")
    val a = IntArray(n)
    val deque = ArrayDeque<Int>(l)
    repeat(n) {
        a[it] = st.nextToken().toInt()
        if (deque.isNotEmpty() && deque.first() <= it - l) deque.removeFirst()
        while (deque.isNotEmpty() && a[it] <= a[deque.last()]) deque.removeLast()
        deque.addLast(it)
        bw.write("${a[deque.first()]} ")
    }

    bw.flush()
    bw.close()
    br.close()
}
