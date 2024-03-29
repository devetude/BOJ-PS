package boj_10808

fun main() {
    val frequencyOf = IntArray(size = 26)
    readln().forEach { ++frequencyOf[it - 'a'] }

    System.out.bufferedWriter().use {
        it.write(frequencyOf.joinToString(separator = " "))
        it.flush()
    }
}
