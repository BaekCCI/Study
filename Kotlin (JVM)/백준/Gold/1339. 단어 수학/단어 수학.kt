import kotlin.math.pow

fun main() {
    val n = readln().toInt()
    val numbers = Array(n) { listOf<Char>() }
    val count = mutableMapOf<Char, Int>()
    for (i in 0 until n) {
        numbers[i] = readln().toCharArray().toList()
        val temp = numbers[i]
        for (j in temp.indices) {
            count[temp[j]] = count.getOrDefault(temp[j], 0) + 10.0.pow(temp.size - j - 1).toInt()
        }
    }
    val sortedCount = count.entries.sortedByDescending { it.value }.associate { it.key to it.value }.toMutableMap()
    var num = 9

    sortedCount.forEach {
        sortedCount[it.key] = num
        num--
    }
    var result = 0
    numbers.forEach {word->
        for(i in word.indices){
            result += sortedCount[word[i]]!! * 10.0.pow(word.size-i-1).toInt()
        }
    }
    println(result)
}