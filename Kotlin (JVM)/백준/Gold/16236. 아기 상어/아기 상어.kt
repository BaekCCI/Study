fun main() {
    val n = readln().toInt()
    val graph = Array(n) { IntArray(n) }
    var shark = intArrayOf(-1, -1, 0) // x,y,dis
    for (i in 0 until n) {
        graph[i] = readln().split(" ").map { it.toInt() }.toIntArray()
        for (j in 0 until n) {
            if (graph[i][j] == 9) {
                shark = intArrayOf(i, j, 0)
            }
        }
    }
    val direction = arrayOf(intArrayOf(-1, 0), intArrayOf(0, -1), intArrayOf(1, 0), intArrayOf(0, 1))

    var sharkSize = 2
    fun isValidMove(x: Int, y: Int): Boolean {
        return x in 0 until n && y in 0 until n && graph[x][y] <= sharkSize
    }

    fun bfs(shark: IntArray): IntArray { // x,y,size,time
        val visit = Array(n) { BooleanArray(n) }
        val que = ArrayDeque<IntArray>()
        visit[shark[0]][shark[1]] = true
        que.add(shark)
        graph[shark[0]][shark[1]] = 0

        var tempX = Int.MAX_VALUE
        var tempY = Int.MAX_VALUE

        var distance = 0
        while (que.isNotEmpty()) {
            distance++
            val size = que.size

            for (i in 0 until size) {
                val value = que.removeFirst()
                direction.forEach {
                    val nx = value[0] + it[0]
                    val ny = value[1] + it[1]
                    if (isValidMove(nx, ny) && !visit[nx][ny]) {
                        if (graph[nx][ny] != 0 && graph[nx][ny] < sharkSize) {
                            if (tempX > nx) {
                                tempX = nx
                                tempY = ny
                            } else if (tempX == nx && tempY > ny) {
                                tempY = ny
                            }
                        }
                        visit[nx][ny] = true
                        que.add(intArrayOf(nx, ny))
                    }
                }
            }
            if (tempX != Int.MAX_VALUE) {
                return intArrayOf(tempX, tempY, distance)
            }
        }
        return shark
    }
    
    var eatFish = 0
    while (true) {
        val curShark = bfs(shark)

        if (shark.contentEquals(curShark)) {
            break
        } else {
            shark[0] = curShark[0]
            shark[1] = curShark[1]
            shark[2] += curShark[2]

            graph[shark[0]][shark[1]] = 0
            eatFish++

            if (eatFish == sharkSize) {
                sharkSize++
                eatFish = 0
            }
        }
    }
    println(shark[2])
}