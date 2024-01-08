package boj_17626

import kotlin.math.min

fun main() {
    val n = readln().toInt()

    val memory = IntArray(size = n + 1)
    for (i in 1..n) {
        memory[i] = memory[i - 1] + 1
        var j = 1
        while (j * j <= i) {
            memory[i] = min(memory[i], b = memory[i - j * j] + 1)
            ++j
        }
    }

    print(memory[n])
}
