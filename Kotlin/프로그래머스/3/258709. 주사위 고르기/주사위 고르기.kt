class Solution {
    fun solution(dice: Array<IntArray>): IntArray {
        val n = dice.size

        val idxOfDices = mutableListOf<List<Int>>()
        fun combi(idx: Int, cur: List<Int>) {

            if (cur.size == n / 2) {
                idxOfDices.add(cur)
                return
            }
            for (i in idx until n) {
                combi(i + 1, cur + i)
            }
        }
        combi(1, listOf(0))

        fun getSumMap(size: Int, idxOfDice: List<Int>): Map<Int, Int> {
            val result: MutableMap<Int, Int> = mutableMapOf()

            fun dfs(depth: Int, sum: Int) {
                if (depth == size) {
                    result[sum] = result.getOrDefault(sum, 0) + 1
                    return
                }

                val list = dice[idxOfDice[depth]]
                for (num in list) {
                    dfs(depth + 1, sum + num)
                }
            }
            dfs(0, 0)
            return result
        }

        var maxWin: Pair<Int, List<Int>> = Pair(0, emptyList())
        for (idxOfDice in idxOfDices) {
            val size = idxOfDice.size
            val matchedIdx = (0 until n).filter { it !in idxOfDice }

            val aSum = getSumMap(size, idxOfDice)
            val bSum = getSumMap(size, matchedIdx)


            var aWin = 0
            var bWin = 0
            for ((a, aCount) in aSum) {
                for ((b, bCount) in bSum) {
                    if (a > b) {
                        aWin += aCount * bCount
                    } else if (a < b) {
                        bWin += aCount * bCount
                    }
                }
            }
            if (aWin > maxWin.first) {
                maxWin = Pair(aWin, idxOfDice)
            }
            if (bWin > maxWin.first) {
                maxWin = Pair(bWin, matchedIdx)
            }
        }
        return maxWin.second.map { it + 1 }.toIntArray()
    }
}