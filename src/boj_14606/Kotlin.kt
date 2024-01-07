package boj_14606

fun main() {
    val n = readln().toInt()

    val sums = IntArray(size = n + 1)
    for (a in 2..n) {
        val b = a shr 1
        val c = a - b
        sums[b + c] = b * c + sums[b] + sums[c]
    }

    print(sums[n])
}
