fun main() {
    val (n, k) = readln().split(" ").map { it.toInt() }
    val numbers = readln().split(" ").map { it.toInt() }

    val numCount: MutableMap<Int, Int> = mutableMapOf()
    var l = 0
    var answer = 0
    for (r in 0 until n) {
        numCount[numbers[r]] = numCount.getOrDefault(numbers[r], 0) + 1
        while(numCount[numbers[r]]!! > k){
            numCount[numbers[l]] = numCount[numbers[l]]!! - 1
            l++
        }
        answer = maxOf(answer, r - l + 1)
    }
    println(answer)
}