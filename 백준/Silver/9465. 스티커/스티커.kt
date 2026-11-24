fun main() {
    val t = readln().toInt()
    repeat(t) {
        val n = readln().toInt()
        val stickers = Array(2) { IntArray(n) }
        repeat(2) {
            stickers[it] = readln().split(" ").map { it.toInt() }.toIntArray()
        }

        val dp = Array(2) { IntArray(n) { 0 } }

        if (n == 1) {
            println(maxOf(stickers[0][0], stickers[1][0]))
            return@repeat
        }
        dp[0][0] = stickers[0][0]
        dp[1][0] = stickers[1][0]
        dp[0][1] = stickers[1][0] + stickers[0][1]
        dp[1][1] = stickers[0][0] + stickers[1][1]

        for (i in 2 until n) {
            for (j in 0 until 2) {
                dp[j][i] = maxOf(dp[1 - j][i - 1] + stickers[j][i], dp[1 - j][i - 2] + stickers[j][i])

            }
        }
        println(dp.maxOf { it.max() })
    }
}

