package boj_15663

import java.util.StringTokenizer

lateinit var nums: IntArray
lateinit var isVisited: BooleanArray

val resultBuilder: StringBuilder = StringBuilder()

fun main() {
    var st = StringTokenizer(readln())
    val n = st.nextToken().toInt()
    val m = st.nextToken().toInt()

    st = StringTokenizer(readln())
    nums = IntArray(n) { st.nextToken().toInt() }.apply { sort() }

    isVisited = BooleanArray(n)

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
    nums.forEachIndexed { i, num ->
        if (isVisited[i] || num == last) return@forEachIndexed

        isVisited[i] = true
        last = num
        val newPermBuilder = StringBuilder(permBuilder).append(num, ' ')
        buildPerm(m = m - 1, newPermBuilder)
        isVisited[i] = false
    }
}
