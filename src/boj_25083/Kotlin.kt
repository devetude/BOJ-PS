package boj_25083

fun main() {
    val result = """
                 ,r'"7
        r`-_   ,'  ,/
         \. ". L_r'
           `~\/
              |
              |
    """.trimIndent()

    System.out.bufferedWriter().use {
        it.write(result)
        it.flush()
    }
}
