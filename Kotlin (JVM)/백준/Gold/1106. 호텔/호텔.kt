data class City(
    var cost: Int = 0,
    var customer: Int = 0
)

fun main() {
    val (c, n) = readln().split(" ").map { it.toInt() }
    val cities = Array(n) { City() }
    for (i in 0 until n) {
        val input = readln().split(" ").map { it.toInt() }
        cities[i].cost = input[0]
        cities[i].customer = input[1]
    }

    val dp = IntArray(c + 1) { Int.MAX_VALUE }
    dp[0] = 0
    for (i in 1..c) {
        for (city in cities) {
            if (i <= city.customer) {
                dp[i] = minOf(dp[i], city.cost)
            } else {
                val temp = dp[i - city.customer] + city.cost
                dp[i] = minOf(dp[i],temp)
            }
        }
    }
    println(dp[c])
}