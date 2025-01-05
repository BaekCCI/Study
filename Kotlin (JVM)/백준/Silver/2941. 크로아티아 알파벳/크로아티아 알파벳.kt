fun main() {
    val alphabet = listOf("c=", "c-", "dz=", "d-", "lj", "nj", "s=", "z=")
    var input = readln()
    alphabet.forEach {
        input = input.replace(it,"*")
    }
    println(input.length)
}