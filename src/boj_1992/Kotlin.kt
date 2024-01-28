package boj_1992

const val START_PARENTHESES: Char = '('
const val END_PARENTHESES: Char = ')'

val COMPRESS_STEP_RANGE: IntRange = 0 until 2

fun main() {
    val n = readln().toInt()

    val screen = Array(n) { readln() }

    val dataBuilder = StringBuilder()
    screen.compress(n, dataBuilder)

    print(dataBuilder.toString())
}

fun Array<String>.compress(size: Int, dataBuilder: StringBuilder, row: Int = 0, col: Int = 0) {
    val rowRange = row until row + size
    val colRange = col until col + size
    if (isAbleToCompress(rowRange, colRange)) {
        dataBuilder.append(this[row][col])
        return
    }

    dataBuilder.append(START_PARENTHESES)
    val newSize = size shr 1
    for (rowStep in COMPRESS_STEP_RANGE) {
        val newRow = row + rowStep * newSize
        for (colStep in COMPRESS_STEP_RANGE) {
            val newCol = col + colStep * newSize
            compress(newSize, dataBuilder, newRow, newCol)
        }
    }
    dataBuilder.append(END_PARENTHESES)
}

fun Array<String>.isAbleToCompress(rowRange: IntRange, colRange: IntRange): Boolean {
    val data = this[rowRange.first][colRange.first]
    for (row in rowRange) {
        for (col in colRange) {
            if (this[row][col] != data) return false
        }
    }

    return true
}
