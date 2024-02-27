package boj_1946

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.StringTokenizer

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val sb = StringBuilder()
    repeat(br.readLine().toInt()) {
        val n = br.readLine().toInt()
        val ranks = IntArray(size = n + 1)
        repeat(n) {
            val st = StringTokenizer(br.readLine())
            ranks[st.nextToken().toInt()] = st.nextToken().toInt()
        }

        var count = 0
        var requiredRank = Int.MAX_VALUE
        for (i in 1..n) {
            if (ranks[i] < requiredRank) {
                ++count
                requiredRank = ranks[i]
                if (requiredRank == 1) break
            }
        }
        sb.appendLine(count)
    }

    val bw = BufferedWriter(OutputStreamWriter(System.out))
    bw.write(sb.toString())
    bw.flush()
}
