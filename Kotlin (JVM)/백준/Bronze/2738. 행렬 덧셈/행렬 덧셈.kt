fun main() {
    val nm = readln().split(" ")
    val a: MutableList<MutableList<Int>> = MutableList(nm[0].toInt()) { MutableList(nm[1].toInt()) { 0 } }
    val b: MutableList<MutableList<Int>> = MutableList(nm[0].toInt()) { MutableList(nm[1].toInt()) { 0 } }
    a.forEach {
        val input = readln().split(" ").map { it.toInt() }
        for (i in it.indices) {
            it[i] = input[i]
        }
    }
    b.forEach {
        val input = readln().split(" ").map { it.toInt() }
        for (i in it.indices) {
            it[i] = input[i]
        }
    }
    for (i in a.indices) {
        for (j in a[i].indices) {
            a[i][j] += b[i][j]
        }
        println(a[i].joinToString (" "))
    }
}