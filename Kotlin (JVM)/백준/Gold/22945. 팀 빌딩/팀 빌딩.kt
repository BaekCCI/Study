fun main() {
    val n = readln().toLong()
    val abilities = readln().split(" ").map { it.toInt() }

    var l = 0
    var r = abilities.size - 1

    var result = 0
    while (l < r) {

        val team = (r - l - 1) * minOf(abilities[l], abilities[r])
        result = maxOf(team, result)

        if (abilities[l] < abilities[r]) {
            l++
        } else {
            r--
        }
    }
    println(result)
}