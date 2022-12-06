package four_camp_cleanup

fun main() {
    print("number of range pairs fully contained: ${
        input.parse().count { (first, second) ->
            first.containsAll(second) || second.containsAll(first)
        }
    }\n")

    print("number of ranges that overlap: ${
        input.parse().map { Pair(it.first.toSet(), it.second.toSet()) }.count { (first, second) ->
            first.intersect(second).isNotEmpty() || second.intersect(first).isNotEmpty()
        }
    }")
}
private fun String.parse(): List<Pair<List<Int>, List<Int>>> = split("\n").map { input ->
    val parse: (String.() -> List<Int>) = {
        val values = split("-").map { it.toInt() }
        listOf(values.first()..values.last()).flatten()
    }
    val ranges = input.split(",")
    ranges.first().parse() to ranges.last().parse()
}