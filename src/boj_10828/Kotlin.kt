package boj_10828

import java.util.Stack

fun main() {
    val n = readln().toInt()

    System.out.bufferedWriter().use { bw ->
        val stack = Stack<String>()

        repeat(n) {
            val args = readln().split(" ")
            when (args.first()) {
                "push" -> stack.push(args[1])

                "pop" -> {
                    bw.write(if (stack.isNotEmpty()) stack.pop() else "-1")
                    bw.write("\n")
                }

                "size" -> {
                    bw.write(stack.size.toString())
                    bw.write("\n")
                }

                "empty" -> {
                    bw.write(if (stack.isEmpty()) "1" else "0")
                    bw.write("\n")
                }

                else -> {
                    bw.write(if (stack.isNotEmpty()) stack.peek() else "-1")
                    bw.write("\n")
                }
            }
        }

        bw.flush()
    }
}
