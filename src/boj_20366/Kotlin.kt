package boj_20366

import java.util.StringTokenizer
import kotlin.math.abs
import kotlin.math.min

fun main() {
    val n = readln().toInt()

    val st = StringTokenizer(readln())
    val h = IntArray(n) { st.nextToken().toInt() }.apply { sort() }

    var minDiff = Int.MAX_VALUE
    for (outerLeft in 0..n - 4) {
        for (outerRight in n - 1 downTo outerLeft + 3) {
            val outerHeight = h[outerLeft] + h[outerRight]

            var innerLeft = outerLeft + 1
            var innerRight = outerRight - 1
            while (innerLeft < innerRight) {
                val innerHeight = h[innerLeft] + h[innerRight]

                val diff = innerHeight - outerHeight
                minDiff = min(minDiff, abs(diff))

                if (0 < diff) --innerRight else ++innerLeft
            }
        }
    }

    print(minDiff)
}
