package boj_6603

import java.util.StringTokenizer

lateinit var nums: IntArray

val resultBuilder: StringBuilder = StringBuilder()

fun main() {
    var line: String
    while (readln().also { line = it } != "0") {
        val st = StringTokenizer(line)
        val k = st.nextToken().toInt()
        nums = IntArray(k) { st.nextToken().toInt() }

        buildPerm()
        resultBuilder.appendLine()
    }

    System.out.bufferedWriter().use {
        it.write(resultBuilder.toString())
        it.flush()
    }
}

fun buildPerm(m: Int = 6, i: Int = 0, permBuilder: StringBuilder = StringBuilder()) {
    if (m == 0) {
        resultBuilder.appendLine(permBuilder)
        return
    }

    for (j in i until nums.size) {
        val newPermBuilder = StringBuilder(permBuilder).append(nums[j], ' ')
        buildPerm(m = m - 1, i = j + 1, newPermBuilder)
    }
}
