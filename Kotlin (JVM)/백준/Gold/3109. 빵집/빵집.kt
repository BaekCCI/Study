val direction = arrayOf(intArrayOf(-1, 1), intArrayOf(0, 1), intArrayOf(1, 1))
fun main() {
    val (r, c) = readln().split(" ").map { it.toInt() }

    val map = Array(r) { readln().toCharArray() }

    var result = 0
    val visit = Array(r) { BooleanArray(c) }

    fun dfs(curR: Int, curC: Int): Boolean {
        if (curC == c - 1) {
            return true
        }

        for (dir in direction) {
            val nr = curR + dir[0]
            val nc = curC + dir[1]

            if (nr in 0 until r && nc in 0 until c && !visit[nr][nc] && map[nr][nc] == '.') {
                visit[nr][nc] = true
                if (dfs(nr, nc)) {
                    return true
                }
            }
        }
        return false
    }

    for (i in 0 until r) {
        if (map[i][0] == '.') {
            visit[i][0] = true
            if(dfs(i, 0)) result++
        }
    }
    println(result)
}