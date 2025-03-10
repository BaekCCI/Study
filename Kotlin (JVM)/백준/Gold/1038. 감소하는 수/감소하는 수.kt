fun main() {
    val n = readln().toInt()

    if (n <= 10) {
        println(n)
        return
    }
    if (n > 1022) {
        println(-1)
        return
    }
    val nums = mutableListOf<Long>()

    fun play(num: Long, lastNum: Int) {
        if (lastNum > 10) {
            return
        }
        nums.add(num)
        for (i in 0 until num % 10) {
            play(num * 10 + i, lastNum + 1)
        }
    }
    for (i in 0 until 10) {
        play(i.toLong(),0)
    }
    nums.sort()
    println(nums[n])
}