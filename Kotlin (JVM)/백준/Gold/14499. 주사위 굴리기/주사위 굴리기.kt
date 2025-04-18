
val direction = arrayOf(intArrayOf(0, 1), intArrayOf(0, -1), intArrayOf(-1, 0), intArrayOf(1, 0))
fun main() {
    val (n, m, x, y, k) = readln().split(" ").map { it.toInt() }


    val map = Array(n) { IntArray(m) }
    for (i in 0 until n) {
        map[i] = readln().split(" ").map { it.toInt() }.toIntArray()
    }
    val commands = readln().split(" ").map { it.toInt() }

    //위:0, 아래:1, 앞:2, 오:3, 뒤: 4, 왼:5
    val dice = IntArray(6)
    fun goUp() {
        val top = dice[0]
        val bottom = dice[1]
        val front = dice[2]
        val back = dice[4]

        dice[0] = front
        dice[1] = back
        dice[2] = bottom
        dice[4] = top
    }

    fun goDown() {
        val top = dice[0]
        val bottom = dice[1]
        val front = dice[2]
        val back = dice[4]

        dice[0] = back
        dice[1] = front
        dice[2] = top
        dice[4] = bottom
    }

    fun goLeft() {
        val top = dice[0]
        val right = dice[3]
        val bottom = dice[1]
        val left = dice[5]

        dice[0] = left
        dice[3] = top
        dice[1] = right
        dice[5] = bottom
    }

    fun goRight() {
        val top = dice[0]
        val right = dice[3]
        val bottom = dice[1]
        val left = dice[5]

        dice[0] = right
        dice[3] = bottom
        dice[1] = left
        dice[5] = top
    }

    var curC = x
    var curR = y
    for (command in commands) {
        val tempC = curC + direction[command - 1][0]
        val tempR = curR + direction[command - 1][1]
        if (tempC in 0 until n && tempR in 0 until m) {
            when (command) {
                1 -> goRight()
                2 -> goLeft()
                3 -> goUp()
                4 -> goDown()
            }
            curC = tempC
            curR = tempR

            if (map[curC][curR] == 0) {
                map[curC][curR] = dice[1]
            } else {
                dice[1] = map[curC][curR]
                map[curC][curR] = 0
            }
            println(dice[0])
        }
    }
}