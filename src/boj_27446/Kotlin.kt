package boj_27446

import java.util.StringTokenizer
import kotlin.math.min

fun main() {
    var st = StringTokenizer(readln())
    val n = st.nextToken().toInt()
    val m = st.nextToken().toInt()

    st = StringTokenizer(readln())
    val pageExists = BooleanArray(size = n + 1)
    repeat(m) { pageExists[st.nextToken().toInt()] = true }

    var lastPrintedNum = 0
    var minRequiredInk = 0
    for (num in 1..n) {
        if (pageExists[num]) continue

        minRequiredInk += if (0 < lastPrintedNum) min(a = num - lastPrintedNum shl 1, b = 7) else 7
        lastPrintedNum = num
    }

    print(minRequiredInk)
}
