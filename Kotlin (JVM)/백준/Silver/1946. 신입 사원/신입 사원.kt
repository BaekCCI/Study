fun main() {
    val t = readln().toInt()
    repeat(t) {
        val n = readln().toInt()
        val score = Array(n) { readln().split(" ").map { it.toInt() } }
        score.sortBy { it.first() }

        var b= score[0][1]
        var result = 1

        for (i in 1 until n) {
            val curB = score[i][1]

            if (curB < b) {
                result++
                b = curB
            }
        }
        println(result)
    }
}