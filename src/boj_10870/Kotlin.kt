package boj_10870

fun main() {
    val n = readln().toInt()

    println(fibonacci(n))
}

fun fibonacci(n: Int): Int {
    if (n <= 1) return n

    return fibonacci(n = n - 2) + fibonacci(n = n - 1)
}
