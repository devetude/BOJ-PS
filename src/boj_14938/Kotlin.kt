package boj_14938

import java.util.StringTokenizer

private const val INF: Int = Int.MAX_VALUE shr 1

fun main() {
    var st = StringTokenizer(readln())
    val n = st.nextToken().toInt()
    val m = st.nextToken().toInt()
    val r = st.nextToken().toInt()

    st = StringTokenizer(readln())
    val t = IntArray(size = n + 1)
    for (a in 1..n) t[a] = st.nextToken().toInt()

    val lengthBetween = Array(size = n + 1) { IntArray(size = n + 1) { INF } }
    repeat(r) {
        st = StringTokenizer(readln())
        val a = st.nextToken().toInt()
        val b = st.nextToken().toInt()
        val l = st.nextToken().toInt()
        lengthBetween[a][b] = l
        lengthBetween[b][a] = l
    }
    for (a in 1..n) lengthBetween[a][a] = 0

    for (via in 1..n) {
        for (a in 1..n) {
            for (b in 1..n) {
                lengthBetween[a][b] = minOf(
                    lengthBetween[a][b],
                    b = lengthBetween[a][via] + lengthBetween[via][b]
                )
            }
        }
    }

    var maxSize = 0
    for (a in 1..n) {
        var size = 0
        for (b in 1..n) {
            if (lengthBetween[a][b] <= m) size += t[b]
        }
        maxSize = maxOf(maxSize, size)
    }

    print(maxSize)
}
