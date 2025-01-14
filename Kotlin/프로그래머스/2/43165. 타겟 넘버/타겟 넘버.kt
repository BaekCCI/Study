class Solution {
    val visit: BooleanArray = BooleanArray(20) { false }
    var answer = 0
    fun solution(numbers: IntArray, target: Int): Int {

        dfs(numbers, target, 0, 0)
        return answer
    }

    fun dfs(numbers: IntArray, target: Int, depth: Int, sum: Int) {
        if (depth == numbers.size) {
            if (sum == target) {
                answer++
            }
        } else {
            dfs(numbers, target, depth + 1, sum + numbers[depth])
            dfs(numbers, target, depth + 1, sum - numbers[depth])
        }
    }
}