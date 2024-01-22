package boj_15688

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.Arrays

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val arr = IntArray(br.readLine().toInt()) { br.readLine().toInt() }
    Arrays.sort(arr)

    val sb = StringBuilder()
    arr.forEach {
        sb.append(it)
        sb.append("\n")
    }
    print(sb.toString())
}
