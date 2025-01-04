fun main() {
    val n = readln().toInt()
    val score = readln().split(" ").map { it.toInt() }

    val max = score.max()
    val avg = score.sum().toDouble() / max * 100 / n

    println(avg)
}