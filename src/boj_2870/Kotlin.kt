package boj_2870

import java.math.BigInteger
import java.util.LinkedList

fun main() {
    val nums = LinkedList<BigInteger>()
    repeat(readln().toInt()) {
        val sb = StringBuilder()
        readln().forEach {
            if (it in '0'..'9') {
                sb.append(it)
                return@forEach
            }
            if (sb.isEmpty()) return@forEach

            nums.add(BigInteger(sb.toString()))
            sb.clear()
        }
        if (sb.isNotEmpty()) nums.add(BigInteger(sb.toString()))
    }
    nums.sort()

    System.out.bufferedWriter().use {
        it.write(nums.joinToString(separator = "\n"))
        it.flush()
    }
}
