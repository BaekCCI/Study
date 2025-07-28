fun main() {
    val (n, m) = readln().split(" ").map { it.toInt() }
    val map = Array(n) { readln().split(" ").map { it.toInt() }.toIntArray() }


    val dp = Array(n + 1) { IntArray(m + 1) }

    for (i in 1 until n + 1) {
        for (j in 1 until m + 1) {
            dp[i][j] = map[i - 1][j - 1] + dp[i - 1][j] + dp[i][j - 1] - dp[i - 1][j - 1]
        }
    }
    var answer = Int.MIN_VALUE

    for (i in 1 until n + 1) {
        for (j in 1 until m + 1) {
            for (c in 1 .. i) {
                for (r in 1 .. j) {
                    val sum = dp[i][j] - dp[c - 1][j] - dp[i][r - 1] + dp[c - 1][r - 1]
                    answer = maxOf(sum, answer)
                }
            }
        }
    }
    println(answer)
}