fun main() {
    val n = readln().toInt()
    val input = readln().split(" ").map { it.toInt() }

    val scv = IntArray(3)
    for (i in 0 until n) {
        scv[i] = input[i]
    }

    fun permute(): List<List<Int>> {
        var hp = intArrayOf(1, 3, 9)
        val results: MutableList<MutableList<Int>> = mutableListOf()
        val visited = BooleanArray(3)

        fun dfs(arr: MutableList<Int> = mutableListOf()) {
            if (arr.size == 3) {
                results.add(arr.toMutableList())
                return
            }

            for (i in hp.indices) {
                if (!visited[i]) {
                    visited[i] = true
                    arr.add(hp[i])
                    dfs(arr)
                    arr.removeLast()
                    visited[i] = false
                }
            }
        }
        dfs()
        return results
    }

    val orders = permute()

    val dp = Array(61) { Array(61) { IntArray(61) { -1 } } }
    dp[scv[0]][scv[1]][scv[2]] = 0

    val que = ArrayDeque<IntArray>()
    que.add(intArrayOf(scv[0], scv[1], scv[2]))

    while (que.isNotEmpty()) {
        val size = que.size

        repeat(size) {
            val (s1, s2, s3) = que.removeFirst()
            for (order in orders) {
                var ns1 = s1 - order[0]
                if (ns1 < 0) ns1 = 0

                var ns2 = s2 - order[1]
                if (ns2 < 0) ns2 = 0

                var ns3 = s3 - order[2]
                if (ns3 < 0) ns3 = 0

                if(ns1 == 0 && ns2 == 0 && ns3 == 0){
                    println(dp[s1][s2][s3] + 1)
                    return
                }

                if (dp[ns1][ns2][ns3] == -1) {
                    dp[ns1][ns2][ns3] = dp[s1][s2][s3] + 1
                    que.add(intArrayOf(ns1, ns2, ns3))
                }
            }
        }
    }
}