package boj_2910

import java.util.StringTokenizer

fun main() {
    var st = StringTokenizer(readln())
    val n = st.nextToken().toInt()
    st.nextToken().toInt()

    st = StringTokenizer(readln())
    val valueToTimes = HashMap<Int, Int>()
    val valueToIdx = HashMap<Int, Int>()
    repeat(n) {
        val x = st.nextToken().toInt()
        valueToTimes[x] = valueToTimes.getOrDefault(x, defaultValue = 0) + 1
        valueToIdx.putIfAbsent(x, it)
    }
    val sortedValueToTimes = valueToTimes.map { it.key to it.value }
        .sortedWith(
            compareByDescending<Pair<Int, Int>> { it.second }
                .thenBy { requireNotNull(valueToIdx[it.first]) }
        )
    val result = buildString {
        sortedValueToTimes.forEach { (x, times) -> repeat(times) { append(x, ' ') } }
    }

    System.out.bufferedWriter().use {
        it.write(result)
        it.flush()
    }
}
