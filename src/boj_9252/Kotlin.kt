package boj_9252

import java.util.Stack
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

    var i = a.length
    var j = b.length
    val stack = Stack<Char>()
    while (true) {
        if (lcs[i][j] == 0) break
        if (lcs[i][j] == lcs[i - 1][j]) {
            --i
            continue
        }
        if (lcs[i][j] == lcs[i][j - 1]) {
            --j
            continue
        }
        --i
        --j
        stack.push(a[i])
    }

    System.out.bufferedWriter().use {
        it.write(lcs[a.length][b.length].toString())
        it.write("\n")
        while (stack.isNotEmpty()) {
            it.write(stack.pop().toString())
        }
        it.flush()
    }
}
