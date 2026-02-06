fun main() {
    val c = readln().toInt()
    repeat(c) {
        println(runCase())
    }
}

fun runCase(): Int {
    val posAbility = Array(11) { readln().split(" ").map { it.toInt() } }
    var answer = 0
    val visited = BooleanArray(11)

    fun dfs(pos: Int, sum: Int) {

        if (pos == 11) {
            answer = maxOf(answer, sum)
            return
        }

        for (i in 0 until 11) {
            if (!visited[i] && posAbility[i][pos] > 0) {
                visited[i] = true
                dfs(pos + 1, sum + posAbility[i][pos])
                visited[i] = false
            }
        }
    }
    dfs(0, 0)
    return answer
}