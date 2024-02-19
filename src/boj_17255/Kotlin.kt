package boj_17255

lateinit var n: String

var mergedStepLength: Int = 0
lateinit var isVisited: BooleanArray
val mergedSteps: HashSet<String> = hashSetOf()

fun main() {
    n = readln()

    mergedStepLength = n.length * (n.length + 1) shr 1
    isVisited = BooleanArray(n.length)
    for (start in n.indices) {
        isVisited[start] = true
        buildSteps(start)
        isVisited[start] = false
    }

    print(mergedSteps.size)
}

fun buildSteps(
    left: Int,
    right: Int = left,
    prevStep: StringBuilder = StringBuilder(n[left].toString()),
    mergedStep: StringBuilder = StringBuilder(prevStep)
) {
    if (mergedStep.length == mergedStepLength) {
        mergedSteps.add(mergedStep.toString())
        return
    }

    val nextLeft = left - 1
    if (nextLeft in n.indices && !isVisited[nextLeft]) {
        isVisited[nextLeft] = true
        val nextPrevStep = StringBuilder(n[nextLeft].toString()).append(prevStep)
        val nextMergedStep = StringBuilder(mergedStep).append(nextPrevStep)
        buildSteps(nextLeft, right, nextPrevStep, nextMergedStep)
        isVisited[nextLeft] = false
    }

    val nextRight = right + 1
    if (nextRight in n.indices && !isVisited[nextRight]) {
        isVisited[nextRight] = true
        val nextPrevStep = StringBuilder(prevStep).append(n[nextRight])
        val nextMergedStep = StringBuilder(mergedStep).append(nextPrevStep)
        buildSteps(left, nextRight, nextPrevStep, nextMergedStep)
        isVisited[nextRight] = false
    }
}
