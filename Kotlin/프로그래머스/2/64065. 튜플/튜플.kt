class Solution {
    fun solution(s: String): IntArray {
        var answer = intArrayOf()
        var split = s.split("},").map { it.replace("{", "").replace("}", "") }.map{it.split(",").map{it.toInt()}.toSet()}
        var tuple : MutableSet<Int> = mutableSetOf()
        split=split.sortedBy { it.size }
        split.forEach {
            tuple.addAll(it)
        }
        answer = tuple.toIntArray()
        return answer
    }
}