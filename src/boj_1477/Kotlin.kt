package boj_1477

import java.util.StringTokenizer

fun main() {
    var st = StringTokenizer(readln())
    val n = st.nextToken().toInt()
    val m = st.nextToken().toInt()
    val l = st.nextToken().toInt()

    st = StringTokenizer(readln())
    val x = IntArray(size = n + 2)
    x[0] = 0
    repeat(n) { x[it + 1] = st.nextToken().toInt() }
    x[n + 1] = l
    x.sort()

    var low = 1
    var high = l - 1
    while (low < high) {
        val mid = low + high shr 1
        var count = 0
        for (i in 1 until x.size) count += (x[i] - x[i - 1] - 1) / mid
        if (m < count) low = mid + 1 else high = mid
    }

    print(high)
}
