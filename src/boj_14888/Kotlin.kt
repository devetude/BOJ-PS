package boj_14888

import java.util.StringTokenizer
import kotlin.math.max
import kotlin.math.min

var maxValue = Int.MIN_VALUE
var minValue = Int.MAX_VALUE

fun main() {
    val n = readln().toInt()
    var st = StringTokenizer(readln())
    val numbers = IntArray(n)
    repeat(n) { numbers[it] = st.nextToken().toInt() }
    st = StringTokenizer(readln())
    val opCounts = IntArray(size = 4)
    repeat(opCounts.size) { opCounts[it] = st.nextToken().toInt() }

    val opSequences = IntArray(size = n - 1)
    dfs(numbers, opSequences, opCounts)

    val result = buildString {
        appendLine(maxValue)
        append(minValue)
    }

    println(result)
}

fun dfs(numbers: IntArray, opTypes: IntArray, opCounts: IntArray, opSeq: Int = 0) {
    if (opSeq == opTypes.size) {
        var result = numbers.first()
        for (i in 1..numbers.lastIndex) {
            val number = numbers[i]
            result = when (opTypes[i - 1]) {
                0 -> result + number
                1 -> result - number
                2 -> result * number
                else -> result / number
            }
        }

        maxValue = max(maxValue, result)
        minValue = min(minValue, result)

        return
    }

    opCounts.forEachIndexed { opType, opCount ->
        if (0 < opCount) {
            opTypes[opSeq] = opType
            --opCounts[opType]
            dfs(numbers, opTypes, opCounts, opSeq = opSeq + 1)
            ++opCounts[opType]
        }
    }
}
