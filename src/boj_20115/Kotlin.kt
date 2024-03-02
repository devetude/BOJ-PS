package boj_20115

import java.util.StringTokenizer

fun main() {
    val n = readln().toInt()
    val st = StringTokenizer(readln())
    val quantities = DoubleArray(n) { st.nextToken().toDouble() }.apply { sort() }

    var maxQuantity = quantities.last()
    for (i in 0..n - 2) maxQuantity += quantities[i] / 2.0

    print(maxQuantity)
}
