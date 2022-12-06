package six_tuning_trouble


fun main() {
    print("number of characters needed to be processed before marker: ${process(4)}\n")
    print("number of characters needed to be processed before message: ${process(14)}")
}

private fun process(size: Int): Int {
    var index = size - 1
    input.windowed(size).takeWhile { sequence ->
        index++
        sequence.toList().distinct().count() < sequence.count()
    }
    return index
}