fun main() {
    val g = readln().toLong()

    //현재 몸무게 제곱 - 기억 몸무게 제곱 = g

    var l = 1L //기억
    var r = 2L //현재

    val result = mutableListOf<Long>()
    while (l < r) {

        val minus = r * r - l * l

        if (minus < g) {
            r++
            continue
        }
        if (minus > g) {
            l++
            continue
        }
        result.add(r)
        r++
    }
    if(result.isEmpty()){
        println(-1)
    }else{
        println(result.joinToString("\n"))   
    }
}