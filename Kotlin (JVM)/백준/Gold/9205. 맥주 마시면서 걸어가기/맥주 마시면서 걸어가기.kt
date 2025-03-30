import kotlin.math.*

fun main() {
    val t = readln().toInt()
    for (i in 0 until t) {
        val storeCount = readln().toInt()
        var home = readln().split(" ").map { it.toInt() }
        val stores = Array(storeCount) { IntArray(2) }
        for (count in 0 until storeCount) {
            stores[count] = readln().split(" ").map { it.toInt() }.toIntArray()
        }
        val (festivalX, festivalY) = readln().split(" ").map { it.toInt() }
        val que = ArrayDeque<IntArray>()
        que.add(home.toIntArray())
        val visitStore = BooleanArray(storeCount)
        var isHappy = "sad"
        while (que.isNotEmpty()) {
            val (curX, curY) = que.removeLast()

            if (abs(festivalX - curX) + abs(festivalY - curY) <= 1000) {
                isHappy = "happy"
                break
            }
            for (index in 0 until storeCount) {
                val (storeX, storeY) = stores[index]
                if (abs(storeX - curX) + abs(storeY - curY) <= 1000 && !visitStore[index]) {
                    visitStore[index] = true
                    que.add(intArrayOf(storeX, storeY))
                }
            }
        }
        println(isHappy)
    }
}