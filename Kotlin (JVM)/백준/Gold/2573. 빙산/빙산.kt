val direction = arrayOf(intArrayOf(0, 1), intArrayOf(0, -1), intArrayOf(1, 0), intArrayOf(-1, 0))
fun main() {

    val (n, m) = readln().split(" ").map { it.toInt() }
    val map = Array(n) { readln().split(" ").map { it.toInt() }.toIntArray() }


    fun countBlock(): Int {
        val visit = Array(n) { BooleanArray(m) }
        val que = ArrayDeque<IntArray>()

        var count = 0

        for (r in 0 until n) {
            for (c in 0 until m) {
                if (map[r][c] == 0 || visit[r][c]) continue

                visit[r][c] = true
                que.add(intArrayOf(r, c))

                while (que.isNotEmpty()) {
                    val (curR, curC) = que.removeFirst()
                    for (dir in direction) {
                        val nr = curR + dir[0]
                        val nc = curC + dir[1]
                        if (nr in 0 until n && nc in 0 until m && !visit[nr][nc] && map[nr][nc] > 0) {
                            visit[nr][nc] = true
                            que.add(intArrayOf(nr, nc))
                        }
                    }
                }
                count++
            }
        }
        return count
    }

    fun isAllMelted(): Boolean {
        for (r in 0 until n) {
            for (c in 0 until m) {
                if (map[r][c] > 0) return false
            }
        }
        return true
    }

    fun melt() {
        val meltMap = Array(n) { IntArray(m) }
        for (r in 0 until n) {
            for (c in 0 until m) {
                if (map[r][c] == 0) continue

                var count = 0
                for (dir in direction) {
                    val nr = r + dir[0]
                    val nc = c + dir[1]
                    if (nr in 0 until n && nc in 0 until m) {
                        if (map[nr][nc] == 0) {
                            count++
                        }
                    }
                }
                meltMap[r][c] = count
            }
        }
        for (r in 0 until n) {
            for (c in 0 until m) {
                map[r][c] = maxOf(map[r][c] - meltMap[r][c], 0)
            }
        }

    }

    var year = 0
    while (true) {
        //두덩어리 이상이면 return year
        if (countBlock() >= 2) {
            println(year)
            return
        }
        //전부 녹았으면 return 0
        if (isAllMelted()) {
            println(0)
            return
        }
        //녹이기
        melt()
        year++
    }
}