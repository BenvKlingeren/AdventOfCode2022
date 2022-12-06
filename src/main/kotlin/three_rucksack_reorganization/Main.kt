package three_rucksack_reorganization

fun main() {
    print("sum of duplicate item priorities: ${
        input.parseToRucksacks().fold(0) { total, (firstHalf, secondHalf) ->
            total + (firstHalf).intersect(secondHalf).first().priority()
        }
    }\n")

    print("sum of group badges: ${
        input.parseToElfGroups().fold(0) { total, group ->
            total + group[0].intersect(group[1]).intersect(group[2]).first().priority()
        }
    }")
}

private val priorityList = listOf('a'..'z','A'..'Z').flatten().zip(listOf(1..57).flatten()).toMap()

private fun Char.priority(): Int = priorityList[this]!!

private fun String.parseToRucksacks(): List<Pair<Set<Char>, Set<Char>>> = split("\n").map { rucksack ->
    rucksack.take(rucksack.length/2).toSet() to rucksack.takeLast(rucksack.length/2).toSet()
}

private fun String.parseToElfGroups(): List<List<Set<Char>>> = split("\n").chunked(3).map { it.map { group -> group.toSet() } }