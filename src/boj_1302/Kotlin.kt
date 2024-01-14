package boj_1302

fun main() {
    val map = HashMap<String, Int>()
    repeat(readln().toInt()) {
        val name = readln()
        map[name] = map.getOrDefault(name, defaultValue = 0) + 1
    }

    var topName = ""
    var topCount = 0
    map.forEach { (name, count) ->
        when {
            topCount < count -> {
                topName = name
                topCount = count
            }

            topCount == count && name < topName -> {
                topName = name
            }

            else -> Unit
        }
    }

    print(topName)
}
