fun main() {
    val (n, m) = readln().split(" ").map { it.toInt() }
    val tree: MutableMap<Int, MutableList<IntArray>> = mutableMapOf()
    val node = Array(m) { IntArray(2) }

    for (i in 0 until n - 1) {
        val input = readln().split(" ").map { it.toInt() }
        tree.getOrPut(input[0]) { mutableListOf() }.add(intArrayOf(input[1], input[2]))
        tree.getOrPut(input[1]) { mutableListOf() }.add(intArrayOf(input[0], input[2]))
    }
    for (i in 0 until m) {
        val input = readln().split(" ").map { it.toInt() }
        node[i] = input.toIntArray()
    }
    fun bfs(start: Int, target: Int) {
        val que = ArrayDeque<IntArray>()
        val visit = BooleanArray(n + 1)
        que.add(intArrayOf(start, 0))
        visit[start] = true
        while (que.isNotEmpty()) {
            val (value, distance) = que.removeFirst()
            if(value == target){
                println(distance)
                return
            }
            tree[value]?.forEach {
                if(!visit[it[0]]){
                    visit[it[0]] = true
                    que.add(intArrayOf(it[0],distance+it[1]))
                }
            }
        }
    }
    node.forEach {
        bfs(it[0],it[1])
    }
}