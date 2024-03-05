package boj_1620

import java.util.StringTokenizer

fun main() {
    val st = StringTokenizer(readln())
    val n = st.nextToken().toInt()
    val m = st.nextToken().toInt()

    val nameOf = Array(size = n + 1) { "" }
    val numOf = HashMap<String, Int>()
    repeat(n) {
        val num = it + 1
        val name = readln()
        nameOf[num] = name
        numOf[name] = num
    }

    val sb = StringBuilder()
    repeat(m) {
        val input = readln()
        val result = if (input[0] in '1'..'9') nameOf[input.toInt()] else numOf[input]
        sb.appendLine(result)
    }

    System.out.bufferedWriter().use {
        it.write(sb.toString())
        it.flush()
    }
}
