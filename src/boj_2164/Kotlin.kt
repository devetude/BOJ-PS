package boj_2164

fun main() {
    val n = readln().toInt()

    val queue = ArrayDeque<Int>(initialCapacity = n + 1)
        .apply {
            repeat(n) { addLast(element = it + 1) }
            while (1 < size) {
                removeFirst()
                addLast(removeFirst())
            }
        }

    println(queue.first())
}
