fun main() {

    fun part1(input: List<String>): Int {
        val bitWidth = input[0].length
        val numRows = input.size

        var acc = 0
        (0 until bitWidth).forEach { bitIndex ->
            acc = acc shl 1
            if (input.map { it.get(bitIndex) }.count { it == '1' } > numRows / 2) {
                acc += 1
            }
        }

        val gamma = acc
        val epsilon = acc xor ((2 shl bitWidth - 1) - 1)

        return gamma * epsilon
    }

    fun findOxGenRating(list: List<String>, bit: Int): Int {
        val numZero = list.count { it[bit] == '0' }
        val newList = list.filter { it[bit] == if (numZero > list.size / 2) '0' else '1' }
        if (newList.size > 1)
            return findOxGenRating(newList, bit + 1)
        else
            return newList.first().toInt(2)
    }

    fun findCo2ScrubberRating(list: List<String>, bit: Int): Int {
        val numZero = list.count { it[bit] == '0' }
        val newList = list.filter { it[bit] == if (numZero <= list.size / 2) '0' else '1' }
        if (newList.size > 1)
            return findCo2ScrubberRating(newList, bit + 1)
        else
            return newList.first().toInt(2)
    }

    fun part2(input: List<String>): Int {
        val oxGenRating = findOxGenRating(input, 0)
        val co2ScrubberRating = findCo2ScrubberRating(input, 0)
        return oxGenRating * co2ScrubberRating
    }

    // test if implementation meets criteria from the description, like:
    val testInput = readInput("Day03_test")
    check(part1(testInput) == 198)
    check(part2(testInput) == 230)

    val input = readInput("Day03")
    println(part1(input))
    println(part2(input))
}