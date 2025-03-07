fun main() {
    val n = readln().toInt()
    val m = readln().toInt()
    val graph : MutableMap<Int, MutableList<Int>> = mutableMapOf()

    for (i in 0 until m) {
        val input = readln().split(" ").map { it.toInt() }
        graph.getOrPut(input[0]-1){ mutableListOf() }.add(input[1]-1)
        graph.getOrPut(input[1]-1){ mutableListOf() }.add(input[0]-1)
    }
    val que = ArrayDeque<Int>()
    que.add(0)
    val visit = BooleanArray(n)
    visit[0] = true
    while(que.isNotEmpty()){
        val num = que.removeFirst()

        graph[num]?.forEach {
            if(!visit[it]){
                visit[it] = true
                que.add(it)
            }
        }
    }
    println(visit.filter { it }.size-1)
}
