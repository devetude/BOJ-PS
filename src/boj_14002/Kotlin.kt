package boj_14002

import java.util.LinkedList
import java.util.StringTokenizer

fun main() {
    val n = readln().toInt()

    val st = StringTokenizer(readln())
    val nums = IntArray(n)
    val maxSizes = IntArray(n)
    var maxSize = 0
    var maxSizeIdx = 0
    val parentIdx = IntArray(n) { -1 }
    repeat(n) {
        nums[it] = st.nextToken().toInt()
        maxSizes[it] = 1

        for (i in 0..<it) {
            if (nums[i] < nums[it]) {
                if (maxSizes[it] < maxSizes[i] + 1) {
                    maxSizes[it] = maxSizes[i] + 1
                    parentIdx[it] = i
                }
            }
        }
        if (maxSize < maxSizes[it]) {
            maxSize = maxSizes[it]
            maxSizeIdx = it
        }
    }

    System.out.bufferedWriter().use {
        it.write(maxSize.toString())
        it.write("\n")

        val lis = LinkedList<Int>()
        var i = maxSizeIdx
        while (-1 < i) {
            lis.addFirst(nums[i])
            i = parentIdx[i]
        }
        it.write(lis.joinToString(separator = " "))

        it.flush()
    }
}
