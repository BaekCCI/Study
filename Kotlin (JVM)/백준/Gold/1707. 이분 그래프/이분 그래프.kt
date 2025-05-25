fun main() {
    val k = readln().toInt()
    repeat(k) {
        val (V, E) = readln().split(" ").map { it.toInt() }
        val nodes = Array(V + 1) { mutableListOf<Int>() }

        for (i in 0 until E) {
            val (u, v) = readln().split(" ").map { it.toInt() }
            nodes[u].add(v)
            nodes[v].add(u)
        }
        val check = IntArray(V + 1) { 0 }


        var flag = true
        for (s in 1..V) {
            if (check[s] != 0) continue

            val que = ArrayDeque<Int>()
            que.add(s)
            check[s] = 1

            while (que.isNotEmpty() && flag) {
                val curN = que.removeFirst()

                val curColor = check[curN]
                for (next in nodes[curN]) {
                    if (check[next] == 0) {
                        check[next] = -curColor
                        que.add(next)
                    } else if (check[next] == curColor) {
                        flag = false
                    }
                }
            }
            if (!flag) break
        }
        println(if (flag) "YES" else "NO")
    }
}