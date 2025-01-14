class Solution {
    var visit: Array<Boolean> = Array(50) { false }
    var answer = 50

    fun solution(begin: String, target: String, words: Array<String>): Int {

        if (!words.contains(target)) return 0

        dfs(begin, target, words, 0)

        return answer
    }
    fun dfs(current: String, target: String, words: Array<String>, depth: Int) {
        if (current == target) {
            answer = minOf(answer, depth)
        }
        for (i in words.indices) {
            if (!visit[i] && canChange(current, words[i])) {
                visit[i] = true
                dfs(words[i], target, words, depth + 1)
                visit[i] = false
            }
        }
    }
    fun canChange(current: String, word: String): Boolean {
        var count = 0
        for (i in current.indices) {
            if (current[i] != word[i]) count++
        }
        return count == 1
    }
}