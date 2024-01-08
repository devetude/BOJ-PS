package boj_25418

import java.util.StringTokenizer
import kotlin.math.min

fun main() {
    val st = StringTokenizer(readln())
    val a = st.nextToken().toInt()
    val k = st.nextToken().toInt()

    val minOpTimes = IntArray(size = k + 1)
    for (i in a + 1..k) {
        minOpTimes[i] = minOpTimes[i - 1] + 1
        if (i and 1 == 0 && a shl 1 <= i) {
            minOpTimes[i] = min(minOpTimes[i], b = minOpTimes[i shr 1] + 1)
        }
    }

    print(minOpTimes[k])
}
