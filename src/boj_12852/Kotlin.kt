package boj_12852

fun main() {
    val n = readln().toInt()

    val minDepths = IntArray(size = n + 1) { Int.MAX_VALUE }
    minDepths[1] = 0
    val before = IntArray(size = n + 1)

    for (i in 2..n) {
        if (i % 3 == 0) {
            val next = i / 3
            val nextDepth = minDepths[next] + 1
            if (nextDepth < minDepths[i]) {
                minDepths[i] = nextDepth
                before[i] = next
            }
        }
        if (i % 2 == 0) {
            val next = i / 2
            val nextDepth = minDepths[next] + 1
            if (nextDepth < minDepths[i]) {
                minDepths[i] = nextDepth
                before[i] = next
            }
        }
        val next = i - 1
        val nextDepth = minDepths[next] + 1
        if (nextDepth < minDepths[i]) {
            minDepths[i] = nextDepth
            before[i] = next
        }
    }
    val result = buildString {
        appendLine(minDepths[n])
        var i = n
        while (0 < i) {
            append(i, " ")
            i = before[i]
        }
    }

    System.out.bufferedWriter().use {
        it.write(result)
        it.flush()
    }
}
