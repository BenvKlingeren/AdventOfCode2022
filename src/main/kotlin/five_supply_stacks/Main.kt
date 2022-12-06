package five_supply_stacks

import java.util.Stack

fun main() {
    val crateMover9000Move: (Crates.(Int, Int, Int) -> Unit) = { number, from, to ->
        repeat(number) {
            get(to - 1).push(get(from - 1).pop())
        }
    }
    
    print("top of all crates with CrateMover 9000 spells: ${process(crateMover9000Move)}\n")

    val crateMover9001Move: (Crates.(Int, Int, Int) -> Unit) = { number, from, to ->
        List(number) {
            get(from - 1).pop()
        }.reversed().forEach {
            get(to - 1).push(it)
        }
    }

    print("top of all crates with CrateMover 9001 spells: ${process(crateMover9001Move)}\n")
}

private fun process(move: Crates.(Int, Int, Int) -> Unit): String {
    val crates = input.parseCrates()

    val moves = input.parseMoves(move)
    
    moves.forEach {
        crates.it()
    }
    return crates.fold("") { acc, stack ->
        acc + stack.peek()
    }
}


typealias Crates = List<Stack<Char>>

private fun String.parseCrates(): Crates {
    val crateInput = split("\n\n").first()
        .split("\n")
        .map { it.windowed(3, 4) }

    val numberOfCrates = crateInput.last().last()[1].digitToInt()

    val crates: Crates = List(numberOfCrates) { Stack() }

    crateInput.dropLast(1).reversed().forEach { line ->
        line.forEachIndexed { index, crate ->
            val character = crate[1]
            if (character != ' ') crates[index].push(character)
        }
    }
    return crates
}

private fun String.parseMoves(move: Crates.(Int, Int, Int) -> Unit): List<Crates.() -> Unit> =
    split("\n\n")
        .last()
        .split("\n")
        .map { moveString ->
            val line = moveString.split(" ")
            val function = { crates: Crates ->
                (move)(crates, line[1].toInt(), line[3].toInt(), line[5].toInt())
            }
            function
        }
