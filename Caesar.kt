import java.util.Scanner

object CaesarCipher {

  @JvmStatic
  fun main(args: Array<String>) {
    val input = Scanner(System.`in`)
    val inputText = input.nextLine()
    println("Enter your key")
    val key = Integer.parseInt(input.nextLine())
    if (key in 1..26) {
      println(cipher(inputText, key))
    } else
      println("Please enter a key between 1 and 26")
  }

  /**
   * @param inputText the input supplied
   * return cipher text
   */
  private fun cipher(inputText: String, key: Int): String {
    var outputText = ""
    for (c in inputText.toCharArray()) {
      outputText += when {
        Character.isUpperCase(c) -> (((c - 'A' + key) % 26) + 'A'.toInt()).toChar()
        Character.isLowerCase(c) -> (((c - 'a' + key) % 26 )+ 'a'.toInt()).toChar()
        else -> c
      }
    }
    return outputText
  }
}
