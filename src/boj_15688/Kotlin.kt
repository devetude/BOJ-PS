package boj_15688

fun main() {
    val n = readln().toInt()
    val arr = IntArray(n) { readln().toInt() }
    arr.sort()

    System.out.bufferedWriter().use {
        it.write(arr.joinToString(separator = "\n"))
        it.flush()
    }
}
