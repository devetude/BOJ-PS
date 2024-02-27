package boj_11728

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.StringTokenizer

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    var st = StringTokenizer(br.readLine())
    val n = st.nextToken().toInt()
    val m = st.nextToken().toInt()

    st = StringTokenizer(br.readLine())
    val a = IntArray(n) { st.nextToken().toInt() }.apply { sort() }

    st = StringTokenizer(br.readLine())
    val b = IntArray(m) { st.nextToken().toInt() }.apply { sort() }

    val sb = StringBuilder()
    var i = 0
    var j = 0
    while (true) {
        when {
            i == n && j == m -> break
            i == n -> sb.append(b[j++])
            j == m -> sb.append(a[i++])
            a[i] < b[j] -> sb.append(a[i++])
            b[j] < a[i] -> sb.append(b[j++])
            else -> sb.append(a[i++], ' ', b[j++])
        }
        sb.append(' ')
    }

    val bw = BufferedWriter(OutputStreamWriter(System.out))
    bw.write(sb.toString())
    bw.flush()
}
