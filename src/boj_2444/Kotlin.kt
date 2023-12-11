package boj_2444

fun main() {
    val n = readln().toInt()

    val result = buildString {
        for (rowIdx in 0 until n) appendStars(rowIdx, n)
        for (rowIdx in n - 2 downTo 0) appendStars(rowIdx, n)
    }

    System.out.bufferedWriter().use {
        it.write(result)
        it.flush()
    }
}

fun StringBuilder.appendStars(rowIdx: Int, n: Int) {
    val starCount = rowIdx * 2 + 1
    val indentCount = n - rowIdx - 1
    for (indentIdx in 0 until indentCount) append(" ")
    for (starIdx in 0 until starCount) append("*")
    appendLine()
}
