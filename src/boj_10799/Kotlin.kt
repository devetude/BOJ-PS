package boj_10799

import java.util.Stack

fun main() {
    val brackets = readln()
    val stack = Stack<Char>()
    var size = 0
    for (i in brackets.indices) {
        if (brackets[i] == '(') {
            stack.push(brackets[i])
            continue
        }

        stack.pop()
        size += if (brackets[i - 1] == '(') stack.size else 1
    }

    print(size)
}
