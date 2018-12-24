package Day1

import java.io.File
import java.io.FileNotFoundException

fun main(args: Array<String>) {
    val inputPath = "${System.getProperty("user.dir")}/data/Day1Input.txt"
    var frequency: Long = 0

    try {
        var counter = 0
        var duplicate: Long? = null
        val pastFrequencies: MutableSet<Long> = mutableSetOf()

        do {
            File(inputPath).forEachLine {
                if (duplicate == null) {
                    ++counter

                    frequency += it.toInt()

                    if (pastFrequencies.contains(frequency)) {
                        duplicate = frequency
                    }
                    pastFrequencies.add(frequency)
                }
            }
        } while (duplicate == null)

        println("Duplicate frequency found: $frequency")
    } catch (_: FileNotFoundException) {
        println("File not found: $inputPath")
        return
    }
}