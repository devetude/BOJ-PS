package boj_19581

import java.util.LinkedList
import java.util.StringTokenizer
import kotlin.math.max

var n: Int = 0
lateinit var adjacencyList: Array<LinkedList<Pair<Int, Int>>>
lateinit var isVisited: BooleanArray
var farDistance: Int = 0
var farNode: Int = 0

fun main() {
    n = readln().toInt()

    adjacencyList = Array(size = n + 1) { LinkedList() }
    repeat(times = n - 1) {
        val st = StringTokenizer(readln())
        val u = st.nextToken().toInt()
        val v = st.nextToken().toInt()
        val d = st.nextToken().toInt()
        adjacencyList[u].add(v to d)
        adjacencyList[v].add(u to d)
    }

    val a = findFarNode(from = 1)
    val b = findFarNode(from = a)
    val secondFarDistanceFromA = findFarDistance(from = a, exceptFor = b)
    val secondFarDistanceFromB = findFarDistance(from = b, exceptFor = a)
    val secondFarDistance = max(secondFarDistanceFromA, secondFarDistanceFromB)

    print(secondFarDistance)
}

fun findFarNode(from: Int): Int {
    setup(from)
    updateFarNodeAndDistance(from)

    return farNode
}

fun findFarDistance(from: Int, exceptFor: Int): Int {
    setup(from)
    isVisited[exceptFor] = true
    updateFarNodeAndDistance(from)

    return farDistance
}

fun setup(u: Int) {
    isVisited = BooleanArray(size = n + 1).apply { this[u] = true }
    farDistance = 0
    farNode = u
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
