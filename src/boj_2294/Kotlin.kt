package boj_2294

import java.util.StringTokenizer

fun main() {
    val st = StringTokenizer(readln())
    val n = st.nextToken().toInt()
    val k = st.nextToken().toInt()

    val coins = HashSet<Int>()
    val maxCounts = IntArray(size = k + 1)
    repeat(n) {
        val coin = readln().toInt()
        if (coin <= k) {
            maxCounts[coin] = 1
            coins.add(coin)
        }
    }

    for (sum in 1..k) {
        if (maxCounts[sum] == 1) continue

        maxCounts[sum] = coins.asSequence()
            .filter { it <= sum && maxCounts[sum - it] < 10_001 }
            .minOfOrNull { maxCounts[sum - it] + 1 }
            ?: 10_001
    }

    val result = if (maxCounts[k] == 10_001) -1 else maxCounts[k]
    print(result)
}
