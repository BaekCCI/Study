fun main() {
    val n = readln().toInt()
    val alcohol = IntArray(n)

    for (i in 0 until n) {
        alcohol[i] = readln().toInt()
    }

    val dp = IntArray(n)
    if (n >= 1) {
        dp[0] = alcohol[0]
    }
    if (n >= 2) {
        dp[1] = alcohol[0] + alcohol[1]
    }
    if (n >= 3) {
        dp[2] = maxOf(alcohol[0] + alcohol[2], alcohol[1] + alcohol[2], alcohol[0] + alcohol[1])
    }

    for (i in 3 until n) {
        dp[i] = maxOf(dp[i - 3] + alcohol[i - 1] + alcohol[i], dp[i - 2] + alcohol[i], dp[i - 1])
    }
    println(dp.maxOrNull())
}