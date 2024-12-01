import kotlin.math.abs

fun main() {
    fun part1(input: List<String>): Int = input.buildLists().let { (leftIds, rightIds) ->
        leftIds.sorted().zip(rightIds.sorted())
            .fold(initial = 0) { totalDistance, (leftId, rightId) -> totalDistance + abs(leftId - rightId) }
    }

    fun part2(input: List<String>): Int = input.buildLists().let { (leftIds, rightIds) ->
        leftIds.fold(initial = 0) { similarityScore, id -> similarityScore + id * rightIds.count { it == id } }
    }

    val input = readInput("Day01")
    part1(input).println()
    part2(input).println()
}

private fun List<String>.buildLists(): Pair<List<Int>, List<Int>> {
    val leftIds = mutableListOf<Int>()
    val rightIds = mutableListOf<Int>()
    forEach { line ->
        with(line.split(Regex("\\s+"))) {
            leftIds.add(first().toInt())
            rightIds.add(last().toInt())
        }
    }

    return leftIds to rightIds
}
