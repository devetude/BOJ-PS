package boj_17202

fun main() {
    val a = readln()
    val b = readln()

    val mergedLength = a.length shl 1
    val results = Array(mergedLength) { start ->
        IntArray(mergedLength) { end ->
            if (start == end) {
                val inputIdx = start shr 1
                (if (start and 1 == 0) a[inputIdx] else b[inputIdx]) - '0'
            } else {
                0
            }
        }
    }

    for (window in 1 until mergedLength) {
        for (start in 0 until mergedLength - window) {
            val end = start + window
            results[start][end] = (results[start][end - 1] + results[start + 1][end]) % 10
        }
    }

    val result = buildString {
        append(results[0][results.lastIndex - 1])
        append(results[1][results.lastIndex])
    }

    print(result)
}
