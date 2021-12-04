fun main() {
    fun part1(input: List<Int>): Int {
        var counter = 0
        var lastValue = Int.MAX_VALUE
        input.forEach {
            if (lastValue < it) {
                counter++
            }
            lastValue = it
        }
        return counter
    }

    fun part2(input: List<Int>): Int {
        var counter = 0
        var lastValue = Int.MAX_VALUE

        (0..input.size-3).forEach {
            val windowSum = input.slice(it..it+2).sum()
            if (lastValue < windowSum) {
                counter++
            }
            lastValue = windowSum
        }
        return counter
    }

    // test if implementation meets criteria from the description, like:
    val testInput = readInput("Day01_test").map { it.toInt() }
    check(part1(testInput) == 7)
    check(part2(testInput) == 5)

    val input = readInput("Day01").map { it.toInt() }
    println(part1(input))
    println(part2(input))
}
