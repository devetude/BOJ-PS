package boj_4256

import java.util.StringTokenizer

lateinit var preorder: IntArray
lateinit var inorder: IntArray
val resultBuilder: StringBuilder = StringBuilder()

fun main() {
    repeat(readln().toInt()) {
        val n = readln().toInt()

        var st = StringTokenizer(readln())
        preorder = IntArray(n) { st.nextToken().toInt() }

        st = StringTokenizer(readln())
        inorder = IntArray(n) { st.nextToken().toInt() }

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
    val inorderIdx = inorder.indexOf(value)

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
