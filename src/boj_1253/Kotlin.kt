package boj_1253

import java.util.StringTokenizer

fun main() {
    val n = readln().toInt()

    val st = StringTokenizer(readln())
    val a = IntArray(n) { st.nextToken().toInt() }.apply { sort() }

    var size = 0
    for (i in a.indices) {
        var start = 0
        var end = a.lastIndex
        while (true) {
            when (i) {
                start -> ++start
                end -> --end
                else -> Unit
            }
            if (end <= start) break

            val twoSum = a[start] + a[end]
            when {
                twoSum < a[i] -> ++start
                a[i] < twoSum -> --end
                else -> {
                    ++size
                    break
                }
            }
        }
    }

    print(size)
}
