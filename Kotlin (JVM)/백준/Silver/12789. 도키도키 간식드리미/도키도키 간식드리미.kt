fun main() {
    val n = readln().toInt()
    val student = readln().split(" ").map { it.toInt() }
    val stack = ArrayDeque<Int>()

    var index = 1
    for(i in 0 until n){
        stack.addLast(student[i])
        while(stack.isNotEmpty()){
            if(stack.last() == index){
                index++
                stack.removeLast()
            }else{
                break
            }
        }
    }
    if(stack.isEmpty()){
        println("Nice")
    }else{
        println("Sad")
    }
}