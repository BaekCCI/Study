fun main() {
    val (n, m) = readln().split(" ").map { it.toInt() }
    val friends: MutableMap<Int, MutableList<Int>> = mutableMapOf()

    for (i in 0 until m) {
        val input = readln().split(" ").map { it.toInt() }
        friends.getOrPut(input[0]) { mutableListOf() }.add(input[1])
        friends.getOrPut(input[1]) { mutableListOf() }.add(input[0])
    }

    val visit = BooleanArray(n)
    var result = false
    fun dfs(cur: Int, depth: Int) {
        if (depth == 5) {
            result = true
            return
        }
        friends[cur]?.forEach {
            if (!visit[it]) {
                visit[it] = true
                dfs(it, depth + 1)
                visit[it] = false
            }
        }
    }
    friends.forEach {
        visit[it.key] = true
        dfs(it.key, 1)
        if (result) {
            println(1)
            return
        }
        visit[it.key] = false
    }
    println(0)
}