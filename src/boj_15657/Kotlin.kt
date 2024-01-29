package boj_15657

import java.util.StringTokenizer

lateinit var nums: IntArray

val resultBuilder: StringBuilder = StringBuilder()

fun main() {
    var st = StringTokenizer(readln())
    val n = st.nextToken().toInt()
    val m = st.nextToken().toInt()

    st = StringTokenizer(readln())
    nums = IntArray(n) { st.nextToken().toInt() }.apply { sort() }

    buildPerm(m)

    System.out.bufferedWriter().use {
        it.write(resultBuilder.toString())
        it.flush()
    }
}

fun buildPerm(m: Int, i: Int = 0, permBuilder: StringBuilder = StringBuilder()) {
    if (m == 0) {
        resultBuilder.appendLine(permBuilder)
        return
    }

    for (j in i until nums.size) {
        val newPermBuilder = StringBuilder(permBuilder).append(nums[j], ' ')
        buildPerm(m = m - 1, j, newPermBuilder)
    }
}
