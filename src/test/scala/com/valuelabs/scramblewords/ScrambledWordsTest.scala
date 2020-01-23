package com.valuelabs.scramblewords

import org.scalatest.FunSuite

class ScrambledWordsTest extends FunSuite {

  test("should return the exact matched count") {
    val dictionary = Array("axpaj", "apxaj")
    val inp = "aapxjdnrbtvldptfzbbdbbzxtndrvjblnzjfpvhdhhpxjdnrbt"
    val expected = 2
    val actual = ScrambledWords.findMatchedCount(5, dictionary, inp)
    assert(expected == actual)
  }

  test("should return 0 if no match found") {
    val dictionary = Array("abd")
    val inp = "aapxjdnrbtvldptfzbbdbbzxtndrvjblnzjfpvhdhhpxjdnrbt"
    val expected = 0
    val actual = ScrambledWords.findMatchedCount(5, dictionary, inp)
    assert(expected == actual)
  }

  test("Verify frequency is populating correctly") {
    val inp = "aaaaa"
    val expected = Array.fill(26)(0)
    expected(0) = 5
    val actual = ScrambledWords.getFreq(inp)
    assert(expected.sameElements(actual))
  }

}
