fun main() {
    val (n, r, q) = readln().split(" ").map { it.toInt() }
    val graph = Array(n + 1) { mutableListOf<Int>() }
    for (i in 0 until n - 1) {
        val (u, v) = readln().split(" ").map { it.toInt() }
        graph[u].add(v)
        graph[v].add(u)
    }
    val targetUs = IntArray(q)
    for (i in 0 until q) {
        targetUs[i] = readln().toInt()
    }

    val tree = Array(n + 1) { mutableListOf<Int>() }

    fun makeTree(curNode: Int, prev: Int) {
        graph[curNode].forEach { node ->
            if (node != prev) {
                tree[curNode].add(node)
                makeTree(node, curNode)
            }
        }
    }

    val subTreeSize = IntArray(n + 1)
    fun countSubTree(curNode: Int): Int {
        if (subTreeSize[curNode] != 0) {
            return subTreeSize[curNode]
        }
        subTreeSize[curNode] = 1
        tree[curNode].forEach { child ->
            subTreeSize[curNode] += countSubTree(child)
        }
        return subTreeSize[curNode]
    }
    makeTree(r, 0)
    targetUs.forEach { u ->
        countSubTree(u)
        println(subTreeSize[u])
    }
}