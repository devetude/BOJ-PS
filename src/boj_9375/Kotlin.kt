package boj_9375

import java.util.StringTokenizer

fun main() {
    val sb = StringBuilder()
    repeat(readln().toInt()) {
        val map = HashMap<String, Int>()
        repeat(readln().toInt()) {
            val st = StringTokenizer(readln())
            st.nextToken()
            val type = st.nextToken()
            map[type] = map.getOrDefault(type, defaultValue = 0) + 1
        }
        val combination = map.values.fold(initial = 1) { acc, size -> acc * (size + 1) } - 1
        sb.appendLine(combination)
    }

    System.out.bufferedWriter().use {
        it.write(sb.toString())
        it.flush()
    }
}
