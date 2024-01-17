package boj_1267

import java.util.StringTokenizer

fun main() {
    val n = readln().toInt()

    val st = StringTokenizer(readln())
    var yCost = 0
    var mCost = 0
    repeat(n) {
        val sec = st.nextToken().toInt()
        yCost += sec / 30 * 10 + 10
        mCost += sec / 60 * 15 + 15
    }
    val result = when {
        yCost < mCost -> "Y $yCost"
        mCost < yCost -> "M $mCost"
        else -> "Y M $yCost"
    }

    print(result)
}
