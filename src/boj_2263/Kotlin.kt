package boj_2263

import java.util.StringTokenizer

lateinit var inorderIdxOf: IntArray
lateinit var postorder: IntArray
val resultBuilder: StringBuilder = StringBuilder()

fun main() {
    val n = readln().toInt()

    var st = StringTokenizer(readln())
    inorderIdxOf = IntArray(size = n + 1)
    repeat(n) { inorderIdxOf[st.nextToken().toInt()] = it }

    st = StringTokenizer(readln())
    postorder = IntArray(n) { st.nextToken().toInt() }

    buildPreorder()

    System.out.bufferedWriter().use {
        it.write(resultBuilder.toString())
        it.flush()
    }
}

fun buildPreorder(
    postorderRange: IntRange = postorder.indices,
    inorderRange: IntRange = postorderRange
) {
    if (with(postorderRange) { last < first }) return
    if (with(inorderRange) { last < first }) return

    val value = postorder[postorderRange.last]
    resultBuilder.append(value, ' ')

    val inorderIdx = inorderIdxOf[value]
    val length = inorderIdx - inorderRange.first

    val leftPostorderRange = postorderRange.first..<postorderRange.first + length
    val leftInorderRange = inorderRange.first..<inorderIdx
    buildPreorder(leftPostorderRange, leftInorderRange)

    val rightPostorderRange = postorderRange.first + length..<postorderRange.last
    val rightInorderRange = inorderIdx + 1..inorderRange.last
    buildPreorder(rightPostorderRange, rightInorderRange)
}
