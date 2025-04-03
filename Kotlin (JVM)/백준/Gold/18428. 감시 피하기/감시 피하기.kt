fun main() {
    val n = readln().toInt()
    val map = Array(n) { CharArray(n) }
    val emptySpace = mutableListOf<IntArray>()

    val teachers = mutableListOf<IntArray>()
    for (i in 0 until n) {
        map[i] = readln().split(" ").map { it[0] }.toCharArray()
        for (j in 0 until n) {
            if (map[i][j] == 'X') {
                emptySpace.add(intArrayOf(i, j))
            } else if (map[i][j] == 'T') {
                teachers.add(intArrayOf(i, j))
            }
        }
    }

    val direction = arrayOf(intArrayOf(1, 0), intArrayOf(0, 1), intArrayOf(-1, 0), intArrayOf(0, -1))

    fun isValidMove(c: Int, r: Int, walls: MutableList<IntArray>): Boolean {
        return c in 0 until n && r in 0 until n && walls.none { it[0] == c && it[1] == r }
    }

    fun bfs(walls: MutableList<IntArray>): Boolean {
        for (t in teachers) {
            val que = ArrayDeque<IntArray>()
            que.add(t)
            while (que.isNotEmpty()) {
                val (c, r) = que.removeFirst()

                for (dir in direction) {
                    var nc = c + dir[0]
                    var nr = r + dir[1]
                    while (isValidMove(nc, nr, walls)) {
                        if (map[nc][nr] == 'S') {
                            return false
                        }
                        nc += dir[0]
                        nr += dir[1]
                    }
                }
            }
        }
        return true
    }

    fun wallCombination(walls: MutableList<IntArray>, idx: Int): Boolean {
        if (walls.size == 3) {
            return bfs(walls)
        }
        for (i in idx until emptySpace.size) {
            walls.add(emptySpace[i])
            if (wallCombination(walls, i + 1)) {
                return true
            }
            walls.removeLast()
        }
        return false
    }
    if (wallCombination(mutableListOf(), 0)) {
        println("YES")
    } else {
        println("NO")
    }
}