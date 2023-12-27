package boj_1969

import java.util.StringTokenizer

fun main() {
    val st = StringTokenizer(readln())
    val n = st.nextToken().toInt()
    val m = st.nextToken().toInt()
    val dnas = Array(n) { "" }
    val frequencies = Array(m) { IntArray(size = 4) }
    repeat(n) { row ->
        val dna = readln()
        dnas[row] = dna
        repeat(m) { col ->
            when (dna[col]) {
                'A' -> ++frequencies[col][0]
                'C' -> ++frequencies[col][1]
                'G' -> ++frequencies[col][2]
                else -> ++frequencies[col][3]
            }
        }
    }

    val result = buildString {
        var hammingDistance = 0
        repeat(m) { col ->
            var maxFrequency = 0
            var maxFrequencyIdx = 0
            var frequencySum = 0
            frequencies[col].forEachIndexed { idx, frequency ->
                if (maxFrequency < frequency) {
                    maxFrequency = frequency
                    maxFrequencyIdx = idx
                }

                frequencySum += frequency
            }
            hammingDistance += frequencySum - maxFrequency

            val nucleotide = when (maxFrequencyIdx) {
                0 -> 'A'
                1 -> 'C'
                2 -> 'G'
                else -> 'T'
            }
            append(nucleotide)
        }
        appendLine()
        append(hammingDistance)
    }

    System.out.bufferedWriter().use {
        it.write(result)
        it.flush()
    }
}
