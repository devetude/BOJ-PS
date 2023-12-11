package boj_10101

fun main() {
    val angles = buildList { repeat(times = 3) { add(readln().toInt()) } }

    val result = when {
        angles.sum() != 180 || angles.any { it == 0 } -> "Error"
        angles.all { it == 60 } -> "Equilateral"
        angles[0] == angles[1] || angles[0] == angles[2] || angles[1] == angles[2] -> "Isosceles"
        else -> "Scalene"
    }

    println(result)
}
