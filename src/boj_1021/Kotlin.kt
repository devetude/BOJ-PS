package boj_1021

import java.util.LinkedList
import java.util.StringTokenizer

fun main() {
    var st = StringTokenizer(readln())

    val deque = LinkedList<Int>()
    repeat(st.nextToken().toInt()) { deque.offer(it + 1) }

    st = StringTokenizer(readln())
    var shift = 0
    while (st.hasMoreTokens()) {
        val leftShift = deque.indexOf(st.nextToken().toInt())
        val rightShift = deque.size - leftShift
        shift += if (leftShift < rightShift) {
            repeat(leftShift) { deque.offer(deque.poll()) }
            leftShift
        } else {
            repeat(rightShift) { deque.offerFirst(deque.pollLast()) }
            rightShift
        }
        deque.poll()
    }

    print(shift)
}
