class Solution {
    private var visit: Array<Boolean> = Array(50) { false }
    private var answer = 0

    fun solution(begin: String, target: String, words: Array<String>): Int {

        if (!words.contains(target)) return 0

        dfs(begin, target, words, 0)

        println(answer)
        return answer
    }

    private fun dfs(current: String, target: String, words: Array<String>, depth: Int) {
        if (current == target) {
            answer = if (answer == 0) {
                depth
            } else {
                minOf(answer, depth)
            }
        }
        for (i in words.indices) {
            if (!visit[i] && canChange(current, words[i])) {
                visit[i] = true
                dfs(words[i], target, words, depth + 1)
                visit[i] = false
            }
        }
    }

    private fun canChange(current: String, word: String): Boolean {
        var count = 0
        for (i in current.indices) {
            if (current[i] != word[i]) count++
        }
        return count == 1
    }
}