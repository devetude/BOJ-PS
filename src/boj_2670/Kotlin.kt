package boj_2670

import kotlin.math.max

fun main() {
    val n = readln().toInt()

    val memory = DoubleArray(n)
    memory[0] = readln().toDouble()
    var maxValue = 0.0
    for (i in 1 until n) {
        val float = readln().toDouble()
        memory[i] = max(float, b = memory[i - 1] * float)
        maxValue = max(maxValue, memory[i])
    }

    print(String.format("%.3f", maxValue))
}
