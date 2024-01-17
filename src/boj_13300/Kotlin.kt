package boj_13300

import java.util.StringTokenizer

fun main() {
    var st = StringTokenizer(readln())
    val n = st.nextToken().toInt()
    val k = st.nextToken().toInt()

    val counts = Array(size = 7) { IntArray(size = 2) }
    repeat(n) {
        st = StringTokenizer(readln())
        val s = st.nextToken().toInt()
        val y = st.nextToken().toInt()
        ++counts[y][s]
    }
    val requiredMinRoomCount = counts.sumOf { countsByGrade ->
        countsByGrade.sumOf { countOfSex ->
            countOfSex / k + if (countOfSex % k == 0) 0 else 1
        }
    }

    print(requiredMinRoomCount)
}
