fun main() {
    val (n,m) = readln().split(" ").map{it.toInt()}
    val graph : MutableMap<Int,MutableList<Int>> = mutableMapOf()

    for(i in 0 until m){
        val input = readln().split(" ").map{it.toInt()}
        graph.getOrPut(input[0]){ mutableListOf() }.add(input[1])
    }
    val s = readln().toInt()
    val gom = readln().split(" ").map{it.toInt()}

    if(gom.contains(1)){
        println("Yes")
        return
    }
    val que = ArrayDeque<Int>()
    que.add(1)
    while(que.isNotEmpty()){
        val node = que.removeFirst()

        if(!graph.containsKey(node)){
            if(!gom.contains(node)){
                println("yes")
                return
            }
        }
        graph[node]?.forEach {
            if(!gom.contains(it)){
                que.add(it)
            }
        }
    }
    println("Yes")
}