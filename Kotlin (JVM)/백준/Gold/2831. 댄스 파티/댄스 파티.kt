fun main() {
    val n = readln().toInt()
    val man = readln().split(" ").map { it.toInt() }
    val woman = readln().split(" ").map { it.toInt() }

    val mMinus = mutableListOf<Int>()
    val mPlus = mutableListOf<Int>()
    val wMinus = mutableListOf<Int>()
    val wPlus = mutableListOf<Int>()

    for (h in man) {
        if (h < 0) {
            mMinus.add(-h)
        } else {
            mPlus.add(h)
        }
    }
    for (h in woman) {
        if (h < 0) {
            wMinus.add(-h)
        } else {
            wPlus.add(h)
        }
    }
    mMinus.sort()
    mPlus.sort()
    wMinus.sort()
    wPlus.sort()

    //mMinus - wPlus / mPlus - wMinus

    var result = 0
    var m = 0
    var w = 0

    while (m < mMinus.size && w < wPlus.size) {
        if (mMinus[m] > wPlus[w]){
            result++
            m++
            w++
        }else{
            m++
        }
    }
    m = 0
    w = 0
    while (m < mPlus.size && w < wMinus.size) {
        if (mPlus[m] < wMinus[w]){
            result++
            m++
            w++
        }else{
            w++
        }
    }
    println(result)
}