package boj_2442

fun main() {
    val n = readln().toInt()

    System.out.bufferedWriter().use { bw ->
        var startSize = 1
        for (padding in n - 1 downTo 0) {
            val line = buildString {
                repeat(padding) { append(" ") }
                repeat(startSize) { append("*") }
                appendLine()
            }
            startSize += 2
            bw.write(line)
        }
        bw.flush()
    }
}
