fun main() {
    val t = readln().toInt()

    repeat(t) {
        startCubing()
    }
}

fun startCubing() {
    val n = readln().toInt()
    val cubing = readln().split(" ").map { it.toCharArray() }

    val cube = arrayOf(
        Array(3) { CharArray(3) { 'w' } },
        Array(3) { CharArray(3) { 'y' } },
        Array(3) { CharArray(3) { 'r' } },
        Array(3) { CharArray(3) { 'o' } },
        Array(3) { CharArray(3) { 'g' } },
        Array(3) { CharArray(3) { 'b' } },
    )

    fun rotateSurface(surface: Int, dir: Char) {
        val rotated = Array(3) { CharArray(3) }


        for (i in 0 until 3) {
            for (j in 0 until 3) {
                rotated[i][j] = if (dir == '+') cube[surface][2 - j][i]
                else cube[surface][j][2 - i]
            }
        }
        for (i in 0 until 3) {
            for (j in 0 until 3) {
                cube[surface][i][j] = rotated[i][j]
            }
        }
    }


    fun spin(surface: Int, dir: Char) {
        val spinCount = if (dir == '+') 1 else 3

        val spined = Array(6) { Array(3) { CharArray(3) } }

        val rule = spinRule[surface]

        for (i in rule.indices) {
            val curRule = rule[i]
            for (j in 0 until 4) {
                val jumpIdx = (j + spinCount) % 4
                val from = curRule[j]
                val to = curRule[jumpIdx]
                spined[to.surface][to.row][to.col] = cube[from.surface][from.row][from.col]
            }
        }
        for (i in rule.indices) {
            val curRule = rule[i]
            for (position in curRule) {
                cube[position.surface][position.row][position.col] =
                    spined[position.surface][position.row][position.col]
            }
        }
        rotateSurface(surface, dir)
    }

    cubing.forEach { (surface, dir) ->
        when (surface) {
            'U' -> spin(0, dir)
            'D' -> spin(1, dir)
            'F' -> spin(2, dir)
            'B' -> spin(3, dir)
            'L' -> spin(4, dir)
            'R' -> spin(5, dir)

        }
    }
    cube[0].forEach {
        println(it.joinToString (""))
    }
}

data class Position(
    val surface: Int,
    val row: Int,
    val col: Int
)


val upSpinRule = arrayOf(
    arrayOf(
        Position(2, 0, 0),
        Position(4, 0, 0),
        Position(3, 0, 0),
        Position(5, 0, 0)
    ),
    arrayOf(
        Position(2, 0, 1),
        Position(4, 0, 1),
        Position(3, 0, 1),
        Position(5, 0, 1)
    ),
    arrayOf(
        Position(2, 0, 2),
        Position(4, 0, 2),
        Position(3, 0, 2),
        Position(5, 0, 2)
    )
)
val downSpinRule = arrayOf(
    arrayOf(
        Position(5, 2, 0),
        Position(3, 2, 0),
        Position(4, 2, 0),
        Position(2, 2, 0)
    ),
    arrayOf(
        Position(5, 2, 1),
        Position(3, 2, 1),
        Position(4, 2, 1),
        Position(2, 2, 1)
    ),
    arrayOf(
        Position(5, 2, 2),
        Position(3, 2, 2),
        Position(4, 2, 2),
        Position(2, 2, 2)
    )
)

val forwardSpinRule = arrayOf(
    arrayOf(
        Position(0, 2, 0),
        Position(5, 0, 0),
        Position(1, 0, 0),
        Position(4, 2, 2)
    ),
    arrayOf(
        Position(0, 2, 1),
        Position(5, 1, 0),
        Position(1, 1, 0),
        Position(4, 1, 2)
    ),
    arrayOf(
        Position(0, 2, 2),
        Position(5, 2, 0),
        Position(1, 2, 0),
        Position(4, 0, 2)
    )
)

val backSpinRule = arrayOf(
    arrayOf(
        Position(0, 0, 0),
        Position(4, 2, 0),
        Position(1, 0, 2),
        Position(5, 0, 2)
    ),
    arrayOf(
        Position(0, 0, 1),
        Position(4, 1, 0),
        Position(1, 1, 2),
        Position(5, 1, 2)
    ),
    arrayOf(
        Position(0, 0, 2),
        Position(4, 0, 0),
        Position(1, 2, 2),
        Position(5, 2, 2)
    ),
)

val leftSpinRule = arrayOf(
    arrayOf(
        Position(0, 2, 0),
        Position(2, 2, 0),
        Position(1, 2, 2),
        Position(3, 0, 2),
    ),
    arrayOf(
        Position(0, 1, 0),
        Position(2, 1, 0),
        Position(1, 2, 1),
        Position(3, 1, 2),
    ),
    arrayOf(
        Position(0, 0, 0),
        Position(2, 0, 0),
        Position(1, 2, 0),
        Position(3, 2, 2),
    )
)

val rightSpinRule = arrayOf(
    arrayOf(
        Position(0, 0, 2),
        Position(3, 2, 0),
        Position(1, 0, 0),
        Position(2, 0, 2),
    ),
    arrayOf(
        Position(0, 1, 2),
        Position(3, 1, 0),
        Position(1, 0, 1),
        Position(2, 1, 2),
    ),
    arrayOf(
        Position(0, 2, 2),
        Position(3, 0, 0),
        Position(1, 0, 2),
        Position(2, 2, 2),
    ),
)
val spinRule = arrayOf(upSpinRule, downSpinRule, forwardSpinRule, backSpinRule, leftSpinRule, rightSpinRule)
