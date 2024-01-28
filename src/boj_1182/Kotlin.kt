package boj_1182

import java.util.StringTokenizer

var s: Int = 0
lateinit var nums: IntArray

var subArrCount: Int = 0

fun main() {
    var st = StringTokenizer(readln())
    val n = st.nextToken().toInt()
    s = st.nextToken().toInt()

    st = StringTokenizer(readln())
    nums = IntArray(n) { st.nextToken().toInt() }

    for (i in nums.indices) buildSubArr(i, nums[i])

    print(subArrCount)
}

fun buildSubArr(i: Int, sum: Int) {
    if (sum == s) ++subArrCount

    for (j in i + 1 until nums.size) buildSubArr(j, sum = sum + nums[j])
}
