class Solution {
    fun solution(numbers: IntArray): String {
        
    val nums = numbers.map { it.toString() }.sortedWith { a, b ->
        (b + a).compareTo(a + b)
    }.joinToString("")

    if(nums.startsWith('0')) return "0"
    return nums
    }
}