package boj_2941

fun main() {
    var s = readln()
    val croatiaAlphabets = setOf("c=", "c-", "dz=", "d-", "lj", "nj", "s=", "z=")

    croatiaAlphabets.forEach {
        s = s.replace(it, newValue = "*")
    }

    println(s.length)
}
