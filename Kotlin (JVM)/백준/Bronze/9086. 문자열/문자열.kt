fun main() {
    val n = readln().toInt()
    val strings : MutableList<String> = mutableListOf()
    for(i in 1..n){
        strings.add(readln())
    }
    strings.forEach {
        println("${it.first()}${it.last()}")
    }
}