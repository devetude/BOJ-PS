package boj_10162

val TIME_SECS = arrayOf(300, 60, 10)

fun main() {
    var t = readln().toInt()

    val result = buildString {
        TIME_SECS.forEach { timeSec ->
            val timeSecCount = t / timeSec
            t -= timeSec * timeSecCount
            append(timeSecCount, " ")
        }

        if (0 < t) {
            clear()
            append(-1)
        }
    }

    println(result)
}
