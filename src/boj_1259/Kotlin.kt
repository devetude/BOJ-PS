package boj_1259

fun main() {
    System.out.bufferedWriter().use {
        while (true) {
            val input = readln()
            if (input == "0") return it.flush()

            var i = 0
            var j = input.lastIndex
            var result = "yes"
            while (i < j) {
                if (input[i++] != input[j--]) result = "no"
            }

            it.write(result)
            it.write("\n")
        }
    }
}
