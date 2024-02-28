package boj_2693

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.StringTokenizer

lateinit var arr: IntArray

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val sb = StringBuilder()
    repeat(readln().toInt()) {
        val st = StringTokenizer(br.readLine())
        arr = IntArray(size = 10) { st.nextToken().toInt() }
        sb.appendLine(quickSelect(k = 7))
    }

    val bw = BufferedWriter(OutputStreamWriter(System.out))
    bw.write(sb.toString())
    bw.flush()
}

fun quickSelect(k: Int, start: Int = 0, end: Int = arr.size): Int {
    val pivot = arr[start]
    var left = start + 1
    var right = end - 1
    while (true) {
        while (left <= right && arr[left] <= pivot) ++left
        while (left <= right && pivot <= arr[right]) --right
        if (right < left) break

        val tmp = arr[left]
        arr[left] = arr[right]
        arr[right] = tmp
    }
    arr[start] = arr[right]
    arr[right] = pivot

    return when {
        k < right -> quickSelect(k, start, right)
        right < k -> quickSelect(k, start = right + 1, end)
        else -> arr[right]
    }
}
