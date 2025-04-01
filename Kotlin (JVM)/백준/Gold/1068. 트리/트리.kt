fun main() {
    val n = readln().toInt()
    val tree: MutableMap<Int, MutableList<Int>> = mutableMapOf()

    val input = readln().split(" ").map { it.toInt() }

    val target = readln().toInt()
    var root = -1
    for (i in 0 until n) {
        val parent = input[i]
        if (parent == -1) {
            root = i
        } else {
            tree.computeIfAbsent(parent) { mutableListOf() }.add(i)
        }
    }
    if (root == target) {
        println(0)
        return
    }
    fun removeNode(target: Int) {
        for ((key, value) in tree) {
            value.remove(target)
        }
        tree[target]?.forEach {
            removeNode(it)
        }
        tree.remove(target)
    }
    removeNode(target)

    var count = 0

    fun countLeaf(node: Int) {
        if (!tree.containsKey(node) || tree[node]!!.isEmpty()) {
            count++
        } else {
            tree[node]!!.forEach {
                countLeaf(it)
            }
        }
    }
    countLeaf(root)
    println(count)
}