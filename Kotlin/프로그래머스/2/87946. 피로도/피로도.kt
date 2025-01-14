class Solution {
    val visit: Array<Boolean> = Array(8) { false }
    var answer: Int = 0
    fun solution(k: Int, dungeons: Array<IntArray>): Int {
        dfs(k, dungeons, 0)
        return answer
    }

    fun dfs(tired: Int, dungeons: Array<IntArray>, depth: Int) {
        answer = maxOf(answer, depth)
        for (i in dungeons.indices) {
            if (!visit[i] && dungeons[i][0] <= tired) {
                visit[i] = true
                dfs(tired - dungeons[i][1], dungeons, depth + 1)
                visit[i] = false
            }
        }
    }
}