package boj_16401

import java.util.StringTokenizer
import kotlin.math.max

fun main() {
    var st = StringTokenizer(readln())
    val m = st.nextToken().toInt()
    val n = st.nextToken().toInt()

    st = StringTokenizer(readln())
    var maxLength = 1
    val lengths = IntArray(n) { st.nextToken().toInt().also { maxLength = max(maxLength, it) } }

    var low = 1
    var high = maxLength
    var result = 0
    while (low <= high) {
        val mid = low + high shr 1
        if (mid == 0) break

        val size = lengths.sumOf { it / mid }
        if (size < m) {
            high = mid - 1
        } else {
            result = mid
            low = mid + 1
        }
    }

    print(result)
}
