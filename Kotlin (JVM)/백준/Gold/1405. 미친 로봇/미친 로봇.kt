import java.math.BigDecimal

fun main() {
    val input = readln().split(" ").map { it.toInt() }

    val n = input[0]
    val percentages = input.subList(1, input.size).map { it.toDouble() / 100 }

    val direction = arrayOf(intArrayOf(0, -1), intArrayOf(0, 1), intArrayOf(1, 0), intArrayOf(-1, 0))

    val visit = Array(n * 2 + 1) { BooleanArray(n * 2 + 1) }
    visit[n][n] = true


    fun calculatePercent(n: Int, perc: Double = 1.0, depth: Int = 0): Double {
        if (depth == n) {
            return perc
        }
        var result = 0.0
        for (per in percentages) {
            if (per == 0.0) {
                continue
            }
            result += calculatePercent(n, perc * per, depth + 1)
        }
        return result
    }

    var countPercent = 0.0
    fun dfs(c: Int, r: Int, depth: Int, percent: Double = 1.0, isSimple: Boolean = false) {
        if (depth == n) {
            if (isSimple) {
                countPercent += percent
            }
            return
        } else if (isSimple == true) {
            countPercent += percent * calculatePercent(n - depth)
            return
        }

        for (i in 0 until 4) {
            if (percentages[i] == 0.0) {
                continue
            }
            val nc = c + direction[i][0]
            val nr = r + direction[i][1]
            if (visit[nc][nr]) {
                dfs(nc, nr, depth + 1, percent * percentages[i], true)
            } else {
                visit[nc][nr] = true
                dfs(nc, nr, depth + 1, percent * percentages[i], isSimple)
                visit[nc][nr] = false
            }
        }
    }
    dfs(n, n, 0)
    println(BigDecimal.valueOf(1 - countPercent))
}