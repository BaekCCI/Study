val direction = arrayOf(intArrayOf(0, -1), intArrayOf(0, 1), intArrayOf(1, 0), intArrayOf(-1, 0))
fun main() {
    val n = readln().toInt()
    val map = Array(n) { IntArray(n) }

    for (i in 0 until n) {
        map[i] = readln().split(" ").map { it.toInt() }.toIntArray()
    }

    fun isValidMove(c: Int, r: Int, tree: Int): Boolean {
        return c in 0 until n && r in 0 until n && map[c][r] > tree

    }

    val dp = Array(n) { IntArray(n) }
    fun dfs(curC: Int, curR: Int): Int {

        if (dp[curC][curR] != 0) {
            return dp[curC][curR]
        }
        dp[curC][curR] = 1

        for (dir in direction) {
            val nc = curC + dir[0]
            val nr = curR + dir[1]
            if (isValidMove(nc, nr, map[curC][curR])) {
                dp[curC][curR] = maxOf(dp[curC][curR], dfs(nc, nr) + 1)
            }
        }
        return dp[curC][curR]
    }

    var result = 0
    for (i in 0 until n) {
        for (j in 0 until n) {
            result = maxOf(dfs(i, j), result)
        }
    }
    println(result)
}
