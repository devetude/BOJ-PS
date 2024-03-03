package boj_21314

fun main() {
    val maxBuilder = StringBuilder()
    val minBuilder = StringBuilder()
    var m = 0
    readln().forEach { c ->
        if (c == 'K') {
            maxBuilder.append(5)
            repeat(m) { maxBuilder.append(0) }

            if (0 < m) minBuilder.append(1)
            repeat(times = m - 1) { minBuilder.append(0) }
            minBuilder.append(5)

            m = 0
        } else {
            ++m
        }
    }

    if (0 < m) {
        repeat(m) { maxBuilder.append(1) }

        minBuilder.append(1)
        repeat(times = m - 1) { minBuilder.append(0) }
    }

    println(maxBuilder.toString())
    print(minBuilder.toString())
}
