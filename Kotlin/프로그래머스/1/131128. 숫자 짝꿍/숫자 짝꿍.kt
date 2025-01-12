class Solution {
    fun solution(X: String, Y: String): String {
        var answer: String = ""
        val countX: MutableList<Int> = MutableList(10) { 0 }
        val countY: MutableList<Int> = MutableList(10) { 0 }

        X.forEach {
            countX[it.digitToInt()] += 1
        }
        Y.forEach {
            countY[it.digitToInt()] += 1
        }
        for (i in 9 downTo 0) {
            val value = i.toString().repeat(minOf(countX[i], countY[i]))
            answer += value
        }
        if (answer.startsWith('0')) {
            answer = answer.toBigInteger().toString()
        }
        return if (answer == "") "-1" else answer
    }
}