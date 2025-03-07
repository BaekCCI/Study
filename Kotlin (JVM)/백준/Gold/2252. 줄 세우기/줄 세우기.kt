fun main() {
    val (n, m) = readln().split(" ").map { it.toInt() }
    val graph: MutableMap<Int, MutableList<Int>> = mutableMapOf()
    val count: MutableMap<Int, Int> = mutableMapOf()
    for (i in 1..n) {
        count[i] = 0
    }

    for (i in 0 until m) {
        val (a, b) = readln().split(" ").map { it.toInt() }
        graph.getOrPut(a) { mutableListOf() }.add(b)
        count[b] = count[b]!! + 1
    }
    val que = ArrayDeque<Int>()
    count.forEach {
        if (it.value == 0) {
            que.add(it.key)
        }
    }
    val result = mutableListOf<Int>()
    while (que.isNotEmpty()) {
        val value = que.removeFirst()
        result.add(value)

        graph[value]?.forEach {
            count[it] = count[it]!! - 1
            if(count[it] == 0 ){
                que.add(it)
            }
        }
    }
    println(result.joinToString(" "))
}