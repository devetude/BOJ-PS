package boj_2293

import java.util.StringTokenizer

fun main() {
    val st = StringTokenizer(readln())
    val n = st.nextToken().toInt()
    val k = st.nextToken().toInt()

    val coins = IntArray(n)
    repeat(n) { coins[it] = readln().toInt() }

    val memory = IntArray(size = k + 1)
    memory[0] = 1
    for (i in 0 until n) {
        for (j in coins[i]..k) {
            memory[j] += memory[j - coins[i]]
        }
    }

    print(memory[k])
}
