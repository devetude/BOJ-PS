package boj_16934

fun main() {
    val nodeOf = Array(size = 1_000_001) { IntArray(size = 26) { -1 } }
    val isTerminal = BooleanArray(size = 1_000_001)
    var last = 0
    val frequencyOf = hashMapOf<String, Int>()
    val resultBuilder = StringBuilder()
    repeat(readln().toInt()) {
        val nickname = readln()

        var parent = 0
        val aliasBuilder = StringBuilder()
        var isAliasBuilt = false
        nickname.forEach { c ->
            if (!isAliasBuilt) aliasBuilder.append(c)

            val i = c - 'a'
            if (nodeOf[parent][i] == -1) {
                isAliasBuilt = true
                nodeOf[parent][i] = ++last
            }

            parent = nodeOf[parent][i]
        }
        isTerminal[parent] = true

        frequencyOf[nickname] = frequencyOf.getOrDefault(nickname, defaultValue = 0) + 1
        val frequency = frequencyOf.getOrDefault(nickname, defaultValue = 0)
        if (1 < frequency) {
            resultBuilder.append(nickname).appendLine(frequency)
        } else {
            resultBuilder.appendLine(aliasBuilder)
        }
    }

    System.out.bufferedWriter().use {
        it.write(resultBuilder.toString())
        it.flush()
    }
}
