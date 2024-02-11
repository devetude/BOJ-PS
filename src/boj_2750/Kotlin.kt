package boj_2750

fun main() {
    val result = ShortArray(readln().toInt()) { readln().toShort() }
        .apply { sort() }
        .joinToString(separator = "\n")

    System.out.bufferedWriter().use {
        it.write(result)
        it.flush()
    }
}
