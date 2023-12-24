package boj_10162

val SECS = arrayOf(300, 60, 10)

fun main() {
    var t = readln().toInt()

    val result = buildString {
        SECS.forEach {
            val count = t / it
            t -= it * count
            append(count, " ")
        }
    }

    if (0 < t) return println(-1)

    println(result)
}
