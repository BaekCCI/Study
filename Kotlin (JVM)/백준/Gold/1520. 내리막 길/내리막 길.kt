val direction = arrayOf(intArrayOf(0, -1), intArrayOf(0, 1), intArrayOf(1, 0), intArrayOf(-1, 0))

fun main() {

    val (M, N) = readln().split(" ").map { it.toInt() }
    val map = Array(M) { IntArray(N) }

    for (i in 0 until M) {
        map[i] = readln().split(" ").map { it.toInt() }.toIntArray()
    }

    val dp = Array(M) { IntArray(N) { -1 } }

    fun dfs(c: Int, r: Int): Int {
        if(c == M-1 && r == N-1){
            return 1
        }
        if (dp[c][r] != -1) {
            return dp[c][r]
        }
        dp[c][r] = 0
        for (dir in direction) {
            val nc = c + dir[0]
            val nr = r + dir[1]
            if (nc in 0 until M && nr in 0 until N) {
                if (map[c][r] > map[nc][nr]) {
                    dp[c][r] += dfs(nc, nr)
                }
            }
        }
        return dp[c][r]
    }
    println(dfs(0,0))
}
