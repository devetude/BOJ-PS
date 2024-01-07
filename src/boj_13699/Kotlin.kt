package boj_13699

fun main() {
    val n = readln().toInt()

    val t = LongArray(size = n + 1)
    t[0] = 1
    for (i in 1..n) {
        for (j in 0..<i) {
            t[i] += t[j] * t[i - j - 1]
        }
    }

    print(t[n])
}
