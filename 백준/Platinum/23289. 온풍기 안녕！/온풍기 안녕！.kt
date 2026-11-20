val direction = arrayOf(intArrayOf(0, 1), intArrayOf(0, -1), intArrayOf(-1, 0), intArrayOf(1, 0))

fun main() {

    val (R, C, K) = readln().split(" ").map { it.toInt() }
    val room = Array(R) { IntArray(C) { 0 } }

    val checkRooms = mutableListOf<IntArray>()
    val machines = mutableListOf<IntArray>()

    repeat(R) { r ->
        val input = readln().split(" ").map { it.toInt() }
        for (c in 0 until C) {
            when (input[c]) {
                0 -> continue
                5 -> {
                    checkRooms.add(intArrayOf(r, c))
                }

                else -> {
                    machines.add(intArrayOf(r, c, input[c] - 1))
                }
            }
        }
    }

    val W = readln().toInt()
    val walls = Array(W) { Array(2) { IntArray(2) } }
    repeat(W) { i ->
        val (x, y, t) = readln().split(" ").map { it.toInt() }
        if (t == 0) { // x-1,y-1
            walls[i] = arrayOf(intArrayOf(x - 1, y - 1), intArrayOf(x - 2, y - 1))
        } else if (t == 1) {
            walls[i] = arrayOf(intArrayOf(x - 1, y - 1), intArrayOf(x - 1, y))
        }
    }


    var answer = 0

    fun canFlow(curR: Int, curC: Int, nextR: Int, nextC: Int): Boolean {
        if (nextR !in 0 until R || nextC !in 0 until C) return false

        walls.forEach { (room1, room2) ->
            if ((room1[0] == curR && room1[1] == curC && room2[0] == nextR && room2[1] == nextC)
                || (room1[0] == nextR && room1[1] == nextC && room2[0] == curR && room2[1] == curC)
            ) {
                return false
            }
        }
        return true
    }

    fun regulateTemp() {
        val tempRoom = Array(R) { IntArray(C) { 0 } }
        for (i in 0 until R) {
            for (j in 0 until C) {
                val curTemp = room[i][j]
                for ((dirR, dirC) in direction) {
                    val nR = i + dirR
                    val nC = j + dirC
                    if (canFlow(i, j, nR, nC)) {
                        val newTemp = room[nR][nC]

                        if (curTemp < newTemp) {
                            val diff = newTemp - curTemp
                            tempRoom[i][j] += diff / 4
                            tempRoom[nR][nC] -= diff / 4
                        }
                    }
                }

            }
        }

        for (i in 0 until R) {
            for (j in 0 until C) {
                room[i][j] += tempRoom[i][j]
            }
        }
    }


    val flowDirection = arrayOf(
        intArrayOf(2, 3), intArrayOf(2, 3), intArrayOf(0, 1), intArrayOf(0, 1)
    )

    fun runMachine() {
        for ((machineR, machineC, machineDir) in machines) {
            val startR = machineR + direction[machineDir][0]
            val startC = machineC + direction[machineDir][1]

            val que: ArrayDeque<IntArray> = ArrayDeque()
            val visited = Array(R) { BooleanArray(C) { false } }

            que.add(intArrayOf(startR, startC, 5))
            visited[startR][startC] = true
            room[startR][startC] += 5

            while (que.isNotEmpty()) {
                val (curR, curC, curTemp) = que.removeFirst()

                if (curTemp == 1) continue

                flowDirection[machineDir].forEach {
                    val nR = curR + direction[it][0]
                    val nC = curC + direction[it][1]

                    if (canFlow(curR, curC, nR, nC)) {
                        val newR = nR + direction[machineDir][0]
                        val newC = nC + direction[machineDir][1]

                        if (canFlow(nR, nC, newR, newC) && !visited[newR][newC]) {
                            visited[newR][newC] = true
                            room[newR][newC] += curTemp - 1

                            que.add(intArrayOf(newR, newC, curTemp - 1))
                        }
                    }
                }

                val nR = curR + direction[machineDir][0]
                val nC = curC + direction[machineDir][1]

                if (canFlow(curR, curC, nR, nC) && !visited[nR][nC]) {

                    visited[nR][nC] = true
                    room[nR][nC] += curTemp - 1
                    que.add(intArrayOf(nR, nC, curTemp - 1))
                }
            }
        }

    }

    fun check(): Boolean {
        for ((checkC, checkR) in checkRooms) {
            if (room[checkC][checkR] < K) return false
        }
        return true
    }
    while (true) {
        runMachine()
        regulateTemp()
        for (i in 0 until R) {
            if (room[i][0] > 0) room[i][0]--
            if (room[i][C - 1] > 0) room[i][C - 1]--
        }

        for (j in 1 until C - 1) {
            if (room[0][j] > 0) room[0][j]--
            if (room[R - 1][j] > 0) room[R - 1][j]--
        }
        answer++
        if (check() || answer > 100) break
    }
    println(answer)
}
