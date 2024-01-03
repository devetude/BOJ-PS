package boj_1167

import java.util.LinkedList
import java.util.StringTokenizer
import kotlin.math.max

fun main() {
    val n = readln().toInt()

    val adjacencyList = Array(size = n + 1) { LinkedList<Next>() }
    repeat(n) {
        val st = StringTokenizer(readln())
        val start = st.nextToken().toInt()

        while (true) {
            val end = st.nextToken().toInt()
            if (end == -1) break

            val weight = st.nextToken().toInt()
            adjacencyList[start].add(Next(end, weight))
            adjacencyList[end].add(Next(start, weight))
        }
    }

    var weights = IntArray(size = n + 1)
    val nextNodes = LinkedList<Int>()
    nextNodes.offer(1)
    var maxWeight = 0
    var maxWeightNode = 1
    while (nextNodes.isNotEmpty()) {
        val currentNode = nextNodes.poll()

        adjacencyList[currentNode].forEach { (nextNode, weight) ->
            if (nextNode == 1 || 0 < weights[nextNode]) return@forEach

            weights[nextNode] = weights[currentNode] + weight
            if (maxWeight < weights[nextNode]) {
                maxWeight = weights[nextNode]
                maxWeightNode = nextNode
            }
            nextNodes.offer(nextNode)
        }
    }

    weights = IntArray(size = n + 1)
    nextNodes.offer(maxWeightNode)
    maxWeight = 0
    while (nextNodes.isNotEmpty()) {
        val currentNode = nextNodes.poll()

        adjacencyList[currentNode].forEach { (nextNode, weight) ->
            if (nextNode == maxWeightNode || 0 < weights[nextNode]) return@forEach

            weights[nextNode] = weights[currentNode] + weight
            maxWeight = max(maxWeight, weights[nextNode])
            nextNodes.offer(nextNode)
        }
    }

    println(maxWeight)
}

data class Next(val node: Int, val weight: Int)
