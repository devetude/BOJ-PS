package boj_11060

import java.util.LinkedList
import java.util.StringTokenizer

fun main() {
    val n = readln().toInt()
    val st = StringTokenizer(readln())
    val a = IntArray(size = n + 1)
    repeat(n) { a[it + 1] = st.nextToken().toInt() }

    if (n == 1) return print(0)

    val nextXs = LinkedList<Int>()
    nextXs.offer(1)
    val minJumpCounts = IntArray(size = n + 1) { Int.MAX_VALUE }
    minJumpCounts[1] = 0

    while (nextXs.isNotEmpty()) {
        val currentX = nextXs.poll()
        if (currentX == n) return print(minJumpCounts[n])

        val nextJumpCount = minJumpCounts[currentX] + 1
        for (jump in 1..a[currentX]) {
            val nextX = currentX + jump
            if (n < nextX) break
            if (minJumpCounts[nextX] <= nextJumpCount) continue

            minJumpCounts[nextX] = nextJumpCount
            nextXs.offer(nextX)
        }
    }

    print(-1)
}
