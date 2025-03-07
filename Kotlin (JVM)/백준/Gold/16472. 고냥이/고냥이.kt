fun main() {
    val n = readln().toInt()
    val input = readln().toList()
    val count: MutableMap<Char, Int> = mutableMapOf()

    var l = 0
    var answer = 0
    for (r in input.indices) {
        count[input[r]] = count.getOrDefault(input[r], 0) + 1
        while (count.size > n) {
            count[input[l]] = count[input[l]]!! - 1
            if (count[input[l]] == 0) {
                count.remove(input[l])
            }
            l++
        }
        answer = maxOf(answer, r - l + 1)
    }
    println(answer)
}