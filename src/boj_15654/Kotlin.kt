package boj_15654

import java.util.StringTokenizer

const val SPACE: Char = ' '

lateinit var isVisited: BooleanArray
val resultBuilder: StringBuilder = StringBuilder()

fun main() {
    var st = StringTokenizer(readln())
    val n = st.nextToken().toInt()
    val m = st.nextToken().toInt()

    st = StringTokenizer(readln())
    val arr = IntArray(n) { st.nextToken().toInt() }.apply { sort() }

    isVisited = BooleanArray(n)
    arr.forEachIndexed { i, num ->
        isVisited[i] = true
        arr.buildPerm(m = m - 1, StringBuilder().appendSpace(num))
        isVisited[i] = false
    }

    System.out.bufferedWriter().use {
        it.write(resultBuilder.toString())
        it.flush()
    }
}

fun IntArray.buildPerm(m: Int, permBuilder: StringBuilder) {
    if (m == 0) {
        resultBuilder.appendLine(permBuilder)
        return
    }

    forEachIndexed { i, num ->
        if (isVisited[i]) return@forEachIndexed

        isVisited[i] = true
        buildPerm(m = m - 1, StringBuilder(permBuilder).appendSpace(num))
        isVisited[i] = false
    }
}

fun StringBuilder.appendSpace(num: Int): StringBuilder = append(num, SPACE)
