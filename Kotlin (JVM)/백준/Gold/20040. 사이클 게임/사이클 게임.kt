fun main() {
    val (n, m) = readln().split(" ").map { it.toInt() }
    val nodes = IntArray(n) { it }

    fun find(x: Int): Int {
        if (nodes[x] != x) {
            nodes[x] = find(nodes[x])
        }
        return nodes[x]
    }

    fun union(x: Int, y: Int) {
        val rootX = find(x)
        val rootY = find(y)

        if (rootX != rootY) {
            nodes[rootY] = rootX
        }
    }

    var count = 0
    var result = 0

    for (i in 0 until m) {
        count++
        val (x, y) = readln().split(" ").map { it.toInt() }
        if (find(x) == find(y) && result == 0) {
            result = count
        }
        union(x, y)
    }
    println(result)
}