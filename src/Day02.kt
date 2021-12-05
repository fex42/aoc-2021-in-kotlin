fun main() {

    data class Pos(val hpos: Int = 0, val depth: Int = 0) {
        val result: Int
            get() = this.hpos * this.depth
    }

    data class Pos2(val hpos: Int = 0, val depth: Int = 0, val aim: Int = 0) {
        val result: Int
            get() = this.hpos * this.depth
    }

    fun part1(input: List<String>): Int {
        var pos = Pos()

        input.forEach {
            val (cmd, value) = Regex("(\\w+) (\\d+)").find(it)!!.destructured
            when (cmd) {
                "up" -> pos = pos.copy(depth = pos.depth - value.toInt())
                "down" -> pos = pos.copy(depth = pos.depth + value.toInt())
                "forward" -> pos = pos.copy(hpos = pos.hpos + value.toInt())
            }
        }

        return pos.result
    }

    fun part2(input: List<String>): Int {
        var pos = Pos2()

        input.forEach {
            val d = Regex("(\\w+) (\\d+)").find(it)!!.destructured
            val cmd = d.component1()
            val value = d.component2().toInt()
            when (cmd) {
                "up" -> pos = pos.copy(aim = pos.aim - value)
                "down" -> pos = pos.copy(aim = pos.aim + value)
                "forward" -> pos =
                    pos.copy(hpos = pos.hpos + value, depth = pos.depth + pos.aim * value)
            }
        }

        return pos.result
    }

    // test if implementation meets criteria from the description, like:
    val testInput = readInput("Day02_test")
    check(part1(testInput) == 150)
    check(part2(testInput) == 900)

    val input = readInput("Day02")
    println(part1(input))
    println(part2(input))
}