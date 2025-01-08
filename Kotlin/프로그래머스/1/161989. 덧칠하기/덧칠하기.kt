class Solution {
    fun solution(n: Int, m: Int, section: IntArray): Int {
        var answer: Int = 0
        var paintIndex = 0

        for (i in section.indices) {
            if (paintIndex > n - 1) break
            if (section[i] <= paintIndex) continue
            paintIndex = (section[i] - 1) + m
            answer++
        }
        println(answer)
        return answer
    }
}
