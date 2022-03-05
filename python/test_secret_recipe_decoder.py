import pytest
import os
from secret_recipe_decoder import decode_ingredient, decode_string, decode_recipe_file, Ingredient

#challenge 1/3
def test_decode_string_can_decode():
    assert(decode_string("abc") == "ijz")
#challenge 2/3
def test_decode_ingredient_can_decode():
    expected = Ingredient("1 cup", "butter")
    actual = decode_ingredient("8 vgl#hgiikf")
    assert(actual.amount == expected.amount)
    assert(actual.description == expected.description)
#challenge 3/3
def test_decode_recipe_file():
    assert(decode_recipe_file(r"secret_recipe.txt"))
