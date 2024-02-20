package boj_4256

import java.util.StringTokenizer

lateinit var preorder: IntArray
lateinit var inorderIdxOf: IntArray
val resultBuilder: StringBuilder = StringBuilder()

fun main() {
    repeat(readln().toInt()) {
        val n = readln().toInt()

        var st = StringTokenizer(readln())
        preorder = IntArray(n) { st.nextToken().toInt() }

        st = StringTokenizer(readln())
        inorderIdxOf = IntArray(size = n + 1)
        repeat(n) { inorderIdxOf[st.nextToken().toInt()] = it }

        buildPostorder()
        resultBuilder.appendLine()
    }

    System.out.bufferedWriter().use {
        it.write(resultBuilder.toString())
        it.flush()
    }
}

fun buildPostorder(
    preorderIdx: Int = 0,
    beginIdx: Int = 0,
    endIdx: Int = preorder.lastIndex
) {
    val value = preorder[preorderIdx]
    val inorderIdx = inorderIdxOf[value]

    val leftEndIdx = inorderIdx - 1
    if (beginIdx <= leftEndIdx) {
        val leftPreorderIdx = preorderIdx + 1
        buildPostorder(leftPreorderIdx, beginIdx, leftEndIdx)
    }

    val rightStartIdx = inorderIdx + 1
    if (rightStartIdx <= endIdx) {
        val rightPreorderIdx = preorderIdx + rightStartIdx - beginIdx
        buildPostorder(rightPreorderIdx, rightStartIdx, endIdx)
    }

    resultBuilder.append(value, ' ')
}
