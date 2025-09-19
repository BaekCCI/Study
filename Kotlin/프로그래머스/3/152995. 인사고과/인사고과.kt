class Solution {
    fun solution(scores: Array<IntArray>): Int {

        val wanho = scores[0]

        val sortedScore = scores.sortedWith(compareBy<IntArray>({ -it[0] }).thenBy { it[1] })

        val incentive = mutableListOf<IntArray>()

        var b = sortedScore[0][1]
        incentive.add(sortedScore[0])

        for (i in 1 until scores.size) {
            val cur = sortedScore[i]

            if (cur[1] >= b) {
                b = cur[1]
                incentive.add(cur)
            } else {
                if (cur.contentEquals(wanho)) {
                    return -1
                }
            }
        }

        var rank = 0
        var prevSum = Int.MIN_VALUE
        incentive.sortedByDescending { it[0] + it[1] }.forEachIndexed { idx, (a, b) ->
            val sum = a + b
            if (sum != prevSum) {
                rank = idx + 1
                prevSum = sum
            }
            if (wanho[0] == a && wanho[1] == b) {
                return rank
            }
        }
        return rank
    }
}