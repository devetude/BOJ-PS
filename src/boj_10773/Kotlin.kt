package boj_10773

import java.util.Stack

fun main() {
    val stack = Stack<Int>()
    repeat(readln().toInt()) {
        when (val num = readln().toInt()) {
            0 -> stack.pop()
            else -> stack.push(num)
        }
    }

    println(stack.sum())
}
