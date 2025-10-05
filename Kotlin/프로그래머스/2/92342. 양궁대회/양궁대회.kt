class Solution {
    fun solution(n: Int, info: IntArray): IntArray {
        var maxDif = Int.MIN_VALUE
        var bestTarget = IntArray(11) { 0 }

        fun isBest(target: IntArray): Boolean {

            for (i in 10 downTo 0) {
                if (bestTarget[i] != target[i]) return target[i] > bestTarget[i]
            }
            return false
        }

        fun dfs(idx: Int, remainArrow: Int, ryan: Int, apeach: Int, target: IntArray) {

            if (idx == 11) {
                if (ryan <= apeach) return

                val dif = ryan - apeach
                val temp = target.copyOf()
                temp[10] += remainArrow

                if (dif == maxDif) {
                    if (isBest(temp)) {
                        bestTarget = temp
                    }
                } else if (dif >= maxDif) {
                    bestTarget = temp
                    maxDif = dif
                }
                return
            }

            var apeachCount = info[idx]
            if (apeachCount + 1 <= remainArrow) {
                dfs(idx + 1, remainArrow - (apeachCount + 1), ryan + (10 - idx), apeach, target + (apeachCount + 1))
            }
            if (apeachCount > 0) {
                dfs(idx + 1, remainArrow, ryan, apeach + (10 - idx), target + 0)
            } else {
                dfs(idx + 1, remainArrow, ryan, apeach, target + 0)
            }
        }


        dfs(0, n, 0, 0, intArrayOf())
        return if (maxDif == Int.MIN_VALUE) intArrayOf(-1) else bestTarget
    }
}