package boj_1967

import java.util.LinkedList
import java.util.StringTokenizer
import kotlin.math.max

fun main() {
    val n = readln().toInt()
    val adjacencyList = Array(size = n + 1) { LinkedList<Next>() }
    repeat(times = n - 1) {
        val st = StringTokenizer(readln())
        val start = st.nextToken().toInt()
        val end = st.nextToken().toInt()
        val weight = st.nextToken().toInt()
        adjacencyList[start].add(Next(end, weight))
        adjacencyList[end].add(Next(start, weight))
    }

    val nextNodes = LinkedList<Int>()
    nextNodes.offer(1)
    var weights = IntArray(size = n + 1)
    var maxWeight = 0
    var maxWeightNode = 1
    while (nextNodes.isNotEmpty()) {
        val currentNode = nextNodes.poll()
        val currentWeight = weights[currentNode]

        adjacencyList[currentNode].forEach { (nextNode, weight) ->
            if (nextNode == 1 || 0 < weights[nextNode]) return@forEach

            val nextWeight = currentWeight + weight
            weights[nextNode] = nextWeight
            if (maxWeight < nextWeight) {
                maxWeight = nextWeight
                maxWeightNode = nextNode
            }
            nextNodes.offer(nextNode)
        }
    }

    nextNodes.offer(maxWeightNode)
    weights = IntArray(size = n + 1)
    maxWeight = 0
    while (nextNodes.isNotEmpty()) {
        val currentNode = nextNodes.poll()
        val currentWeight = weights[currentNode]

        adjacencyList[currentNode].forEach { (nextNode, weight) ->
            if (nextNode == maxWeightNode || 0 < weights[nextNode]) return@forEach

            val nextWeight = currentWeight + weight
            weights[nextNode] = nextWeight
            maxWeight = max(maxWeight, nextWeight)
            nextNodes.offer(nextNode)
        }
    }

    println(maxWeight)
}

data class Next(val node: Int, val weight: Int)
