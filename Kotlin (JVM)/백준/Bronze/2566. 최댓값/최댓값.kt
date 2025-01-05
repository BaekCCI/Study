fun main() {
    val matrix: MutableList<MutableList<Int>> = MutableList(9) { MutableList(9) { 0 } }

    matrix.forEach {
        val input = readln().split(" ").map { it.toInt() }
        for (i in it.indices) {
            it[i] = input[i]
        }
    }
    var row = 1
    var column = 1
    val max = matrix.maxOf { it.max() }
    for(i in matrix.indices){
        for (j in matrix[i].indices){
            if(matrix[i][j]==max){
                row = i+1
                column= j+1
            }
        }
    }
    println(max)
    println("$row $column")
}