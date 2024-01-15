package boj_3986

import java.util.Stack

fun main() {
    var count = 0
    repeat(readln().toInt()) {
        val stack = Stack<Char>()
        readln().forEach {
            if (stack.isNotEmpty() && stack.peek() == it) {
                stack.pop()
            } else {
                stack.push(it)
            }
        }
        if (stack.isEmpty()) ++count
    }

    print(count)
}
