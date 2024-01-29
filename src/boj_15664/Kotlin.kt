package boj_15664

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

fun buildPerm(m: Int, i: Int = 0, permBuilder: StringBuilder = StringBuilder()) {
    if (m == 0) {
        resultBuilder.appendLine(permBuilder)
        return
    }

    var last = 0
    for (j in i until nums.size) {
        if (isVisited[i] || nums[j] == last) continue

        isVisited[i] = true
        last = nums[j]
        val newPermBuilder = StringBuilder(permBuilder).append(nums[j], ' ')
        buildPerm(m = m - 1, i = j + 1, newPermBuilder)
        isVisited[i] = false
    }
}
