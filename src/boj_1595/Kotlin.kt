package boj_1595

import java.util.LinkedList
import java.util.StringTokenizer

val adjacencyList: Array<LinkedList<Pair<Int, Int>>> = Array(size = 10_001) { LinkedList() }
lateinit var isVisited: BooleanArray
var farDistance: Int = 0
var farNode: Int = 0

fun main() {
    while (true) {
        val line = readlnOrNull()
        if (line.isNullOrEmpty()) break

        val st = StringTokenizer(line)
        val u = st.nextToken().toInt()
        val v = st.nextToken().toInt()
        val d = st.nextToken().toInt()

        adjacencyList[u].add(v to d)
        adjacencyList[v].add(u to d)
    }

    val farNode = findFarNode(from = 1)
    val farDistance = findFarDistance(farNode)

    print(farDistance)
}

fun findFarNode(from: Int): Int {
    setup(from)
    updateFarNodeAndDistance(from)

    return farNode
}

fun findFarDistance(from: Int): Int {
    setup(from)
    updateFarNodeAndDistance(from)

    return farDistance
}

fun setup(from: Int) {
    isVisited = BooleanArray(size = 10_001).apply { this[from] = true }
    farDistance = 0
    farNode = from
}

fun updateFarNodeAndDistance(from: Int, distanceToFrom: Int = 0) {
    if (farDistance < distanceToFrom) {
        farNode = from
        farDistance = distanceToFrom
    }

    adjacencyList[from].forEach { (to, distance) ->
        if (isVisited[to]) return@forEach

        isVisited[to] = true
        updateFarNodeAndDistance(to, distanceToFrom = distanceToFrom + distance)
        isVisited[to] = false
    }
}
