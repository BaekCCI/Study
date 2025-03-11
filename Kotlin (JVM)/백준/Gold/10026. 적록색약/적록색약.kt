fun main() {
    val n = readln().toInt()
    val graph = Array(n) { readln().toCharArray() }
    var generalCount = 0
    var redCount = 0

    val direction = arrayOf(intArrayOf(-1, 0), intArrayOf(1, 0), intArrayOf(0, -1), intArrayOf(0, 1))
    val generalVisit = Array(n) { BooleanArray(n) }
    val redVisit = Array(n) { BooleanArray(n) }

    fun isValidMove(x: Int, y: Int, visit: Array<BooleanArray>): Boolean {
        return x in 0 until n && y in 0 until n && !visit[x][y]
    }

    fun bfs(x: Int, y: Int, color: Char, visit: Array<BooleanArray>, general: Boolean) {
        val que = ArrayDeque<IntArray>()
        que.add(intArrayOf(x, y))
        generalVisit[x][y] = true

        while (que.isNotEmpty()) {
            val cur = que.removeFirst()

            direction.forEach {
                val nx = cur[0] + it[0]
                val ny = cur[1] + it[1]
                if (isValidMove(nx, ny, visit)) {
                    if (general && graph[nx][ny] == color) {
                        visit[nx][ny] = true
                        que.add(intArrayOf(nx, ny))
                    } else if (!general) {
                        if (graph[nx][ny] == color) {
                            visit[nx][ny] = true
                            que.add(intArrayOf(nx, ny))
                        } else if (graph[nx][ny] != 'B' && color != 'B') {
                            visit[nx][ny] = true
                            que.add(intArrayOf(nx,ny))
                        }
                    }
                }
            }
        }
    }
    for (i in 0 until n) {
        for (j in 0 until n) {
            if (!generalVisit[i][j]) {
                bfs(i, j, graph[i][j], generalVisit, true)
                generalCount++
            }
            if (!redVisit[i][j]) {
                bfs(i,j,graph[i][j],redVisit,false)
                redCount++
            }
        }
    }
    println("$generalCount $redCount")
}