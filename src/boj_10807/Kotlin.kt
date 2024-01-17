package boj_10807

import java.util.StringTokenizer

fun main() {
    val n = readln().toInt()
    val st = StringTokenizer(readln())
    val nums = ByteArray(n) { st.nextToken().toByte() }
    val v = readln().toByte()

    print(nums.count { it == v })
}
