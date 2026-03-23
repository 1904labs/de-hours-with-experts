package com.labs1904

import org.scalatest.FunSpec

class SecretRecipeDecoderTest extends FunSpec {

  describe("Testing decode_string") {
    it("can decode a string") {
      assert(SecretRecipeDecoder.decodeString("8 vgl") === "1 cup")
    }
  }

  describe("Testing decode_ingredient") {
    it("can decode an ingredient") {
      val expected = Ingredient("1 cup", "butter")
      val actual = SecretRecipeDecoder.decodeIngredient("8 vgl#hgiikf")
      assert(actual.amount === expected.amount)
      assert(actual.description === expected.description)
    }
  }
}
