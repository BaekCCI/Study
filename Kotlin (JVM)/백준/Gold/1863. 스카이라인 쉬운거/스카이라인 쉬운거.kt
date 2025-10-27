fun main() {
    val n = readln().toInt()
    val coordinates = Array(n) { readln().split(" ").map { it.toInt() } }

    val stack = ArrayDeque<Int>()

    var result = 0
    for ((x, y) in coordinates) {
        if (stack.isEmpty()) {
            stack.addLast(y)
            continue
        }
        while (stack.isNotEmpty() && y < stack.last()) {
            stack.removeLast()
            result++
        }
        if (stack.isEmpty() || stack.last() < y) {
            stack.addLast(y)
        }
    }
    while (stack.isNotEmpty()) {
        if (stack.removeLast() != 0) result++
    }
    println(result)
}