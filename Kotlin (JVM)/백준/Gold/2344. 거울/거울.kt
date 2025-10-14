fun main() {

    val (n, m) = readln().split(" ").map { it.toInt() }
    val map = Array(n) { readln().split(" ").map { it.toInt() }.toIntArray() }

    val direction =
        arrayOf(
            intArrayOf(-1, 0),
            intArrayOf(1, 0),
            intArrayOf(0, -1),
            intArrayOf(0, 1)
        )

    //상하좌우: 0,1,2,3
    fun changeDirection(dir: Int): Int {
        return when (dir) {
            0 -> 3 //up -> right
            1 -> 2 //down -> left
            2 -> 1 //left -> down
            3 -> 0 //right -> up
            else -> 0
        }
    }

    fun play(sr:Int, sc:Int, sDir : Int):Int{
        var curR = sr
        var curC = sc
        var dir = sDir

        while(true){

            curR+=direction[dir][0]
            curC+=direction[dir][1]

            if (curR !in 0 until n) {
                if (curR == -1) { //위로 탈출
                    return 2 * (n + m) - curC
                }
                if (curR == n) { //아래로 탈출
                    return n + curC + 1
                }
            }else if(curC !in 0 until m){
                if (curC == -1) { //왼쪽으로 탈출
                    return curR + 1
                }
                if (curC == m) { //오른쪽으로 탈출
                    return 2 * n + m - curR
                }
            }

            if(map[curR][curC] == 1){
                dir = changeDirection(dir)
            }
        }
    }

    val result = IntArray(n * 2 + m * 2 + 1)

    for (i in 0 until n) {
        //왼쪽에서 시작
        val lResult = play(i, -1, 3)
        result[i + 1] = lResult
        //오른쪽에서 시작
        val rResult = play(i, m, 2)
        result[2 * n + m - i] = rResult
    }

    for (j in 0 until m) {
        //아래에서 시작
        val downResult = play(n, j, 0)
        result[n + j + 1] = downResult

        //위에서 시작
        val upResult = play(-1, j, 1)
        result[2 * (n + m) - j] = upResult
    }
    println(result.drop(1).joinToString(" "))
}
