fun main() {
    val (n, m) = readln().split(" ").map { it.toInt() }
    val map = Array(n) { IntArray(n) }
    val virus: MutableList<IntArray> = mutableListOf()
    var zeroCount = 0
    for (i in 0 until n) {
        map[i] = readln().split(" ").map { it.toInt() }.toIntArray()
        for (j in 0 until n) {
            if (map[i][j] == 2) {
                virus.add(intArrayOf(i, j))
            } else if (map[i][j] == 0) {
                zeroCount++
            }
        }
    }
    fun combination(
        index: Int = 0,
        values: List<IntArray> = emptyList(),
        result: MutableList<List<IntArray>> = mutableListOf()
    ): List<List<IntArray>> {
        if (values.size == m) {
            result.add(values)
            return result
        }
        for (i in index until virus.size) {
            combination(i + 1, values + virus[i], result)
        }
        return result
    }

    val virusSet = combination()

    val direction = arrayOf(intArrayOf(-1, 0), intArrayOf(1, 0), intArrayOf(0, -1), intArrayOf(0, 1))

    fun isValidMove(c: Int, r: Int): Boolean {
        return c in 0 until n && r in 0 until n && map[c][r] !=1
    }

    fun bfs(viruses: List<IntArray>): Int {
        val visit = Array(n) { BooleanArray(n) }
        val que = ArrayDeque<IntArray>()
        viruses.forEach {
            visit[it[0]][it[1]] = true
            que.add(it)
        }
        var empty = zeroCount
        var dis = -1
        while (que.isNotEmpty()) {
            dis++
            val size = que.size
            if (empty == 0) {
                return dis
            }

            for (i in 0 until size) {
                val (c, r) = que.removeFirst()
                direction.forEach {
                    val nc = c + it[0]
                    val nr = r + it[1]
                    if (isValidMove(nc, nr) && !visit[nc][nr]) {
                        visit[nc][nr] = true
                        que.add(intArrayOf(nc, nr))
                        if(map[nc][nr] == 0){
                            empty--
                        }
                    }
                }
            }
        }
        return if (empty == 0) dis else Int.MAX_VALUE
    }

    var answer = Int.MAX_VALUE
    virusSet.forEach {
        answer = minOf(answer, bfs(it))
    }
    if (answer == Int.MAX_VALUE) {
        println(-1)
        return
    }
    println(answer)
}