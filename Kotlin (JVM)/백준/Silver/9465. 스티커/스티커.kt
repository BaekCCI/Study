fun main() {
    val t = readln().toInt()

    for(repeat in 0 until t){
        val n = readln().toInt()
        val sticker = Array(2) { IntArray(n) }
        sticker[0] = readln().split(" ").map { it.toInt() }.toIntArray()
        sticker[1] = readln().split(" ").map { it.toInt() }.toIntArray()

        if (n == 1) {
            println(sticker.maxOf { it.max() })
            continue
        }

        val dp = Array(2) { IntArray(n) }
        dp[0][0] = sticker[0][0]
        dp[1][0] = sticker[1][0]
        dp[0][1] = sticker[1][0] + sticker[0][1]
        dp[1][1] = sticker[0][0] + sticker[1][1]

        for (i in 2 until n) {
            dp[0][i] = sticker[0][i] + maxOf(dp[1][i - 1], dp[1][i - 2])
            dp[1][i] = sticker[1][i] + maxOf(dp[0][i - 1], dp[0][i - 2])
        }
        println(maxOf(dp[0][n-1],dp[1][n-1]))
    }
}