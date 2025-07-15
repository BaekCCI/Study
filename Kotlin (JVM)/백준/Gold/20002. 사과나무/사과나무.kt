fun main() {
    val n = readln().toInt()

    val graph = Array(n) { readln().split(" ").map { it.toInt() }.toIntArray() }

    val prefixSum = Array(n + 1) { IntArray(n + 1) }

    for (i in 1..n) {
        for (j in 1..n) {
            prefixSum[i][j] = prefixSum[i - 1][j] + prefixSum[i][j - 1] - prefixSum[i - 1][j - 1] + graph[i - 1][j - 1]
        }
    }

    var result = Int.MIN_VALUE

    for (size in 1..n) {
        for (i in 0..n - size) {
            for (j in 0..n - size) {
                val sum =
                    prefixSum[i + size][j + size] - prefixSum[i][j + size] - prefixSum[i + size][j] + prefixSum[i][j]

                result = maxOf(result, sum)
            }
        }
    }
    println(result)
}