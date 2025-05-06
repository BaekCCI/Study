val direction = arrayOf(intArrayOf(0, -1), intArrayOf(0, 1), intArrayOf(1, 0), intArrayOf(-1, 0))
fun main() {
    val (R, C, M) = readln().split(" ").map { it.toInt() }
    var sharks = Array(C) { Array(R) { IntArray(3) } }

    for (i in 0 until M) {
        val (r, c, s, d, z) = readln().split(" ").map { it.toInt() }
        sharks[c - 1][r - 1] = intArrayOf(s, d - 1, z)
    }
    fun reverseDirection(dir: Int): Int {
        return when (dir) {
            0 -> 1
            1 -> 0
            2 -> 3
            3 -> 2
            else -> dir
        }
    }

    fun swimShark() {
        val resultMap = Array(C) { Array(R) { IntArray(3) } }
        for (i in 0 until C) {
            for (j in 0 until R) {
                val curShark = sharks[i][j]
                if (!curShark.contentEquals(intArrayOf(0, 0, 0))) {
                    val speed = curShark[0]
                    var dir = curShark[1]
                    val size = curShark[2]

                    var curC = i
                    var curR = j

                    var remain = speed
                    while (remain > 0) {
                        if (dir == 2 || dir == 3) {
                            var nc = curC + remain * direction[dir][0]

                            if (nc !in 0 until C) {
                                if (nc < 0) {
                                    remain -= curC
                                    curC = 0
                                } else {
                                    remain -= C - curC - 1
                                    curC = C - 1
                                }
                                dir = reverseDirection(dir)
                            } else {
                                remain -= speed
                                curC = nc
                            }
                        }
                        if (dir == 0 || dir == 1) {
                            var nr = curR + remain * direction[dir][1]

                            if (nr !in 0 until R) {
                                if (nr < 0) {
                                    remain -= curR
                                    curR = 0
                                } else {
                                    remain -= R - curR - 1
                                    curR = R - 1
                                }
                                dir = reverseDirection(dir)
                            } else {
                                remain -= speed
                                curR = nr
                            }
                        }
                    }
                    if (resultMap[curC][curR][2] < size) {
                        resultMap[curC][curR] = intArrayOf(speed, dir, size)
                    }
                }
            }
        }
        sharks = resultMap
    }

    var sum = 0
    for (index in 0 until C) {
        for (j in 0 until R) {
            if (!sharks[index][j].contentEquals(intArrayOf(0, 0, 0))) {
                sum += sharks[index][j][2]
                sharks[index][j] = intArrayOf(0, 0, 0)
                break
            }
        }
        swimShark()
    }
    println(sum)
}