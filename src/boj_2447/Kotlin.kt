package boj_2447

val PAINTS: CharArray = charArrayOf('*', ' ')
val PATTERN_STEP_RANGE: IntRange = 0 until 3

fun main() {
    val n = readln().toInt()

    val canvas = Array(n) { CharArray(n) }
    canvas.draw(n)

    System.out.bufferedWriter().use { bw ->
        bw.write(canvas.joinToString(separator = "\n") { it.joinToString(separator = "") })
        bw.flush()
    }
}

fun Array<CharArray>.draw(
    size: Int,
    row: Int = 0,
    col: Int = 0,
    paintType: Int = 0
) {
    if (size == 1) {
        this[row][col] = PAINTS[paintType]
        return
    }

    val newSize = size / 3
    var i = 0
    for (rowStep in PATTERN_STEP_RANGE) {
        val newRow = row + rowStep * newSize
        for (colStep in PATTERN_STEP_RANGE) {
            val newCol = col + colStep * newSize
            val newPaintType = if (paintType == 1 || i++ == 4) 1 else 0
            draw(newSize, newRow, newCol, newPaintType)
        }
    }
}
