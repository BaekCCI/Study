fun main() {
    val n = readln().toInt()
    val nums = readln().split(" ").map { it.toInt() }.toMutableSet()
    val m = readln().toInt()
    val input = readln().split(" ").map { if (nums.contains(it.toInt())) 1 else 0 }
    println(input.joinToString(" "))
}