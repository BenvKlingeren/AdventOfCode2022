package one_calorie_counting

import kotlin.math.max

fun main() {
    print("most calories collected by one elf: ${partOne()}\n")
    print("top three elves are carrying in total: ${partTwo()}\n")
}

private fun partOne(): Int
{
    var chadElf = 0
    input.split("\n")
        .runningFold(0) { elf, calories ->
            if (calories.isEmpty()) {
                chadElf = max(chadElf, elf)
                0
            } else {
                elf + calories.toInt()
            }
        }
    return chadElf
}

private fun partTwo(): Int
{
    val elves = mutableListOf<Int>()
    input.split("\n")
        .runningFold(0) { elf, calories ->
            if (calories.isEmpty()) {
                elves.add(elf)
                0
            } else {
                elf + calories.toInt()
            }
        }
    elves.sort()
    return elves.takeLast(3).sum()
}