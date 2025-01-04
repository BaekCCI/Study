fun main() {
    val input = readln().toList()
    var result = 0
    input.forEach {
        result += when (it) {
            '1' -> 0
            in 'A'..'C' -> 1
            in 'D'..'F' -> 2
            in 'G'..'I' -> 3
            in 'J'..'L' -> 4
            in 'M'..'O' -> 5
            in 'P'..'S' -> 6
            in 'T'..'V' -> 7
            in 'W'..'Z' -> 8
            else -> 9
        }
    }
    println(input.size * 2 + result)

}