package boj_20364

import java.util.StringTokenizer

fun main() {
    val st = StringTokenizer(readln())
    val n = st.nextToken().toInt()
    val q = st.nextToken().toInt()

    val isOccupied = BooleanArray(size = n + 1)
    val sb = StringBuilder()
    repeat(q) {
        val x = readln().toInt()

        var parent = x
        var minOccupiedParent = 0
        while (0 < parent) {
            parent = parent shr 1
            if (isOccupied[parent]) minOccupiedParent = parent
        }

        if (minOccupiedParent == 0) {
            if (!isOccupied[x]) {
                isOccupied[x] = true
            } else {
                minOccupiedParent = x
            }
        }

        sb.appendLine(minOccupiedParent)
    }

    System.out.bufferedWriter().use {
        it.write(sb.toString())
        it.flush()
    }
}
