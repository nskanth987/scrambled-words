package com.valuelabs.scramblewords

import scala.io.Source

object ScrambledWords {

  def main(args: Array[String]): Unit = {

    val dictPath = args.head
    val inpPath = args.last

    val dictionary = Source.fromFile(dictPath).getLines().toArray // todo: use try finally here

    Source.fromFile(inpPath).getLines().zipWithIndex.foreach(line => {
      val result = dictionary.groupBy(_.length)
        .map(x => findMatchedCount(x._1, x._2, line._1))
        .sum

      println(s"Case #${line._2 + 1}: ${result}")
    })


  }

  def findMatchedCount(length: Int, dictWords: Array[String], input: String): Int = {
    def wordOccurs(dictWord: String): Boolean = {
      try {
        val dictFreq = getFreq(dictWord)
        val start = dictWord.head
        val last = dictWord.last
        val subStrFreq = getFreq(input.substring(0, length))
        for (i <- 0 to input.length - length) {
          if (i > 0) {
            subStrFreq(input.charAt(i - 1) - 97) -= 1
            subStrFreq(input.charAt(i + length - 1) - 97) += 1
          }
          if (dictFreq.sameElements(subStrFreq))
            if (start == input.charAt(i) && last == input.charAt(i + length - 1))
              return true
        }
      } catch {
        case ex: Exception =>
      }
      false
    }

    dictWords.count(wordOccurs)
  }

  def getFreq(str: String): Array[Int] = {
    str.foldLeft(Array.fill(26)(0))((freqArr, ch) => {
      freqArr(ch - 97) += 1
      freqArr
    })
  }

}
