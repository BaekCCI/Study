class Solution {
    val visit: BooleanArray = BooleanArray(10_000) { false }
    var answer = arrayOf<String>()
    fun solution(tickets: Array<Array<String>>): Array<String> {
        dfs(tickets, "ICN", mutableListOf())
        return answer
    }

    fun dfs(tickets: Array<Array<String>>, current: String, course: MutableList<String>) {
        if (course.size == tickets.size) {
            if (answer.isEmpty()) {
                course.add(current)
                answer = course.toTypedArray()
                course.removeLast()
            } else if (answer.joinToString() > course.joinToString()) {
                course.add(current)
                answer = course.toTypedArray()
                course.removeLast()
            }
        }
        for (i in tickets.indices) {
            if (!visit[i] && tickets[i][0] == current) {
                visit[i] = true
                course.add(current)
                dfs(tickets, tickets[i][1], course)
                course.removeLast()
                visit[i] = false
            }
        }
    }
}