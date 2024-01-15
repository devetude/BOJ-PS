package boj_2493

import java.util.Stack
import java.util.StringTokenizer

fun main() {
    val n = readln().toInt()

    val st = StringTokenizer(readln())
    val nums = IntArray(n)
    repeat(n) { nums[it] = st.nextToken().toInt() }

    val stack = Stack<Pair<Int, Int>>()
    val result = IntArray(n)
    for (i in n - 1 downTo 0) {
        while (stack.isNotEmpty() && stack.peek().second < nums[i]) {
            result[stack.pop().first] = i + 1
        }
        stack.push(i to nums[i])
    }

    System.out.bufferedWriter().use {
        it.write(result.joinToString(separator = " "))
        it.flush()
    }
}
