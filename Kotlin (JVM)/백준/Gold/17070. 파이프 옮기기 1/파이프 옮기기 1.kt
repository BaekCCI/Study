fun main() {
    val n = readln().toInt()
    val map = Array(n) { IntArray(n) }
    for (i in 0 until n) {
        map[i] = readln().split(" ").map { it.toInt() }.toIntArray()
    }

    val dp = Array(n) { Array(n) { IntArray(3) } } //i,j에 도달하는 경우의 수 저장
    dp[0][1][0] = 1

    for (i in 0 until n) {
        for (j in 0 until n) {
            if (map[i][j] == 1) continue
            //현재 좌표에 가로방향으로 도달하는 경우의 수
            if (j - 1 >= 0 && map[i][j - 1] != 1) {
                dp[i][j][0] += dp[i][j - 1][0] + dp[i][j - 1][2]
            }
            //현재 좌표에 세로방향으로 도달하는 경우의 수
            if (i - 1 >= 0 && map[i - 1][j] != 1) {
                dp[i][j][1] += dp[i - 1][j][1] + dp[i - 1][j][2]
            }
            //현재 좌표에 대각선 방향으로 도달하는 경우의 수
            if (i - 1 >= 0 && j - 1 >= 0) {
                if (map[i - 1][j] != 1 && map[i][j - 1] != 1 && map[i - 1][j - 1] != 1) {
                    dp[i][j][2] += dp[i - 1][j - 1][0] + dp[i - 1][j - 1][1] + dp[i - 1][j - 1][2]
                }
            }
        }
    }
    println(dp[n - 1][n - 1].sum())
}