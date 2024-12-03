import java.math.BigInteger
import java.security.MessageDigest
import kotlin.io.path.Path
import kotlin.io.path.readText

/** Reads lines from the given input txt file. */
fun readInputToLines(name: String) = readInput(name).lines()

fun readInput(name: String): String {
  val whichDay = "Day\\d+".toRegex().find(name)!!.value
  return Path("src/$whichDay/$name.txt").readText().trim()
}

fun toInt(string: String) = string.toInt()

/** Converts string to md5 hash. */
fun String.md5() =
    BigInteger(1, MessageDigest.getInstance("MD5").digest(toByteArray()))
        .toString(16)
        .padStart(32, '0')

/** The cleaner shorthand for printing output. */
fun Any?.println() = println(this)
