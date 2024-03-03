package boj_1920

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.StringTokenizer

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val n = br.readLine().toInt()
    var st = StringTokenizer(br.readLine())
    val a = IntArray(n) { st.nextToken().toInt() }.apply { sort() }

    val m = br.readLine().toInt()
    st = StringTokenizer(br.readLine())
    val sb = StringBuilder()
    repeat(m) {
        val x = st.nextToken().toInt()
        var start = 0
        var end = n - 1
        while (true) {
            if (end < start) {
                sb.appendLine(value = 0)
                break
            }

            val mid = start + end shr 1
            when {
                x < a[mid] -> end = mid - 1
                a[mid] < x -> start = mid + 1
                else -> {
                    sb.appendLine(value = 1)
                    break
                }
            }
        }
    }

    val bw = BufferedWriter(OutputStreamWriter(System.out))
    bw.write(sb.toString())
    bw.flush()
}
