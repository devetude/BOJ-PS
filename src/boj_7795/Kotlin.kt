package boj_7795

import java.util.StringTokenizer

fun main() {
    val result = buildString {
        repeat(readln().toInt()) {
            var st = StringTokenizer(readln())
            val n = st.nextToken().toInt()
            val m = st.nextToken().toInt()

            st = StringTokenizer(readln())
            val a = IntArray(n) { st.nextToken().toInt() }

            st = StringTokenizer(readln())
            val b = IntArray(m) { st.nextToken().toInt() }
            b.sort()

            var totalCount = 0
            for (value in a) {
                var low = 0
                var high = m - 1
                var count = 0
                while (low <= high) {
                    val mid = low + high shr 1
                    if (b[mid] < value) {
                        low = mid + 1
                        count = low
                    } else {
                        high = mid - 1
                    }
                }
                totalCount += count
            }

            appendLine(totalCount)
        }
    }

    System.out.bufferedWriter().use {
        it.write(result)
        it.flush()
    }
}
