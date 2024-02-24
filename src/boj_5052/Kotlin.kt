package boj_5052

fun main() {
    val sb = StringBuilder()
    repeat(readln().toInt()) {
        val phoneNumbers = Array(readln().toInt()) { readln() }.apply { sort() }

        val nodeOf = Array(size = 100_001) { IntArray(size = 10) { -1 } }
        val isTerminal = BooleanArray(size = 100_001)
        var last = 0
        for (phoneNumber in phoneNumbers) {
            var parent = 0
            for (c in phoneNumber) {
                if (isTerminal[parent]) {
                    sb.appendLine(value = "NO")
                    return@repeat
                }

                val i = c - '0'
                if (nodeOf[parent][i] == -1) nodeOf[parent][i] = ++last
                parent = nodeOf[parent][i]
            }
            isTerminal[parent] = true
        }
        sb.appendLine(value = "YES")
    }

    System.out.bufferedWriter().use {
        it.write(sb.toString())
        it.flush()
    }
}
