package boj_2309

fun main() {
    val heights = IntArray(size = 9)
    var heightSum = 0
    repeat(times = 9) {
        heights[it] = readln().toInt()
        heightSum += heights[it]
    }
    heights.sort()

    val overflowHeight = heightSum - 100
    val overflowHeightDiffs = IntArray(size = 201)
    heights.forEach { overflowHeightDiffs[it] = overflowHeight - it }

    val liarHeights = IntArray(size = 2)
    for (firstHeight in heights) {
        val secondHeight = overflowHeightDiffs[firstHeight]
        if (secondHeight < 0 || overflowHeightDiffs[secondHeight] != firstHeight) continue

        liarHeights[0] = firstHeight
        liarHeights[1] = secondHeight
        break
    }

    System.out.bufferedWriter().use { bw ->
        heights.forEach {
            val liarHeightIdx = liarHeights.indexOf(it)
            if (-1 < liarHeightIdx) {
                liarHeights[liarHeightIdx] = 0
                return@forEach
            }

            bw.write(it.toString())
            bw.write("\n")
        }
        bw.flush()
    }
}
