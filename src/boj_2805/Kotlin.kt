package boj_2805

import java.util.StringTokenizer
import kotlin.math.max

fun main() {
    var st = StringTokenizer(readln())
    val n = st.nextToken().toInt()
    val m = st.nextToken().toInt()

    st = StringTokenizer(readln())
    var maxHeight = 1L
    val heights = LongArray(n) { st.nextToken().toLong().also { maxHeight = max(maxHeight, it) } }

    var low = 1L
    var high = maxHeight
    var result = 0L
    while (low <= high) {
        val mid = low + high shr 1
        val size = heights.sumOf { (it - mid).coerceAtLeast(minimumValue = 0L) }
        if (size < m) {
            high = mid - 1L
        } else {
            result = mid
            low = mid + 1L
        }
    }

    print(result)
}
