package boj_14607

fun main() {
    val n = readln().toLong()

    print(n * (n - 1) shr 1)
}
