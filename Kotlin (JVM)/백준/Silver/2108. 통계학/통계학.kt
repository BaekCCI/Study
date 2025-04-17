import kotlin.math.round

fun main() {
    val n = readln().toInt()
    val nums = IntArray(n)
    for (i in 0 until n) {
        nums[i] = readln().toInt()
    }
    val result = IntArray(4)
    result[0] = round(nums.sum().toDouble() / n).toInt()
    nums.sort()

    result[1] = nums[n / 2]
    val countNum = mutableMapOf<Int, Int>()
    for (i in 0 until n) {
        countNum[nums[i]] = countNum.getOrDefault(nums[i], 0) + 1
    }
    val max = countNum.maxOf { it.value }
    val modes = countNum.filter { it.value == max }.keys.sorted()
    result[2] = modes[0]
    if (modes.size > 1) {
        result[2] = modes[1]
    }
    result[3] = nums[n - 1] - nums[0]

    println(result.joinToString("\n"))
}