package boj_11652

import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val n = br.readLine().toInt()
    val arr = LongArray(n) { br.readLine().toLong() }.apply { sort() }

    var num = arr[0]
    var maxCountNum = num
    var count = 1
    var maxCount = count
    for (i in 1 until n) {
        if (num == arr[i]) {
            ++count
            if (maxCount < count) {
                maxCount = count
                maxCountNum = num
            }
            continue
        }

        num = arr[i]
        count = 1
    }

    print(maxCountNum)
}
