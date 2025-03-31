fun main() {
    val (n, m) = readln().split(" ").map { it.toInt() }
    val map = Array(m) { CharArray(n) }

    for (i in 0 until m) {
        map[i] = readln().toCharArray()
    }

    val direction = arrayOf(intArrayOf(-1, 0), intArrayOf(0, -1), intArrayOf(1, 0), intArrayOf(0, 1))
    var wCount = 0
    var bCount = 0
    val visit = Array(m) { BooleanArray(n) }

    fun bfs(i: Int, j: Int, target: Char) {
        val que = ArrayDeque<IntArray>()
        que.add(intArrayOf(i, j))
        visit[i][j] = true
        var count = 1

        while (que.isNotEmpty()) {
            val (c, r) = que.removeFirst()
            for (dir in direction) {
                val nc = c + dir[0]
                val nr = r + dir[1]
                if (nc in 0 until m && nr in 0 until n && !visit[nc][nr] && map[nc][nr] == target) {
                    visit[nc][nr] = true
                    que.add(intArrayOf(nc, nr))
                    count++
                }
            }
        }
        if (target == 'W') {
            wCount += count * count
        } else {
            bCount += count * count
        }

    }
    for (i in 0 until m) {
        for (j in 0 until n) {
            if (!visit[i][j]) {
                bfs(i, j, map[i][j])
            }
        }
    }
    println("$wCount $bCount")
}