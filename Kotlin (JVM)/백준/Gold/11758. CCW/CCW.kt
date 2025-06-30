fun main() {
    val (x1, y1) = readln().split(" ").map { it.toInt() }
    val (x2, y2) = readln().split(" ").map { it.toInt() }
    val (x3, y3) = readln().split(" ").map { it.toInt() }

    val vx1 = x2 - x1
    val vy1 = y2 - y1
    val vx2 = x3 - x2
    val vy2 = y3 - y2

    val dir = vx1 * vy2 - vy1 * vx2

    if (dir == 0) {
        println(0)
    } else if (dir < 0) {
        println(-1)
    } else {
        println(1)
        return
    }
}