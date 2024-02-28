package boj_15688

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val counts = IntArray(size = 2_000_001)
    repeat(br.readLine().toInt()) { ++counts[br.readLine().toInt() + 1_000_000] }

    val sb = StringBuilder()
    counts.forEachIndexed { i, count -> repeat(count) { sb.appendLine(value = i - 1_000_000) } }

    val bw = BufferedWriter(OutputStreamWriter(System.out))
    bw.write(sb.toString())
    bw.flush()
}
