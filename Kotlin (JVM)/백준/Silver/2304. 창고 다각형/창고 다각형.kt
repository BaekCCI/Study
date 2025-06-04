fun main() {
    val n = readln().toInt()

    var walls = mutableMapOf<Int, Int>()
    for (i in 0 until n) {
        val (l, h) = readln().split(" ").map { it.toInt() }
        walls[l] = h
    }
    walls = walls.toSortedMap()

    val maxH = walls.maxBy { it.value }
    val maxL = maxH.key

    var area = 0

    val stack = ArrayDeque<IntArray>()
    for ((l, h) in walls) {
        if (l == maxL) {
            if (stack.isNotEmpty()) {
                val (lastL, lastH) = stack.removeLast()
                area += (l - lastL) * lastH
            }
            break
        }
        if (stack.isEmpty()) {
            stack.add(intArrayOf(l, h))
        } else if (stack.last()[1] < h) {
            val (lastL, lastH) = stack.removeLast()
            area += (l - lastL) * lastH
            stack.add(intArrayOf(l, h))
        }
    }
    for ((l, h) in walls.entries.reversed()) {
        if (l == maxL) {
            if (stack.isNotEmpty()) {
                val (lastL, lastH) = stack.removeLast()
                area += (lastL - l) * lastH
            }
            break
        }
        if (stack.isEmpty()) {
            stack.add(intArrayOf(l, h))
        } else if (stack.last()[1] < h) {
            val (lastL, lastH) = stack.removeLast()
            area += (lastL - l) * lastH
            stack.add(intArrayOf(l, h))
        }
    }
    area += maxH.value
    println(area)
}