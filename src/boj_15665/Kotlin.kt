package boj_15665

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

fun buildPerm(m: Int, permBuilder: StringBuilder = StringBuilder()) {
    if (m == 0) {
        resultBuilder.appendLine(permBuilder)
        return
    }

    var last = 0
    nums.forEach {
        if (it == last) return@forEach

        last = it
        val newPermBuilder = StringBuilder(permBuilder).append(it, ' ')
        buildPerm(m = m - 1, newPermBuilder)
    }
}
