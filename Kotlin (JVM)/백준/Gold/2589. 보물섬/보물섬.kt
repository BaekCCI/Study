fun main() {
    val (n, m) = readln().split(" ").map { it.toInt() }
    val map = Array(n){ readln().toCharArray() }

    val direction = arrayOf(intArrayOf(-1,0), intArrayOf(1,0), intArrayOf(0,-1), intArrayOf(0,1))


    fun isValidMove(x:Int, y:Int):Boolean{
        return x in 0 until n && y in 0 until m && map[x][y] == 'L'
    }
    fun bfs(startX:Int, startY:Int): Int{
        val que = ArrayDeque<IntArray>()
        val visit = Array(n){BooleanArray(m)}
        que.add(intArrayOf(startX,startY))
        visit[startX][startY] = true

        var dis = -1
        while(que.isNotEmpty()){
            val size = que.size
            for(i in 0 until size){
                val (x,y) = que.removeFirst()
                direction.forEach {
                    val nx = x+it[0]
                    val ny = y+it[1]
                    if(isValidMove(nx,ny) && !visit[nx][ny]){
                        visit[nx][ny] = true
                        que.add((intArrayOf(nx,ny)))
                    }
                }
            }
            dis++
        }
        return dis
    }
    var result = Int.MIN_VALUE
    for(i in 0 until n){
        for(j in 0 until m){
            if(map[i][j] =='W'){
                continue
            }
            result = maxOf(result, bfs(i,j))
        }
    }
    println(result)
}