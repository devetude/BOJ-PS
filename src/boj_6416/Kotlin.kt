package boj_6416

fun main() {
    var edgeSize = 0
    val indegree = hashMapOf<Int, Int>()
    var k = 1
    val sb = StringBuilder()
    while (true) {
        val line = readln()
        if (line == "-1 -1") break
        if (line.isEmpty()) {
            edgeSize = 0
            indegree.clear()
            ++k
            continue
        }

        val nodes = line.split("  ")
            .map { node -> node.split(" ").map { it.toInt() } }
        nodes.forEach { (u, v) ->
            if (u == 0 && v == 0) return@forEach

            ++edgeSize
            indegree[u] = indegree.getOrDefault(u, defaultValue = 0)
            indegree[v] = indegree.getOrDefault(v, defaultValue = 0) + 1
        }
        if (nodes.last() != listOf(0, 0)) continue

        if (indegree.isEmpty()) {
            sb.appendLine(value = "Case $k is a tree.")
            continue
        }

        if (indegree.count { it.value == 0 } != 1 ||
            indegree.any { 1 < it.value } ||
            indegree.keys.size - 1 != edgeSize
        ) {
            sb.appendLine(value = "Case $k is not a tree.")
            continue
        }

        sb.appendLine(value = "Case $k is a tree.")
    }

    System.out.bufferedWriter().use {
        it.write(sb.toString())
        it.flush()
    }
}
