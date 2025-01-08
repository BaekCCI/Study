class Solution {
    private val visit: MutableList<Int> = mutableListOf()

    fun solution(n: Int, computers: Array<IntArray>): Int {
        var answer = 0

        for (i in computers.indices) {
            if (visit.contains(i)) continue
            checkVisit(computers, i)
            answer++
        }
        return answer
    }

    private fun checkVisit(computers: Array<IntArray>, index: Int) {
        computers[index].forEachIndexed { i, it ->
            if (it == 1 && !visit.contains(i)) {
                visit.add(i)
                checkVisit(computers, i)
            }
        }
    }
}