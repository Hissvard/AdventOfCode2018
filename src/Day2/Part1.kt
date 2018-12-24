package Day2

import java.io.File
import java.io.FileNotFoundException

fun main(args: Array<String>) {
    val inputPath = "${System.getProperty("user.dir")}/data/Day2Input.txt"
    val file: File

    try {
        file = File(inputPath)
    } catch (_: FileNotFoundException) {
        println("File not found $inputPath")
        return
    }

    println(
        file.linesWithRepeatedLetters(2)
        * file.linesWithRepeatedLetters(3)
    )
}

fun File.linesWithRepeatedLetters(repeatedTimes: Int): Int {
    val hasOccurrency: (String, Int) -> Boolean = { line: String, occurrencesCount: Int ->
        val charOccurrences: MutableMap<Char, Int> = line.toSet().associateBy({it}, {0}).toMutableMap()

        line.forEach {
            charOccurrences[it] = charOccurrences[it]!! + 1
        }

        charOccurrences.filter { it.value == occurrencesCount }.isNotEmpty()
    }

    return this.readLines().sumBy { it -> if (hasOccurrency(it, repeatedTimes)) 1 else 0 }
}