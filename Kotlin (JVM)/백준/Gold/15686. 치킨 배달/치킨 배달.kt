import kotlin.math.abs
fun main() {
    val (n, m) = readln().split(" ").map { it.toInt() }
    val chicken: MutableList<IntArray> = mutableListOf()
    val homes: MutableList<IntArray> = mutableListOf()
    val map = Array(n) { IntArray(n) }
    for (i in 0 until n) {
        map[i] = readln().split(" ").map { it.toInt() }.toIntArray()
        for (j in 0 until n) {
            if (map[i][j] == 2) {
                chicken.add(intArrayOf(i, j))
            } else if (map[i][j] == 1) {
                homes.add(intArrayOf(i, j))
            }
        }
    }
    var answer = Int.MAX_VALUE

    fun getDistance(stores: MutableList<IntArray>):Int {
        var sum = 0
        homes.forEach { home ->
            var dis = Int.MAX_VALUE
            stores.forEach { store->
                val calculate = abs(home[0]-store[0])+abs(home[1]-store[1])
                dis = minOf(calculate, dis)
            }
            sum+=dis
        }
        return sum
    }
    fun combi(idx: Int, depth: Int, result: MutableList<IntArray>) {

        if (depth == m) {
            answer = minOf(answer, getDistance(result))
            return
        }

        for (i in idx until chicken.size) {
            result.add(chicken[i])
            combi(i + 1, depth + 1, result)
            result.removeLast()
        }
    }
    if (chicken.size <= m) {
        answer = getDistance(chicken)
    } else {
        combi(0,0, mutableListOf())
    }
    println(answer)
}