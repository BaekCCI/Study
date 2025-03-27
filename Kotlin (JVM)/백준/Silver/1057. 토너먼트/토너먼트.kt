import kotlin.math.*

fun main() {
    var (n, kim, im) = readln().split(" ").map { it.toInt() }

    val round = ceil(log2(n.toDouble())).toInt()

    var answer = 1

    while(answer<=round){
        kim = ceil(kim / 2.0).toInt()
        im =ceil(im /2.0).toInt()

        if(kim == im){
            println(answer)
            return
        }
        answer++
    }
    println(-1)
}