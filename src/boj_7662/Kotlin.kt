package boj_7662

import java.util.StringTokenizer
import java.util.TreeMap

fun main() {
    val sb = StringBuilder()

    repeat(readln().toInt()) {
        val map = TreeMap<Long, Int>(compareByDescending { it })

        repeat(readln().toInt()) {
            val st = StringTokenizer(readln())
            val command = st.nextToken()
            val num = st.nextToken().toLong()
            if (command == "I") {
                map[num] = map.getOrDefault(num, defaultValue = 0) + 1
            } else {
                if (map.isNotEmpty()) {
                    val key = if (num == 1L) map.firstKey() else map.lastKey()
                    val count = map.getOrDefault(key, defaultValue = 0)
                    if (1 < count) map[key] = count - 1 else map.remove(key)
                }
            }
        }

        if (map.isEmpty()) {
            sb.appendLine(value = "EMPTY")
        } else {
            sb.append(map.firstKey(), ' ')
            sb.appendLine(map.lastKey())
        }
    }

    System.out.bufferedWriter().use {
        it.write(sb.toString())
        it.flush()
    }
}
