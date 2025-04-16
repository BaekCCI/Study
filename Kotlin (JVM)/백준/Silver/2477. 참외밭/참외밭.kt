fun main() {
    val k = readln().toInt()
    val map = Array(6) { IntArray(2) }

    var longCol = 0
    var longRow = 0
    for (i in 0 until 6) {
        map[i] = readln().split(" ").map { it.toInt() }.toIntArray()
        if (map[i][0] == 1 || map[i][0] == 2) {
            longRow = maxOf(longRow, map[i][1])
        } else {
            longCol = maxOf(longCol, map[i][1])
        }
    }

    var area = longCol * longRow

    for (i in map.indices) {
        if (map[i][0] == map[(i + 2) % 6][0] && map[(i+1)%6][0] == map[(i+3)%6][0]){
            area -= map[(i+1)%6][1] * map[(i+2)%6][1]
            break
        }
    }
    println(area * k)
}