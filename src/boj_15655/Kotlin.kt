package boj_15655

import java.util.StringTokenizer

const val SPACE: Char = ' '

lateinit var nums: IntArray

val resultBuilder: StringBuilder = StringBuilder()

fun main() {
    var st = StringTokenizer(readln())
    val n = st.nextToken().toInt()
    val m = st.nextToken().toInt()

    st = StringTokenizer(readln())
    nums = IntArray(n) { st.nextToken().toInt() }.apply { sort() }

    for (i in 0..nums.size - m) {
        buildPerm(m = m - 1, i, StringBuilder().appendSpace(nums[i]))
    }

    System.out.bufferedWriter().use {
        it.write(resultBuilder.toString())
        it.flush()
    }
}

fun buildPerm(m: Int, i: Int, permBuilder: StringBuilder) {
    if (m == 0) {
        resultBuilder.appendLine(permBuilder)
        return
    }

    for (j in i + 1..nums.size - m) {
        buildPerm(m = m - 1, j, StringBuilder(permBuilder).appendSpace(nums[j]))
    }
}

fun StringBuilder.appendSpace(num: Int): StringBuilder = append(num, SPACE)

