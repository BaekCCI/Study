fun main() {
    val n = readln().toInt()
    val steps = IntArray(n)
    for (i in 0 until n) {
        steps[i] = readln().toInt()
    }
    val dp = IntArray(n)

    if (n >= 1) dp[0] = steps[0]
    if (n >= 2) dp[1] = steps[0] + steps[1]
    if (n >= 3) dp[2] = maxOf(steps[2] + steps[1], steps[2] + steps[0])

    for (i in 3 until n) {
        dp[i] = maxOf(dp[i - 3] + steps[i - 1] + steps[i], dp[i - 2] + steps[i])
    }
    println(dp[n - 1])
}
