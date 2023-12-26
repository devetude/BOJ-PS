package boj_1049

import java.util.StringTokenizer
import kotlin.math.min

fun main() {
    var st = StringTokenizer(readln())
    val n = st.nextToken().toInt()
    val m = st.nextToken().toInt()

    var minPackagePrice = Int.MAX_VALUE
    var minEachPrice = Int.MAX_VALUE
    repeat(m) {
        st = StringTokenizer(readln())
        val packagePrice = st.nextToken().toInt()
        minPackagePrice = min(minPackagePrice, packagePrice)
        val eachPrice = st.nextToken().toInt()
        minEachPrice = min(minEachPrice, eachPrice)
    }

    val minCost = if (minEachPrice * 6 <= minPackagePrice) {
        n * minEachPrice
    } else {
        if (n % 6 == 0) {
            n / 6 * minPackagePrice
        } else {
            n / 6 * minPackagePrice + min(minPackagePrice, b = n % 6 * minEachPrice)
        }
    }

    println(minCost)
}
