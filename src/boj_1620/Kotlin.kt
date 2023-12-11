package boj_1620

import java.util.HashMap
import java.util.StringTokenizer

fun main() {
    val st = StringTokenizer(readln())
    val n = st.nextToken().toInt()
    val m = st.nextToken().toInt()

    val nameNumberMap = HashMap<String, Int>()
    val numberNameMap = HashMap<Int, String>()
    repeat(n) {
        val name = readln()
        nameNumberMap[name] = it + 1
        numberNameMap[it + 1] = name
    }
    val results = buildString {
        repeat(m) {
            val input = readln()
            val result = nameNumberMap[input] ?: numberNameMap[input.toInt()]
            appendLine(result)
        }
    }

    System.out.bufferedWriter().use {
        it.write(results)
        it.flush()
    }
}
