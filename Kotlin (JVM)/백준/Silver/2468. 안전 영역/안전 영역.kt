fun main() {
    val n = readln().toInt()
    val map = Array(n) { IntArray(n) }
    var maxH = 0
    for (i in 0 until n) {
        map[i] = readln().split(" ").map { it.toInt() }.toIntArray()
        maxH = maxOf(maxH, map[i].max())
    }
    val direction = arrayOf(intArrayOf(-1, 0), intArrayOf(0, -1), intArrayOf(1, 0), intArrayOf(0, 1))

    var answer = 1
    for (h in 1 until maxH) {
        val visit = Array(n) { BooleanArray(n) }
        val que = ArrayDeque<IntArray>()
        var count = 0
        for (i in 0 until n) {
            for (j in 0 until n) {
                if (map[i][j] > h && !visit[i][j]) {
                    visit[i][j] = true
                    que.add(intArrayOf(i, j))
                    while (que.isNotEmpty()) {
                        val (c, r) = que.removeLast()
                        for (dir in direction) {
                            val nc = c + dir[0]
                            val nr = r + dir[1]
                            if (nc in 0 until n && nr in 0 until n && map[nc][nr] > h && !visit[nc][nr]) {
                                visit[nc][nr] = true
                                que.add(intArrayOf(nc, nr))
                            }
                        }
                    }
                    count++
                }
            }
        }
        answer = maxOf(answer, count)
    }
    println(answer)
}