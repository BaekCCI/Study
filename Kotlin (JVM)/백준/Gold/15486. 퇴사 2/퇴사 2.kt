fun main() {
    val n = readln().toInt()
    val schedule = Array(n) { IntArray(2) }
    for (i in 0 until n) {
        schedule[i] = readln().split(" ").map { it.toInt() }.toIntArray()
    }
    val dp = IntArray(n+1)

    for (i in n - 1 downTo 0) {
        val (t, p) = schedule[i]
        var complete = 0
        if (i + t <= n) {
            complete = p + dp[i + t]
        }
        dp[i] = maxOf(complete, dp[i + 1])
    }
    println(dp[0])
}