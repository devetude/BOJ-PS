package boj_24416

fun main() {
    val n = readln().toInt()

    val fibonacci = IntArray(size = n + 1)
    fibonacci[1] = 1
    fibonacci[2] = 1
    for (i in 3..n) {
        fibonacci[i] = fibonacci[i - 2] + fibonacci[i - 1]
    }
    val result = buildString { append(fibonacci[n], " ", n - 2) }

    println(result)
}
