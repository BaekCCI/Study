fun main() {
    val (n, m) = readln().split(" ").map { it.toInt() }
    val graph = Array(n) { IntArray(m) }
    for (i in 0 until n) {
        val input = readln().map { it.digitToInt() }
        graph[i] = input.toIntArray()
    }
    val direction = arrayOf(intArrayOf(-1, 0), intArrayOf(1, 0), intArrayOf(0, -1), intArrayOf(0, 1))

    val que = ArrayDeque<IntArray>() // 좌표, count
    val visit = Array(n) { Array(m) { Pair(false, 0) } }
    que.add(intArrayOf(0, 0, 0, 1))
    fun isValidMove(x: Int, y: Int, wall: Int): Boolean {
        return x in 0 until n && y in 0 until m && graph[x][y] + wall < 2
    }
    while (que.isNotEmpty()) {
        val (x, y, wall, path) = que.removeFirst()
        if (x == n - 1 && y == m - 1) {
            println(path)
            return
        }
        direction.forEach {
            val nx = x + it[0]
            val ny = y + it[1]
            if (isValidMove(nx, ny, wall)) {
                if (!visit[nx][ny].first || visit[nx][ny].second > wall) {
                    visit[nx][ny] = Pair(true, wall)
                    que.add(intArrayOf(nx, ny, wall + graph[nx][ny], path + 1))
                }
            }
        }
    }
    println(-1)
}