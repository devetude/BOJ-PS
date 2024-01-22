package boj_11931

fun main() {
    val n = readln().toInt()
    val arr = IntArray(n) { readln().toInt() }
    arr.sortDescending()

    System.out.bufferedWriter().use {
        it.write(arr.joinToString(separator = "\n"))
        it.flush()
    }
}
