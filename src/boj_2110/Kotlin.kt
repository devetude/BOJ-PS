package boj_2110

import java.util.StringTokenizer

fun main() {
    val st = StringTokenizer(readln())
    val n = st.nextToken().toInt()
    val c = st.nextToken().toInt()
    val points = IntArray(n)
    repeat(n) { points[it] = readln().toInt() }

    points.sort()

    var minDistance = 1
    var maxDistance = points[n - 1] - points[0] + 1
    while (minDistance < maxDistance) {
        val midDistance = (minDistance + maxDistance) shr 1
        if (isAbleToInstall(points, midDistance, c)) {
            minDistance = midDistance + 1
        } else {
            maxDistance = midDistance
        }
    }

    println(minDistance - 1)
}

fun isAbleToInstall(points: IntArray, distance: Int, totalCount: Int): Boolean {
    var count = 1
    var lastPoint = points[0]
    var nextMinPoint = lastPoint + distance
    for (i in 1 until points.size) {
        val point = points[i]
        if (point < nextMinPoint) continue

        lastPoint = point
        nextMinPoint = lastPoint + distance
        if (totalCount == ++count) return true
    }

    return false
}
