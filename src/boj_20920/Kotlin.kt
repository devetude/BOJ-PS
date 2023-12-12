package boj_20920

import java.util.StringTokenizer

fun main() {
    val st = StringTokenizer(readln())
    val n = st.nextToken().toInt()
    val m = st.nextToken().toInt()

    val words = HashMap<String, Int>()
    repeat(n) {
        val word = readln()
        if (word.length < m) return@repeat

        val count = words.getOrDefault(word, defaultValue = 0)
        words[word] = count + 1
    }

    val result = words
        .toSortedMap(
            compareByDescending<String> { words[it] }
                .thenByDescending { it.length }
                .thenBy { it }
        )
        .keys
        .joinToString(separator = "\n")

    System.out.bufferedWriter().use {
        it.write(result)
        it.flush()
    }
}
