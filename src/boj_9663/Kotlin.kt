package boj_9663

import kotlin.math.abs

var cases = 0

fun main() {
    val n = readln().toInt()

    val cols = IntArray(n)
    dfs(cols)

    println(cases)
}

fun dfs(cols: IntArray, row: Int = 0) {
    if (row == cols.size) {
        ++cases
        return
    }

    for (col in cols.indices) {
        cols[row] = col
        if (isPromising(cols, row)) {
            dfs(cols, row = row + 1)
        }
    }
}

fun isPromising(cols: IntArray, row: Int): Boolean {
    for (i in 0 until row) {
        if (cols[row] == cols[i]) return false
        if (row - i == abs(n = cols[row] - cols[i])) return false
    }

    return true
}
