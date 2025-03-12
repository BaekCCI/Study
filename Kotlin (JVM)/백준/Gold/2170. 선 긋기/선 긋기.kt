import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))

    val n = br.readLine().toInt()
    val lines = Array(n) {
        br.readLine().split(" ").map { it.toInt() }
    }.sortedBy { it[0] }
    var length = 0
    var s = lines[0][0]
    var e = lines[0][1]
    for (i in lines.indices) {
        val (start, end) = lines[i]
        if (end < e) {
            continue
        }
        if (start <= e && end > e) {
            length += end - e
            e = end
        } else if (e < start) {
            length += end - start
            s = start
            e = end
        } else {
            length = e - s
        }
    }
    println(length)
}
