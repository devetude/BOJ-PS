package boj_11054

import java.util.StringTokenizer
import kotlin.math.max

fun main() {
    val n = readln().toInt()
    val st = StringTokenizer(readln())
    val numbers = IntArray(n)
    repeat(n) { numbers[it] = st.nextToken().toInt() }

    val increaseMemory = IntArray(n) { 1 }
    for (i in numbers.indices) {
        for (j in 0 until i) {
            if (numbers[j] < numbers[i] && increaseMemory[i] < increaseMemory[j] + 1) {
                increaseMemory[i] = increaseMemory[j] + 1
            }
        }
    }

    val decreaseMemory = IntArray(n) { 1 }
    for (i in numbers.lastIndex downTo 0) {
        for (j in numbers.lastIndex downTo i + 1) {
            if (numbers[j] < numbers[i] && decreaseMemory[i] < decreaseMemory[j] + 1) {
                decreaseMemory[i] = decreaseMemory[j] + 1
            }
        }
    }

    var maxLength = Int.MIN_VALUE
    for (i in 0 until n) {
        maxLength = max(maxLength, increaseMemory[i] + decreaseMemory[i] - 1)
    }

    println(maxLength)
}
