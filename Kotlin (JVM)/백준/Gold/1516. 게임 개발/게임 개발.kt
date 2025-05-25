data class Building(
    var time: Int = 0,
    var prebuilt: MutableList<Int> = mutableListOf()
)

fun main() {
    val n = readln().toInt()

    val buildings = Array(n + 1) { Building() }

    for (i in 1..n) {
        val input = readln().split(" ").map { it.toInt() }.toMutableList()
        input.removeLast()
        buildings[i].time = input.removeFirst()
        buildings[i].prebuilt = input
    }

    val dp = IntArray(n + 1)

    fun calculateTime(num: Int): Int {
        if (dp[num] != 0) {
            return dp[num]
        }
        var prebuiltTime = 0
        buildings[num].prebuilt.forEach {
            prebuiltTime = maxOf(prebuiltTime, calculateTime(it))
        }
        dp[num] = buildings[num].time + prebuiltTime
        return dp[num]
    }

    for (i in 1..n) {
        println(calculateTime(i))
    }
}