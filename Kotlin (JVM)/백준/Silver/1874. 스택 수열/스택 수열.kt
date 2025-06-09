fun main() {
    val n = readln().toInt()

    val nums = IntArray(n) { readln().toInt() }

    val stack = ArrayDeque<Int>()
    var cur = 0
    val result = mutableListOf<Char>()
    for (i in 1..n) {
        if (stack.isEmpty()) {
            stack.add(i)
            result.add('+')
            continue
        }
        while (stack.isNotEmpty() && stack.last() == nums[cur]) {
            stack.removeLast()
            result.add('-')
            cur++
        }
        stack.add(i)
        result.add('+')
    }
    while(stack.isNotEmpty() && stack.last() == nums[cur]){
        stack.removeLast()
        result.add('-')
        cur++
    }
    if(stack.isNotEmpty()){
        println("NO")
        return
    }
    println(result.joinToString("\n"))
}