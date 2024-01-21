package boj_2504

import java.util.Stack

fun main() {
    val result = try {
        val stack = Stack<String>()
        readln().map { it.toString() }.forEach {
            when (it) {
                "(", "[" -> stack.push(it)

                ")" -> {
                    if (stack.peek() == "(") {
                        stack.pop()
                        stack.push("2")
                        return@forEach
                    }

                    var sum = 0
                    while (stack.peek() != "(") sum += stack.pop().toInt()
                    stack.pop()
                    stack.push((sum * 2).toString())
                }

                else -> {
                    if (stack.peek() == "[") {
                        stack.pop()
                        stack.push("3")
                        return@forEach
                    }

                    var sum = 0
                    while (stack.peek() != "[") sum += stack.pop().toInt()
                    stack.pop()
                    stack.push((sum * 3).toString())
                }
            }
        }

        stack.sumOf { it.toInt() }
    } catch (ignored: Exception) {
        0
    }

    print(result)
}
