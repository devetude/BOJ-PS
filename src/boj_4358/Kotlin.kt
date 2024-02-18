package boj_4358

import java.util.TreeMap

fun main() {
    val map = TreeMap<String, Int>()
    var size = 0
    while (true) {
        val type = readlnOrNull() ?: break
        map[type] = map.getOrDefault(type, defaultValue = 0) + 1
        ++size
    }

    val sb = StringBuilder()
    map.forEach { (type, count) ->
        sb.append(type, ' ')
        sb.appendLine(String.format("%.4f", count * 100.0 / size))
    }

    System.out.bufferedWriter().use {
        it.write(sb.toString())
        it.flush()
    }
}
