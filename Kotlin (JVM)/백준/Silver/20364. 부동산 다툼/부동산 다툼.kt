fun main() {
    val (n, q) = readln().split(" ").map { it.toInt() }
    val wanted = IntArray(q)
    for (i in 0 until q) {
        wanted[i] = readln().toInt()
    }
    val result = mutableSetOf<Int>()

    for (duck in wanted) {
        var index = duck
        var answer = 0
        while (index >= 1) {
            if (index in result) {
                answer = index
            }
            index/=2
        }
        if(answer == 0){
            result.add(duck)
        }
        println(answer)
    }
}