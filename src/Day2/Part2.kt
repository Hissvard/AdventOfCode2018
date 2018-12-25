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

    println(commonLettersCorrectBoxIds(file))
}

fun commonLettersCorrectBoxIds(file: File): String? {
    val lines = file.readLines()

    for ((index, line) in lines.withIndex()) {
        val otherLines = lines.filterIndexed { lineIndex, _ -> lineIndex != index }

        val similarLine = similarLine(line, otherLines)

        if (similarLine != null) {
            return commonLetters(line, similarLine)
        }
    }

    return null
}

fun commonLetters(lineA: String, lineB: String): String {
    var result = ""

    (0 until Math.min(lineA.length, lineB.length)).forEach { i ->
        result += if (lineA[i] == lineB[i]) lineA[i] else ""
    }

    return result
}

fun similarLine(line: String, lines: List<String>, maximumDifference: Int = 1): String? {
    for (currentLine in lines) {
        if (lineDifference(line, currentLine) <= maximumDifference) {
            return currentLine
        }
    }

    return null
}

fun lineDifference(a: String, b: String): Int {
    var difference = Math.abs(a.length - b.length)

    (0 until Math.min(a.length, b.length)).forEach { i ->
        difference = if (a[i] != b[i]) difference + 1 else difference
    }

    return difference
}