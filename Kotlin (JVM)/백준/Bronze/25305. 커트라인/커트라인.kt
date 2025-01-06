fun main() {
    val nk = readln().split(" ").map{it.toInt()}
    val score = readln().split(" ").map{it.toInt()}.sorted()
    println(score[nk[0]-nk[1]])
}
