package boj_10546

fun main() {
    val set = hashSetOf<String>()
    repeat(times = (readln().toInt() shl 1) - 1) {
        val name = readln()
        if (!set.remove(name)) set.add(name)
    }

    print(set.first())
}
