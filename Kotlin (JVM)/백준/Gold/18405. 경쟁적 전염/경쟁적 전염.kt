val direction = arrayOf(intArrayOf(1, 0), intArrayOf(-1, 0), intArrayOf(0, 1), intArrayOf(0, -1))

fun main() {
    val (n, k) = readln().split(" ").map { it.toInt() }

    val map = Array(n) { readln().split(" ").map { it.toInt() }.toIntArray() }

    val (s, x, y) = readln().split(" ").map { it.toInt() }

    val virusLoc = Array(k + 1) { mutableListOf<IntArray>() }
    for (r in 0 until n) {
        for (c in 0 until n) {
            val cur = map[r][c]
            if (cur != 0) {
                virusLoc[cur].add(intArrayOf(r, c))
            }
        }
    }
    val que = ArrayDeque<IntArray>()
    val visit = Array(n) { BooleanArray(n) }
    for (v in 1..k) {
        virusLoc[v].forEach { (r, c) ->
            if (r == x - 1 && c == y - 1) {
                println(v)
                return
            }
            que.add(intArrayOf(r, c, v))
            visit[r][c] = true
        }
    }
    var time = 0
    while (time < s && que.isNotEmpty()) {
        val size = que.size

        repeat(size) {
            val (r, c, v) = que.removeFirst()
            for (dir in direction) {
                val nr = r + dir[0]
                val nc = c + dir[1]
                if (nr in 0 until n && nc in 0 until n && !visit[nr][nc]) {
                    if (nr == x - 1 && nc == y - 1) {
                        println(v)
                        return
                    }
                    que.add(intArrayOf(nr, nc, v))
                    visit[nr][nc] = true
                }
            }
        }
        time++
    }
    println(0)
}