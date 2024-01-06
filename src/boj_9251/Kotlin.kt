package boj_9251

import kotlin.math.max

fun main() {
    val a = readln()
    val b = readln()

    val lcs = Array(size = a.length + 1) { IntArray(size = b.length + 1) }
    for (i in 1..a.length) {
        for (j in 1..b.length) {
            lcs[i][j] = if (a[i - 1] == b[j - 1]) {
                lcs[i - 1][j - 1] + 1
            } else {
                max(lcs[i - 1][j], lcs[i][j - 1])
            }
        }
    }

    print(lcs[a.length][b.length])
}
