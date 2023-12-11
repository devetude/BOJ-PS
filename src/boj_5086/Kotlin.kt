package boj_5086

import java.util.StringTokenizer

fun main() {
    val results = buildString {
        while (true) {
            val st = StringTokenizer(readln())
            val first = st.nextToken().toInt()
            val second = st.nextToken().toInt()

            val result = when {
                first == 0 && second == 0 -> break
                second % first == 0 -> "factor"
                first % second == 0 -> "multiple"
                else -> "neither"
            }
            appendLine(result)
        }
    }

    System.out.bufferedWriter().use {
        it.write(results)
        it.flush()
    }
}
