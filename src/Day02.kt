fun main() {

    fun part1(input: List<String>): Int {
        var depth = 0
        var hpos = 0

        input.forEach {
            val d = Regex("(\\w+) (\\d+)").find(it)!!.destructured
            val cmd = d.component1()
            val value = d.component2().toInt()
            when (cmd) {
                "up" -> depth -= value
                "down" -> depth += value
                "forward" -> hpos += value
            }
        }

        return depth * hpos
    }

    fun part2(input: List<String>): Int {
        var depth = 0
        var hpos = 0
        var aim = 0

        input.forEach {
            val d = Regex("(\\w+) (\\d+)").find(it)!!.destructured
            val cmd = d.component1()
            val value = d.component2().toInt()
            when (cmd) {
                "up" -> aim -= value
                "down" -> aim += value
                "forward" -> { hpos += value; depth += aim * value }
            }
        }

        return depth * hpos
    }

    // test if implementation meets criteria from the description, like:
    val testInput = readInput("Day02_test")
    check(part1(testInput) == 150)
    check(part2(testInput) == 900)

    val input = readInput("Day02")
    println(part1(input))
    println(part2(input))
}