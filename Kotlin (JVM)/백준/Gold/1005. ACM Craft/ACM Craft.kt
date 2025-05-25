import java.io.*

data class Building(
    var time: Int = 0,
    var prebuilt: MutableList<Int> = mutableListOf()
)

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))

    val t = br.readLine().toInt()
    repeat(t) {
        val (n, k) = br.readLine().split(" ").map { it.toInt() }

        val buildings = Array(n + 1) { Building() }
        val input = br.readLine().split(" ").map { it.toInt() }

        for (i in 0 until n) {
            buildings[i + 1].time = input[i]
        }
        for (i in 0 until k) {
            val (pre, target) = br.readLine().split(" ").map { it.toInt() }
            buildings[target].prebuilt.add(pre)
        }

        val dp = IntArray(n + 1) { -1 }
        fun calculateTime(num: Int): Int {
            if (dp[num] != -1) {
                return dp[num]
            }
            var prebuiltTime = 0
            buildings[num].prebuilt.forEach {
                prebuiltTime = maxOf(prebuiltTime, calculateTime(it))
            }
            dp[num] = buildings[num].time + prebuiltTime
            return dp[num]
        }
        println(calculateTime(br.readLine().toInt()))
    }
}