import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

fun main() {
    val count = IntArray(10_001)

    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))
    for(i in 1..br.readLine().toInt()){
        count[br.readLine().toInt()]++
    }
    for(i in 1..10_000){
        repeat(count[i]){
            bw.write("$i")
            bw.newLine()
        }
    }
    bw.flush()
    br.close()
    bw.close()
}