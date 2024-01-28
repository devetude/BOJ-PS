package boj_1074

import java.util.StringTokenizer

val VISIT_STEP_RANGE: IntRange = 0 until 2

var r: Int = 0
var c: Int = 0

var curSeq: Int = 0
var rcSeq: Int = 0

fun main() {
    val st = StringTokenizer(readln())
    val n = st.nextToken().toInt()
    r = st.nextToken().toInt()
    c = st.nextToken().toInt()

    visit(size = 1 shl n)

    print(rcSeq)
}

fun visit(size: Int, row: Int = 0, col: Int = 0) {
    if (row == r && col == c) {
        rcSeq = curSeq
        return
    }

    if (row + size <= r || col + size <= c || r < row || c < col) {
        curSeq += size * size
        return
    }

    val newSize = size shr 1
    for (rowStep in VISIT_STEP_RANGE) {
        val newRow = row + rowStep * newSize
        for (colStep in VISIT_STEP_RANGE) {
            val newCol = col + colStep * newSize
            visit(newSize, newRow, newCol)
        }
    }
}
