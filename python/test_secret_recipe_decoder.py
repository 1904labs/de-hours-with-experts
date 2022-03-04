import pytest
from secret_recipe_decoder import decode_ingredient, encode_string, decode_string, Ingredient

def test_encode_string_can_decode():
    assert(encode_string("abc") == "yhv")

def test_decode_string_can_decode():
    assert(decode_string("abc") == "ijz")

def test_decode_ingredient_can_decode():
    expected = Ingredient("1 cup", "butter")
    actual = decode_ingredient("8 vgl#hgiikf")
    assert(actual.amount == expected.amount)
    assert(actual.description == expected.description)