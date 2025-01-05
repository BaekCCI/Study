fun main() {
    val matrix: MutableList<MutableList<Char>> = MutableList(5) { mutableListOf() }

    for (i in matrix.indices) {
        val input = readln()
        input.forEach {
            matrix[i].add(it)
        }
    }

    for (i in 0..14) {
        for (j in matrix.indices) {
            if(matrix[j].size>i){
                print(matrix[j][i])
            }
        }
    }
}