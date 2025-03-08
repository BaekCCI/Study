fun main() {
    val (n, m) = readln().split(" ").map { it.toInt() }
    val (r, c, d) = readln().split(" ").map { it.toInt() }
    val graph = Array(n) { IntArray(m) }

    val direction = arrayOf(intArrayOf(-1, 0), intArrayOf(0, 1), intArrayOf(1, 0), intArrayOf(0, -1))

    for (i in 0 until n) {
        val input = readln().split(" ").map { it.toInt() }
        graph[i] = input.toIntArray()
    }
    fun isValidMove(x: Int, y: Int): Boolean {
        return x in 0 until n && y in 0 until m && graph[x][y] != 1
    }

    var x = r
    var y = c
    var dir = d
    var count = 0
    while (true) {
        if (graph[x][y] == 0) {
            graph[x][y] = -1
            count++
        }
        var isExist = false
        for (i in dir + 3 downTo dir) {
            val nx = x + direction[i % 4][0]
            val ny = y + direction[i % 4][1]
            if (isValidMove(nx, ny) && graph[nx][ny] == 0) {
                x = nx
                y = ny
                dir = i % 4
                isExist = true
                break
            }
        }
        if (!isExist) {
            val goBack = (dir + 2) % 4
            val bx = x + direction[goBack][0]
            val by = y + direction[goBack][1]
            if (isValidMove(bx, by)) {
                x = bx
                y = by
            } else {
                break
            }
        }
    }
    println(count)
}