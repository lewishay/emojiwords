import java.awt.Toolkit
import java.awt.datatransfer.StringSelection

object EmojiWords extends App {

  val word = args(0)
  val emoji = args(1)
  val gap = ":empty:"
  val emo = s":$emoji:"

  val letterMap: Map[Char, Vector[String]] = Map(
    'a' -> Vector(s"$gap$emo$emo$gap", s"$emo$gap$gap$emo", s"$emo$emo$emo$emo", s"$emo$gap$gap$emo", s"$emo$gap$gap$emo"),
    'b' -> Vector(s"$emo$emo$emo$gap", s"$emo$gap$gap$emo", s"$emo$emo$emo$emo", s"$emo$gap$gap$emo", s"$emo$emo$emo$gap"),
    'c' -> Vector(s"$emo$emo$emo$emo", s"$emo$gap$gap$gap", s"$emo$gap$gap$gap", s"$emo$gap$gap$gap", s"$emo$emo$emo$emo"),
    'd' -> Vector(s"$emo$emo$emo$gap", s"$emo$gap$gap$emo", s"$emo$gap$gap$emo", s"$emo$gap$gap$emo", s"$emo$emo$emo$gap"),
    'e' -> Vector(s"$emo$emo$emo$emo", s"$emo$gap$gap$gap", s"$emo$emo$emo$emo", s"$emo$gap$gap$gap", s"$emo$emo$emo$emo"),
    'f' -> Vector(s"$emo$emo$emo$emo", s"$emo$gap$gap$gap", s"$emo$emo$emo$emo", s"$emo$gap$gap$gap", s"$emo$gap$gap$gap"),
    'g' -> Vector(s"$emo$emo$emo$emo", s"$emo$gap$gap$gap", s"$emo$gap$emo$emo", s"$emo$gap$gap$emo", s"$emo$emo$emo$emo"),
    'h' -> Vector(s"$emo$gap$gap$emo", s"$emo$gap$gap$emo", s"$emo$emo$emo$emo", s"$emo$gap$gap$emo", s"$emo$gap$gap$emo"),
    'i' -> Vector(emo, emo, emo, emo, emo),
    'j' -> Vector(s"$emo$emo$emo$emo", s"$gap$gap$emo$gap", s"$gap$gap$emo$gap", s"$emo$gap$emo$gap", s"$emo$emo$emo$gap"),
    'k' -> Vector(s"$emo$gap$gap$emo", s"$emo$gap$emo$gap", s"$emo$emo$gap$gap", s"$emo$gap$emo$gap", s"$emo$gap$gap$emo"),
    'l' -> Vector(s"$emo$gap$gap$gap", s"$emo$gap$gap$gap", s"$emo$gap$gap$gap", s"$emo$gap$gap$gap", s"$emo$emo$emo$emo"),
    'm' -> Vector(s"$emo$gap$gap$gap$emo", s"$emo$emo$gap$emo$emo", s"$emo$gap$emo$gap$emo", s"$emo$gap$gap$gap$emo", s"$emo$gap$gap$gap$emo"),
    'n' -> Vector(s"$emo$gap$gap$gap$emo", s"$emo$emo$gap$gap$emo", s"$emo$gap$emo$gap$emo", s"$emo$gap$gap$emo$emo", s"$emo$gap$gap$gap$emo"),
    'o' -> Vector(s"$emo$emo$emo$emo", s"$emo$gap$gap$emo", s"$emo$gap$gap$emo", s"$emo$gap$gap$emo", s"$emo$emo$emo$emo"),
    'p' -> Vector(s"$emo$emo$emo$emo", s"$emo$gap$gap$emo", s"$emo$emo$emo$emo", s"$emo$gap$gap$gap", s"$emo$gap$gap$gap"),
    'q' -> Vector(s"$emo$emo$emo$emo$emo", s"$emo$gap$gap$gap$emo", s"$emo$gap$gap$gap$emo", s"$emo$gap$gap$emo$emo", s"$emo$emo$emo$emo$emo"),
    'r' -> Vector(s"$emo$emo$emo$emo", s"$emo$gap$gap$emo", s"$emo$emo$emo$emo", s"$emo$gap$emo$gap", s"$emo$gap$gap$emo"),
    's' -> Vector(s"$emo$emo$emo$emo", s"$emo$gap$gap$gap", s"$emo$emo$emo$emo", s"$gap$gap$gap$emo", s"$emo$emo$emo$emo"),
    't' -> Vector(s"$emo$emo$emo$emo$emo", s"$gap$gap$emo$gap$gap", s"$gap$gap$emo$gap$gap", s"$gap$gap$emo$gap$gap", s"$gap$gap$emo$gap$gap"),
    'u' -> Vector(s"$emo$gap$gap$emo", s"$emo$gap$gap$emo", s"$emo$gap$gap$emo", s"$emo$gap$gap$emo", s"$emo$emo$emo$emo"),
    'v' -> Vector(s"$emo$gap$gap$gap$emo", s"$emo$gap$gap$gap$emo", s"$emo$gap$gap$gap$emo", s"$gap$emo$gap$emo$gap", s"$gap$gap$emo$gap$gap"),
    'w' -> Vector(s"$emo$gap$gap$gap$emo", s"$emo$gap$gap$gap$emo", s"$emo$gap$gap$gap$emo", s"$emo$gap$emo$gap$emo", s"$emo$emo$gap$emo$emo"),
    'x' -> Vector(s"$emo$gap$gap$gap$emo", s"$gap$emo$gap$emo$gap", s"$gap$gap$emo$gap$gap", s"$gap$emo$gap$emo$gap", s"$emo$gap$gap$gap$emo"),
    'y' -> Vector(s"$emo$gap$gap$gap$emo", s"$gap$emo$gap$emo$gap", s"$gap$gap$emo$gap$gap", s"$gap$gap$emo$gap$gap", s"$gap$gap$emo$gap$gap"),
    'z' -> Vector(s"$emo$emo$emo$emo$emo", s"$gap$gap$gap$emo$gap", s"$gap$gap$emo$gap$gap", s"$gap$emo$gap$gap$gap", s"$emo$emo$emo$emo$emo"),
    ' ' -> Vector(gap, gap, gap, gap, gap)
  )

  val result =
    (0 to 4).map { i =>
      word.map { letter =>
        letterMap(letter)(i) + gap
      }.mkString.dropRight(7) + "\n"
    }.mkString.dropRight(1)

  val clipboard = Toolkit.getDefaultToolkit().getSystemClipboard()
  val transferable = new StringSelection(result)
  clipboard.setContents(transferable, null)
}
