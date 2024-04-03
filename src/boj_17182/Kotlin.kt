package boj_17182

import java.util.StringTokenizer

private var n: Int = 0
private lateinit var minTimeBetween: Array<IntArray>
private lateinit var isVisited: BooleanArray

private var minTotalTime: Int = Int.MAX_VALUE

fun main() {
    var st = StringTokenizer(readln())
    n = st.nextToken().toInt()
    val k = st.nextToken().toInt()

    minTimeBetween = Array(n) {
        st = StringTokenizer(readln())
        IntArray(n) { st.nextToken().toInt() }
    }

    for (via in 0 until n) {
        for (i in 0 until n) {
            for (j in 0 until n) {
                minTimeBetween[i][j] = minOf(
                    minTimeBetween[i][j],
                    b = minTimeBetween[i][via] + minTimeBetween[via][j]
                )
            }
        }
    }

    isVisited = BooleanArray(n).apply { this[k] = true }
    visit(k)

    print(minTotalTime)
}

private fun visit(i: Int, totalTime: Int = 0, count: Int = 1) {
    if (count == n) {
        minTotalTime = minOf(minTotalTime, totalTime)
        return
    }

    minTimeBetween[i].forEachIndexed { j, minTime ->
        if (isVisited[j]) return@forEachIndexed

        isVisited[j] = true
        visit(j, totalTime = totalTime + minTime, count = count + 1)
        isVisited[j] = false
    }
}
