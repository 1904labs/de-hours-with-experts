package com.labs1904

import org.scalatest.funsuite.AnyFunSuite

class SecretRecipeDecoderTest extends AnyFunSuite {
  test("can decode a string") {
    assert(SecretRecipeDecoder.decodeString("8 vgl") === "1 cup")
  }

  test("can decode an ingredient") {
    val expected = Ingredient("1 cup", "butter")
    val actual = SecretRecipeDecoder.decodeIngredient("8 vgl#hgiikf")
    assert(actual.amount === expected.amount)
    assert(actual.description === expected.description)
  }
}
