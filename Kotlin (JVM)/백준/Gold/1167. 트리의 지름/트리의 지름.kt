fun main() {
    val n = readln().toInt()
    val tree: Array<MutableList<IntArray>> = Array(n) { mutableListOf() }

    for (i in 0 until n) {
        val input = readln().split(" ").map { it.toInt() }.toMutableList()
        input.removeLast()
        val start = input.removeFirst() - 1
        for (j in 0 until input.size step 2) {
            tree[start].add(intArrayOf(input[j] - 1, input[j + 1]))
        }
    }

    val visit = BooleanArray(n)
    var farNode = intArrayOf(-1, -1)
    fun dfs(cur: Int, pathSum: Int) {
        if (tree[cur].all { visit[it[0]] }) {
            farNode = if (pathSum > farNode[1]) intArrayOf(cur, pathSum) else farNode
        }
        tree[cur].forEach {
            if (!visit[it[0]]) {
                visit[it[0]] = true
                dfs(it[0], pathSum + it[1])
                visit[it[0]] = false
            }
        }

    }
    visit[0] = true
    dfs(0, 0)
    visit.fill(false)
    visit[farNode[0]]=true
    dfs(farNode[0],0)
    println(farNode[1])
}