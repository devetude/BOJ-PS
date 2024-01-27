package boj_9328

import java.util.LinkedList
import java.util.StringTokenizer

val DIR: Array<Pair<Int, Int>> = arrayOf(1 to 0, -1 to 0, 0 to 1, 0 to -1)
val KEY_RANGE = 'a'..'z'
val DOOR_RANGE = 'A'..'Z'

lateinit var map: Array<CharArray>
lateinit var keys: HashSet<Char>
lateinit var isVisited: Array<BooleanArray>
lateinit var queue: LinkedList<Pair<Int, Int>>

fun main() {
    val sb = StringBuilder()
    repeat(readln().toInt()) {
        val st = StringTokenizer(readln())
        val h = st.nextToken().toInt()
        val w = st.nextToken().toInt()

        val rowRange = 0 until h
        val colRange = 0 until w

        map = Array(h) {
            val line = readln()
            CharArray(w) { col -> line[col] }
        }

        keys = HashSet(26)
        readln().takeUnless { it == "0" }?.forEach(keys::add)

        var docCount: Int
        var isNewKeyFound: Boolean

        do {
            docCount = 0
            isNewKeyFound = false
            isVisited = Array(h) { BooleanArray(w) }
            queue = LinkedList()

            for (col in colRange) maybeOfferEntrance(row = 0, col)
            for (col in colRange) maybeOfferEntrance(rowRange.last, col)
            for (row in 1 until rowRange.last) maybeOfferEntrance(row, col = 0)
            for (row in 1 until rowRange.last) maybeOfferEntrance(row, colRange.last)

            while (queue.isNotEmpty()) {
                val (row, col) = queue.poll()
                when (map[row][col]) {
                    '$' -> ++docCount

                    in KEY_RANGE -> {
                        if (keys.add(map[row][col])) isNewKeyFound = true
                    }

                    else -> Unit
                }

                for ((rowDir, colDir) in DIR) {
                    val nextRow = row + rowDir
                    if (nextRow !in rowRange) continue

                    val nextCol = col + colDir
                    if (nextCol !in colRange) continue

                    if (map[nextRow][nextCol] == '*') continue
                    if (map[nextRow][nextCol] in DOOR_RANGE) {
                        val key = 'a' + (map[nextRow][nextCol] - 'A')
                        if (key !in keys) continue
                    }
                    if (isVisited[nextRow][nextCol]) continue

                    isVisited[nextRow][nextCol] = true
                    queue.offer(nextRow to nextCol)
                }
            }
        } while (isNewKeyFound)

        sb.appendLine(docCount)
    }

    System.out.bufferedWriter().use {
        it.write(sb.toString())
        it.flush()
    }
}

fun maybeOfferEntrance(row: Int, col: Int) {
    when (map[row][col]) {
        '.', '$' -> {
            isVisited[row][col] = true
            queue.offer(row to col)
        }

        in KEY_RANGE -> {
            isVisited[row][col] = true
            keys.add(map[row][col])
            queue.offer(row to col)
        }

        in DOOR_RANGE -> {
            val key = 'a' + (map[row][col] - 'A')
            if (key in keys) {
                isVisited[row][col] = true
                queue.offer(row to col)
            }
        }

        else -> Unit
    }
}
