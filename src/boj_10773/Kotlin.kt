package boj_10773

import java.util.Stack

fun main() {
    val stack = Stack<Int>()
    repeat(readln().toInt()) {
        val num = readln().toInt()
        if (0 < num) stack.push(num) else stack.pop()
    }

    print(stack.sum())
}
