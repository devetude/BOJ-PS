package boj_18111

import java.util.StringTokenizer

fun main() {
    var st = StringTokenizer(readln())
    val n = st.nextToken().toInt()
    val m = st.nextToken().toInt()
    val b = st.nextToken().toInt()

    var lowerHeight = Int.MAX_VALUE
    var upperHeight = Int.MIN_VALUE
    val heights = Array(n) {
        st = StringTokenizer(readln())
        IntArray(m) {
            st.nextToken().toInt().also {
                when {
                    upperHeight < it -> upperHeight = it
                    it < lowerHeight -> lowerHeight = it
                    else -> Unit
                }
            }
        }
    }

    var currentHeight = upperHeight
    var minTime = Int.MAX_VALUE
    var maxHeight = 0
    while (lowerHeight <= currentHeight) {
        var block = b
        var time = 0

        heights.forEach {
            it.forEach { height ->
                time += if (height < currentHeight) {
                    val diff = currentHeight - height
                    block -= diff
                    diff
                } else {
                    val diff = height - currentHeight
                    block += diff
                    diff shl 1
                }
            }
        }

        if (0 <= block && time < minTime) {
            minTime = time
            maxHeight = currentHeight
        }

        --currentHeight
    }

    print("$minTime $maxHeight")
}
