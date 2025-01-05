fun main() {
    val input = readln().uppercase()
    val count: MutableMap<Char, Int> = mutableMapOf()

    input.forEach {
        count[it] = count.getOrDefault(it, 0) + 1
    }
    val max = count.maxOf { it.value }
    var result = count.filter { it.value == max }
    if (result.size == 1) {
        println(result.keys.first())
    } else println("?")
}