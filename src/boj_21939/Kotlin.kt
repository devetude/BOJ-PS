package boj_21939

import java.util.StringTokenizer
import java.util.TreeMap
import java.util.TreeSet

fun main() {
    val map = TreeMap<Int, TreeSet<Int>>()
    repeat(readln().toInt()) {
        val st = StringTokenizer(readln())
        val p = st.nextToken().toInt()
        val l = st.nextToken().toInt()
        map[l] = map.getOrDefault(l, TreeSet<Int>()).also { it.add(p) }
    }

    val sb = StringBuilder()
    repeat(readln().toInt()) {
        val st = StringTokenizer(readln())
        when (st.nextToken()) {
            "recommend" -> {
                if (map.isEmpty()) return@repeat

                val p = if (st.nextToken() == "-1") {
                    map[map.firstKey()]?.first()
                } else {
                    map[map.lastKey()]?.last()
                }
                sb.appendLine(p)
            }

            "add" -> {
                val p = st.nextToken().toInt()
                val l = st.nextToken().toInt()
                map[l] = map.getOrDefault(l, TreeSet<Int>()).also { it.add(p) }
            }

            else -> {
                val p = st.nextToken().toInt()
                for ((l, problems) in map) {
                    if (!problems.remove(p)) continue

                    if (map.getOrDefault(l, emptySet()).isEmpty()) map.remove(l)
                    break
                }
            }
        }
    }

    System.out.bufferedWriter().use {
        it.write(sb.toString())
        it.flush()
    }
}
