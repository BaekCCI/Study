fun main() {
    val (r, c, t) = readln().split(" ").map { it.toInt() }
    val graph = Array(r) { IntArray(c) }

    for (i in 0 until r) {
        graph[i] = readln().split(" ").map { it.toInt() }.toIntArray()
    }
    var cleaner = 0
    for (i in 0 until r) {
        if (graph[i][0] == -1) {
            cleaner = i
            break
        }
    }
    val direction = arrayOf(intArrayOf(1, 0), intArrayOf(-1, 0), intArrayOf(0, 1), intArrayOf(0, -1))

    fun isValidIndex(x: Int, y: Int): Boolean {
        return x in 0 until r && y in 0 until c && graph[x][y] != -1
    }

    fun dustSpread() {
        val changedDust = Array(r) { IntArray(c) }
        for (i in 0 until r) {
            for (j in 0 until c) {
                if (graph[i][j] == 0 || graph[i][j] == -1) {
                    continue
                }
                direction.forEach {
                    val nx = i + it[0]
                    val ny = j + it[1]
                    if (isValidIndex(nx, ny)) {
                        changedDust[i][j] -= graph[i][j] / 5
                        changedDust[nx][ny] += graph[i][j] / 5
                    }
                }
            }
        }
        for (i in 0 until r) {
            graph[i] = graph[i].zip(changedDust[i]) { a, b -> a + b }.toIntArray()
        }
    }

    fun dustMachine1(machine: Int) {
        var temp = 0
        for (j in 1 until c) {
            val cur = graph[machine][j]
            graph[machine][j] = temp
            temp = cur
        }
        for (i in machine - 1 downTo 0) {
            val cur = graph[i][c - 1]
            graph[i][c - 1] = temp
            temp = cur
        }
        for (j in c - 2 downTo 0) {
            val cur = graph[0][j]
            graph[0][j] = temp
            temp = cur
        }
        for (i in 1 until machine) {
            val cur = graph[i][0]
            graph[i][0] = temp
            temp = cur
        }
    }

    fun dustMachine2(machine: Int) {
        var temp = 0
        for (j in 1 until c) {
            val cur = graph[machine][j]
            graph[machine][j] = temp
            temp = cur
        }
        for (i in machine + 1 until r) {
            val cur = graph[i][c - 1]
            graph[i][c - 1] = temp
            temp = cur
        }
        for (j in c - 2 downTo 0) {
            val cur = graph[r - 1][j]
            graph[r - 1][j] = temp
            temp = cur
        }
        for (i in r - 2 downTo machine + 1) {
            val cur = graph[i][0]
            graph[i][0] = temp
            temp = cur
        }
    }
    for (i in 0 until t) {
        dustSpread()
        dustMachine1(cleaner)
        dustMachine2(cleaner + 1)
    }
    println(graph.sumOf { it.sum() } + 2)
}