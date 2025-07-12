fun main() {
    val n = readln().toInt()

    val dp = Array(n + 1) { IntArray(10) }//i자릿수, 마지막 숫자 = 개수

    for (i in 0..9) {
        dp[1][i] = 1
    }
    for (i in 2..n) {
        dp[i][0] = 1
        for (j in 1..9) {
            dp[i][j] = (dp[i][j - 1] + dp[i - 1][j]) % 10007
        }
    }
    println(dp[n].sum() % 10007)
}