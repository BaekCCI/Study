fun main() {
    val n = readln().toInt()
    val subwayM = Array(n + 1) { mutableListOf<Int>() }

    for (i in 0 until n) {
        val (s1, s2) = readln().split(" ").map { it.toInt() }
        subwayM[s1].add(s2)
        subwayM[s2].add(s1)
    }

    val cycle = mutableSetOf<Int>()

    fun dfs(last: Int, cur: Int, path: List<Int>, visit: BooleanArray): Boolean {
        visit[cur] = true

        for (nextStation in subwayM[cur]) {
            if (!visit[nextStation]) {
                visit[nextStation] = true
                if (dfs(cur, nextStation, path + nextStation, visit)) return true
            } else if (nextStation != last) {
                for (i in path.size - 1 downTo 0) {
                    val p = path[i]
                    cycle.add(p)
                    if (p == nextStation) {
                        return true
                    }
                }
            }
        }
        return false
    }

    fun getDistance() {
        val result = MutableList(n + 1) { 0 }
        val que = ArrayDeque<Int>()
        val visit = BooleanArray(n + 1)
        cycle.forEach {
            que.add(it)
            visit[it] = true
        }
        var dis = 0
        while (que.isNotEmpty()) {
            val size = que.size
            dis++
            for (i in 0 until size) {
                val value = que.removeFirst()
                subwayM[value].forEach {
                    if (!visit[it]) {
                        visit[it] = true
                        result[it] = dis
                        que.add(it)
                    }
                }
            }
        }
        result.removeFirst()
        println(result.joinToString(" "))
    }
    for (i in 1..n) {
        if (dfs(-1, i, listOf(i), BooleanArray(n + 1))) {
            getDistance()
            return
        }
    }
}