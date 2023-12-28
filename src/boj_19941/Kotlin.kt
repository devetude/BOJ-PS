package boj_19941

import java.util.StringTokenizer

fun main() {
    val st = StringTokenizer(readln())
    val n = st.nextToken().toInt()
    val k = st.nextToken().toInt()
    val str = readln()

    val isEaten = BooleanArray(n)
    var count = 0
    for (i in 0 until n) {
        val c = str[i]
        if (c == 'P') {
            for (j in i - k..i + k) {
                if (j < 0 || n <= j || isEaten[j] || str[j] == 'P') continue

                isEaten[j] = true
                ++count
                break
            }
        }
    }

    println(count)
}
