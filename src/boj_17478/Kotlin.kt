package boj_17478

const val HEADER_SENTENCE: String = "어느 한 컴퓨터공학과 학생이 유명한 교수님을 찾아가 물었다."
val BODY_SENTENCES: Array<String> = arrayOf(
    "\"재귀함수가 뭔가요?\"",
    "\"잘 들어보게. 옛날옛날 한 산 꼭대기에 이세상 모든 지식을 통달한 선인이 있었어.",
    "마을 사람들은 모두 그 선인에게 수많은 질문을 했고, 모두 지혜롭게 대답해 주었지.",
    "그의 답은 대부분 옳았다고 하네. 그런데 어느 날, 그 선인에게 한 선비가 찾아와서 물었어.\""
)
val TERMINAL_SENTENCES: Array<String> = arrayOf(
    "\"재귀함수가 뭔가요?\"",
    "\"재귀함수는 자기 자신을 호출하는 함수라네\"",
    "라고 답변하였지."
)
const val FOOTER_SENTENCE: String = "라고 답변하였지."
const val INDENT: String = "____"

fun main() {
    val n = readln().toInt()

    val responseSb = StringBuilder().appendLine(HEADER_SENTENCE)
    buildResponse(n, responseSb)

    print(responseSb.toString())
}

fun buildResponse(
    n: Int,
    responseBuilder: StringBuilder,
    indentBuilder: StringBuilder = StringBuilder()
) {
    val indent = indentBuilder.toString()

    if (n == 0) return responseBuilder.appendLines(indent, *TERMINAL_SENTENCES)

    responseBuilder.appendLines(indent, *BODY_SENTENCES)
    buildResponse(n = n - 1, responseBuilder, indentBuilder.appendIndent())
    responseBuilder.appendLines(indent, FOOTER_SENTENCE)
}

fun StringBuilder.appendLines(indent: String, vararg args: String) {
    for (arg in args) append(indent).append(arg).append('\n')
}

fun StringBuilder.appendIndent(): StringBuilder = append(INDENT)
