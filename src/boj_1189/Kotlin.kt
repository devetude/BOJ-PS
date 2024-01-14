package boj_1189

import java.util.StringTokenizer

val DIRECTIONS: Sequence<Pair<Int, Int>> = sequenceOf(1 to 0, -1 to 0, 0 to 1, 0 to -1)

var r: Int = 0
var c: Int = 0
var k: Int = 0
lateinit var map: Array<CharArray>
lateinit var isVisited: Array<BooleanArray>

var count: Int = 0

fun main() {
    val st = StringTokenizer(readln())
    r = st.nextToken().toInt()
    c = st.nextToken().toInt()
    k = st.nextToken().toInt()

    map = Array(r) { CharArray(c) }
    repeat(r) { row ->
        val line = readln()
        repeat(c) { col -> map[row][col] = line[col] }
    }

    isVisited = Array(r) { BooleanArray(c) }
    isVisited[r - 1][0] = true
    dfs(row = r - 1, col = 0)

    print(count)
}

fun dfs(row: Int, col: Int, depth: Int = 1) {
    if (k < depth) return
    if (row == 0 && col == c - 1 && depth == k) {
        ++count
        return
    }

    DIRECTIONS.map { row + it.first to col + it.second }
        .filter { it.first in 0 until r }
        .filter { it.second in 0 until c }
        .filter { map[it.first][it.second] == '.' }
        .filter { !isVisited[it.first][it.second] }
        .forEach {
            isVisited[it.first][it.second] = true
            dfs(it.first, it.second, depth = depth + 1)
            isVisited[it.first][it.second] = false
        }
}
