package boj_2668

fun main() {
    val n = readln().toInt()
    val nexts = MutableList(size = n + 1) { 0 }
    repeat(n) {
        nexts[it + 1] = readln().toInt()
    }

    val elements = mutableSetOf<Int>()
    for (start in 1..n) {
        if (start in elements) continue

        val visits = mutableSetOf<Int>()
        visits.add(start)

        var next = nexts[start]
        while (next !in visits) {
            visits.add(next)
            next = nexts[next]
        }

        if (start == next) elements.addAll(visits)
    }
    val result = buildString {
        appendLine(elements.size)
        elements.sorted().forEach { appendLine(it) }
    }

    System.out.bufferedWriter().use {
        it.write(result)
        it.flush()
    }
}
