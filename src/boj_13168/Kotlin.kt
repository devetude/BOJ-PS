package boj_13168

import java.util.StringTokenizer

private const val INF: Double = Double.MAX_VALUE / 2.0

fun main() {
    var st = StringTokenizer(readln())
    val n = st.nextToken().toInt()
    val r = st.nextToken().toDouble()

    st = StringTokenizer(readln())
    val indexOf = hashMapOf<String, Int>()
    repeat(n) { indexOf[st.nextToken()] = indexOf.size }

    val m = readln().toInt()

    st = StringTokenizer(readln())
    val targetCities = Array(m) { st.nextToken() }

    val railRoadCostBetween = Array(n) { s -> DoubleArray(n) { e -> if (s == e) .0 else INF } }
    val normalCostBetween = Array(n) { s -> DoubleArray(n) { e -> if (s == e) .0 else INF } }
    repeat(readln().toInt()) {
        st = StringTokenizer(readln())
        val type = st.nextToken()
        val s = requireNotNull(indexOf[st.nextToken()])
        val e = requireNotNull(indexOf[st.nextToken()])
        val cost = st.nextToken().toDouble()

        val railRoadCost = when (type) {
            "ITX-Saemaeul", "ITX-Cheongchun", "Mugunghwa" -> .0
            "S-Train", "V-Train" -> cost / 2.0
            else -> cost
        }
        railRoadCostBetween[s][e] = minOf(railRoadCostBetween[s][e], railRoadCost)
        railRoadCostBetween[e][s] = minOf(railRoadCostBetween[e][s], railRoadCost)
        normalCostBetween[s][e] = minOf(normalCostBetween[s][e], cost)
        normalCostBetween[e][s] = minOf(normalCostBetween[e][s], cost)
    }

    for (via in 0 until n) {
        for (s in 0 until n) {
            for (e in 0 until n) {
                railRoadCostBetween[s][e] = minOf(
                    railRoadCostBetween[s][e],
                    b = railRoadCostBetween[s][via] + railRoadCostBetween[via][e]
                )
                normalCostBetween[s][e] = minOf(
                    normalCostBetween[s][e],
                    b = normalCostBetween[s][via] + normalCostBetween[via][e]
                )
            }
        }
    }

    var totalRailRoadCost = r
    var totalNormalCost = .0
    for (i in 0 until targetCities.lastIndex) {
        val s = requireNotNull(indexOf[targetCities[i]])
        val e = requireNotNull(indexOf[targetCities[i + 1]])
        totalRailRoadCost += railRoadCostBetween[s][e]
        totalNormalCost += normalCostBetween[s][e]
    }

    print(if (totalRailRoadCost < totalNormalCost) "Yes" else "No")
}
