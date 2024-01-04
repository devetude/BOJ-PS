package boj_17070

import java.util.StringTokenizer

var result = 0

fun main() {
    val n = readln().toInt()
    val map = Array(size = n) { BooleanArray(size = n) }
    repeat(n) { row ->
        val st = StringTokenizer(readln())
        repeat(n) { col ->
            map[row][col] = st.nextToken().toInt() == 0
        }
    }

    dfs(map, row = 0, col = 1, Type.HORIZONTAL)

    println(result)
}

fun dfs(map: Array<BooleanArray>, row: Int, col: Int, type: Type) {
    if (row !in map.indices || col !in map.indices || !map[row][col]) return
    if (type == Type.DIAGONAL && (!map[row - 1][col] || !map[row][col - 1])) return

    if (row == map.lastIndex && col == map.lastIndex) {
        ++result
        return
    }

    when (type) {
        Type.HORIZONTAL -> {
            dfs(map, row, col = col + 1, Type.HORIZONTAL)
            dfs(map, row = row + 1, col = col + 1, Type.DIAGONAL)
        }

        Type.VERTICAL -> {
            dfs(map, row = row + 1, col, Type.VERTICAL)
            dfs(map, row = row + 1, col = col + 1, Type.DIAGONAL)
        }

        Type.DIAGONAL -> {
            dfs(map, row, col = col + 1, Type.HORIZONTAL)
            dfs(map, row = row + 1, col, Type.VERTICAL)
            dfs(map, row = row + 1, col = col + 1, Type.DIAGONAL)
        }
    }
}

enum class Type {
    HORIZONTAL, VERTICAL, DIAGONAL
}
