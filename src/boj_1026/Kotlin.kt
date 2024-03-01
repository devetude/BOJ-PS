package boj_1026

import java.util.StringTokenizer

fun main() {
    val n = readln().toInt()

    val stA = StringTokenizer(readln())
    val stB = StringTokenizer(readln())
    val aArr = IntArray(n)
    val bArr = IntArray(n)
    repeat(n) {
        aArr[it] = stA.nextToken().toInt()
        bArr[it] = stB.nextToken().toInt()
    }

    aArr.apply { sort() }
        .also { bArr.sortDescending() }
        .foldIndexed(initial = 0) { i, acc, a -> acc + a * bArr[i] }
        .run(::print)
}
