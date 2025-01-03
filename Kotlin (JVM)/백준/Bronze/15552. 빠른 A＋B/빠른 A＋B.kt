import java.io.*

fun main() {
    val reader = BufferedReader(InputStreamReader(System.`in`))
    val writer = BufferedWriter(OutputStreamWriter(System.out))
    val n = reader.readLine().toInt()

    for (i in 1..n) {
        val input = reader.readLine().split(" ").map { it.toInt() }
        writer.write("${input[0] + input[1]}\n")

    }
    writer.flush()
    reader.close()
    writer.close()
}