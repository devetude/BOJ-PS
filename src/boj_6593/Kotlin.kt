package boj_6593

import java.util.LinkedList
import java.util.StringTokenizer

val LEV_DIRS: IntArray = intArrayOf(-1, 1)
val ROW_COL_DIRS: Array<Pair<Int, Int>> = arrayOf(1 to 0, -1 to 0, 0 to 1, 0 to -1)

fun main() {
    val sb = StringBuilder()
    while (true) {
        val st = StringTokenizer(readln())
        val l = st.nextToken().toInt()
        val r = st.nextToken().toInt()
        val c = st.nextToken().toInt()
        if (l == 0 && r == 0 && c == 0) break

        val levRange = 1..l
        val rowRange = 1..r
        val colRange = 1..c

        val map = Array(size = l + 1) { Array(size = r + 1) { CharArray(size = c + 1) } }
        var startCoordinate = Coordinate()
        var endCoordinate = Coordinate()
        for (lev in levRange) {
            for (row in rowRange) {
                val line = readln()
                for (col in colRange) {
                    map[lev][row][col] = line[col - 1]
                    when (map[lev][row][col]) {
                        'S' -> startCoordinate = Coordinate(lev, row, col)
                        'E' -> endCoordinate = Coordinate(lev, row, col)
                        else -> continue
                    }
                }
            }
            readln()
        }

        val depths = Array(size = l + 1) { Array(size = r + 1) { IntArray(size = c + 1) { -1 } } }
        with(startCoordinate) { depths[lev][row][col] = 0 }

        val nextCoordinates = LinkedList<Coordinate>()
        nextCoordinates.offer(startCoordinate)

        while (nextCoordinates.isNotEmpty()) {
            val curCoordinate = nextCoordinates.poll()
            if (curCoordinate == endCoordinate) break
            val (curLev, curRow, curCol) = curCoordinate

            for (levDir in LEV_DIRS) {
                val nextLev = curLev + levDir
                if (nextLev !in levRange) continue

                if (map[nextLev][curRow][curCol] == '#') continue
                if (-1 < depths[nextLev][curRow][curCol]) continue

                depths[nextLev][curRow][curCol] = depths[curLev][curRow][curCol] + 1
                val nextCoordinate = Coordinate(nextLev, curRow, curCol)
                nextCoordinates.offer(nextCoordinate)
            }

            for ((rowDir, colDir) in ROW_COL_DIRS) {
                val nextRow = curRow + rowDir
                if (nextRow !in rowRange) continue

                val nextCol = curCol + colDir
                if (nextCol !in colRange) continue

                if (map[curLev][nextRow][nextCol] == '#') continue
                if (-1 < depths[curLev][nextRow][nextCol]) continue

                depths[curLev][nextRow][nextCol] = depths[curLev][curRow][curCol] + 1
                val nextCoordinate = Coordinate(curLev, nextRow, nextCol)
                nextCoordinates.offer(nextCoordinate)
            }
        }

        val endDepth = with(endCoordinate) { depths[lev][row][col] }
        if (-1 < endDepth) {
            sb.append("Escaped in ", endDepth, " minute(s).")
        } else {
            sb.append("Trapped!")
        }.appendLine()
    }

    System.out.bufferedWriter().use {
        it.write(sb.toString())
        it.flush()
    }
}

data class Coordinate(val lev: Int = 0, val row: Int = 0, val col: Int = 0)
