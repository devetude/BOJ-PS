package boj_17175

fun main() {
    val n = readln().toInt()

    val times = IntArray(size = n + 1) { 1 }
    for (i in 2..n) {
        times[i] = (times[i - 2] + times[i - 1] + 1) % 1_000_000_007
    }

    print(times[n])
}
