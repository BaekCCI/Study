fun main() {
    val numbers: MutableList<Int> = mutableListOf()
    for (i in 1..9) {
        numbers.add(readln().toInt())
    }
    val max = numbers.max()
    val index = numbers.indexOf(max)

    println(max)
    println(index+1)
}