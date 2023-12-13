package boj_27433

fun main() {
    val n = readln().toLong()

    println(factorial(n))
}

fun factorial(n: Long): Long {
    if (n <= 1) return 1

    return n * factorial(n = n - 1)
}
