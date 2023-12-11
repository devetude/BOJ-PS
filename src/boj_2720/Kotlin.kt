package boj_2720

fun main() {
    val changes = intArrayOf(25, 10, 5, 1)

    val result = buildString {
        repeat(readln().toInt()) {
            var money = readln().toInt()

            changes.forEach { change ->
                var count = 0
                while (change <= money) {
                    money -= change
                    ++count
                }
                append(count, " ")
            }
            appendLine()
        }
    }

    System.out.bufferedWriter().use {
        it.write(result)
        it.flush()
    }
}
