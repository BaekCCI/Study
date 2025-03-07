fun main() {
    val n = readln().toInt()
    val nums = readln().split(" ").map { it.toInt() }.sorted()
    val x = readln().toInt()

    var l = 0
    var r = n - 1

    var answer = 0
    while (l < r) {
        var sum = nums[l] + nums[r]

        if (sum < x) {
            l++
        } else if (sum > x) {
            r--
        } else {
            l++
            r--
            answer++
        }
    }
    println(answer)
}