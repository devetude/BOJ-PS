package boj_1780

import java.util.StringTokenizer

const val CROP_SIZE: Int = 3
val CROP_STEP_RANGE: IntRange = 0 until CROP_SIZE

val colorSizes: IntArray = IntArray(size = 3)

fun main() {
    val n = readln().toInt()

    val paper = Array(n) {
        val st = StringTokenizer(readln())
        IntArray(n) { st.nextToken().toInt() }
    }

    paper.crop(n)

    print(colorSizes.joinToString(separator = "\n"))
}

fun Array<IntArray>.crop(size: Int, row: Int = 0, col: Int = 0) {
    val rowRange = row until row + size
    val colRange = col until col + size
    if (!isCropRequired(rowRange, colRange)) {
        ++colorSizes[this[row][col] + 1]
        return
    }

    val newSize = size / CROP_SIZE
    for (rowStep in CROP_STEP_RANGE) {
        val newRow = row + rowStep * newSize
        for (colStep in CROP_STEP_RANGE) {
            val newCol = col + colStep * newSize
            crop(newSize, newRow, newCol)
        }
    }
}

fun Array<IntArray>.isCropRequired(rowRange: IntRange, colRange: IntRange): Boolean {
    val color = this[rowRange.first][colRange.first]
    for (row in rowRange) {
        for (col in colRange) {
            if (this[row][col] != color) return true
        }
    }

    return false
}
