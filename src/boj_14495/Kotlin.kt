package boj_14495

fun main() {
    val n = readln().toInt()

    val f = LongArray(size = 117) { 1L }
    for (i in 4..n) f[i] = f[i - 1] + f[i - 3]

    print(f[n])
}
