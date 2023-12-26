package boj_1343

fun main() {
    val board = readln()

    val result = buildString {
        var xTimes = 0
        board.forEach { c ->
            if (c == 'X') {
                ++xTimes
                return@forEach
            }

            val aTimes = xTimes shr 2
            xTimes -= aTimes shl 2
            val bTimes = xTimes shr 1
            xTimes -= bTimes shl 1
            if (0 < xTimes) return println(-1)

            repeat(aTimes) { append("AAAA") }
            repeat(bTimes) { append("BB") }
            append(".")
        }

        if (0 < xTimes) {
            val aTimes = xTimes shr 2
            xTimes -= aTimes shl 2
            val bTimes = xTimes shr 1
            xTimes -= bTimes shl 1
            if (0 < xTimes) return println(-1)

            repeat(aTimes) { append("AAAA") }
            repeat(bTimes) { append("BB") }
        }
    }

    println(result)
}
