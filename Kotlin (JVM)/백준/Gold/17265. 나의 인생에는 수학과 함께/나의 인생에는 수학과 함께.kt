fun main() {
    val n = readln().toInt()
    val map = Array(n) { readln().split(" ")}

    val direction = arrayOf(intArrayOf(1, 0), intArrayOf(0, 1))

    var minResult = Int.MAX_VALUE
    var maxResult = Int.MIN_VALUE

    fun operate(ln: Int, rn: Int, operator: String): Int {
        return when (operator) {
            "+" -> ln + rn
            "-" -> ln - rn
            "*" -> ln * rn
            else -> 0
        }
    }

    fun dfs(c: Int, r: Int, curResult: Int) {
        if (c == n - 1 && r == n - 1) {
            minResult = minOf(minResult, curResult)
            maxResult = maxOf(maxResult, curResult)
            return
        }
        for(dir1 in direction) {
            var nc1 = c + dir1[0]
            var nr1 = r + dir1[1]

            if (nc1 in 0 until n && nr1 in 0 until n) {
                val operator = map[nc1][nr1]
                for(dir2 in direction){
                    var nc2 = nc1 + dir2[0]
                    var nr2 = nr1 + dir2[1]
                    if (nc2 in 0 until n && nr2 in 0 until n) {
                        dfs(nc2, nr2, operate(curResult, map[nc2][nr2].toInt(), operator))
                    }
                }
            }
        }
    }
    dfs(0, 0, map[0][0].toInt())
    println("$maxResult $minResult")
}