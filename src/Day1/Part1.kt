package Day1

import java.io.File
import java.io.FileNotFoundException

fun main(args: Array<String>) {
    val inputPath = "${System.getProperty("user.dir")}/data/Day1Input.txt"
    var frequency = 0

    try {
        File(inputPath).forEachLine { frequency += it.toInt() }
    } catch (_: FileNotFoundException) {
        println("File not found: $inputPath")
        return
    }

    println(frequency)
}