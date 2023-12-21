package boj_9184

import java.util.StringTokenizer

val memory = Array(size = 21) { Array(size = 21) { IntArray(size = 21) { Int.MIN_VALUE } } }

fun main() {
    val result = buildString {
        while (true) {
            val st = StringTokenizer(readln())
            val a = st.nextToken().toInt()
            val b = st.nextToken().toInt()
            val c = st.nextToken().toInt()

            if (a == -1 && b == -1 && c == -1) break

            append("w(", a, ", ", b, ", ", c, ") = ", w(a, b, c))
            appendLine()
        }
    }

    System.out.bufferedWriter().use {
        it.write(result)
        it.flush()
    }
}

fun w(a: Int, b: Int, c: Int): Int {
    if (a <= 0 || b <= 0 || c <= 0) return 1

    if (20 < a || 20 < b || 20 < c) {
        if (memory[20][20][20] == Int.MIN_VALUE) {
            memory[20][20][20] = w(20, 20, 20)
        }
        return memory[20][20][20]
    }

    if (b in (a + 1)..<c) {
        if (memory[a][b][c - 1] == Int.MIN_VALUE) {
            memory[a][b][c - 1] = w(a, b, c - 1)
        }
        if (memory[a][b - 1][c - 1] == Int.MIN_VALUE) {
            memory[a][b - 1][c - 1] = w(a, b - 1, c - 1)
        }
        if (memory[a][b - 1][c] == Int.MIN_VALUE) {
            memory[a][b - 1][c] = w(a, b - 1, c)
        }
        return memory[a][b][c - 1] + memory[a][b - 1][c - 1] - memory[a][b - 1][c]
    }

    if (memory[a - 1][b][c] == Int.MIN_VALUE) {
        memory[a - 1][b][c] = w(a - 1, b, c)
    }
    if (memory[a - 1][b - 1][c] == Int.MIN_VALUE) {
        memory[a - 1][b - 1][c] = w(a - 1, b - 1, c)
    }
    if (memory[a - 1][b][c - 1] == Int.MIN_VALUE) {
        memory[a - 1][b][c - 1] = w(a - 1, b, c - 1)
    }
    if (memory[a - 1][b - 1][c - 1] == Int.MIN_VALUE) {
        memory[a - 1][b - 1][c - 1] = w(a - 1, b - 1, c - 1)
    }
    return memory[a - 1][b][c] +
            memory[a - 1][b - 1][c] +
            memory[a - 1][b][c - 1] -
            memory[a - 1][b - 1][c - 1]
}
