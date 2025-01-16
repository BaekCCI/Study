class Solution {
    fun solution(lines: Array<IntArray>): Int {
        var answer: Int = 0
        val duplicate: MutableMap<Pair<Int, Int>, Int> = mutableMapOf()

        lines.forEach {
            for (i in it[0] until it[1])
                duplicate[Pair(i, i + 1)] = duplicate.getOrDefault(Pair(i, i + 1), 0) + 1
        }
        answer = duplicate.filter { it.value >= 2 }.values.size
        return answer
    }
}