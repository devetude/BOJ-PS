package boj_17298

import java.util.Stack
import java.util.StringTokenizer

fun main() {
    val n = readln().toInt()
    val st = StringTokenizer(readln())
    val numbers = IntArray(n)
    repeat(n) { numbers[it] = st.nextToken().toInt() }

    val idxStack = Stack<Int>()
    for (i in numbers.indices) {
        while (idxStack.isNotEmpty() && numbers[idxStack.peek()] < numbers[i])
            numbers[idxStack.pop()] = numbers[i]
        idxStack.push(i)
    }
    while (idxStack.isNotEmpty()) numbers[idxStack.pop()] = -1

    System.out.bufferedWriter().use {
        it.write(numbers.joinToString(separator = " "))
        it.flush()
    }
}
