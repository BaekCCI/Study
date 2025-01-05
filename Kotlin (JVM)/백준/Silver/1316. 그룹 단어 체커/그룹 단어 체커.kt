fun main() {
    val n = readln().toInt()
    val prev: MutableList<Char> = mutableListOf()
    var count = 0

    for( i in 1..n){
        val input = readln()
        var temp = input[0]
        for(j in 1..<input.length){
            if(input[j]==temp)continue
            else if(input[j]!=temp && prev.contains(input[j])){
                count--
                break
            }
            prev.add(temp)
            temp = input[j]
        }
        count++
        prev.clear()
    }
    println(count)
}