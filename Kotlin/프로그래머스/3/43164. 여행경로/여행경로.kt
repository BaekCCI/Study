class Solution {
    val visit: BooleanArray = BooleanArray(10_000) { false }
    var answer = arrayOf<String>()
    fun solution(tickets: Array<Array<String>>): Array<String> {
        val course = mutableListOf("ICN")
        dfs(tickets, "ICN", course)
        println(answer.joinToString())
        return answer
    }

    fun dfs(tickets: Array<Array<String>>, current: String, course: MutableList<String>) {
        if (course.size == tickets.size+1) {
            if (answer.isEmpty()) {
                answer = course.toTypedArray()
            } else if (answer.joinToString() > course.joinToString()) {
                answer = course.toTypedArray()
            }
        }
        for (i in tickets.indices) {
            if (!visit[i] && tickets[i][0] == current) {
                visit[i] = true
                course.add(tickets[i][1])
                dfs(tickets, tickets[i][1], course)
                course.removeLast()
                visit[i] = false
            }
        }
    }
}