import pytest
from secret_recipe_decoder import decode_ingredient, encode_string, decode_string, Ingredient

#Modified this function seems instructions seem to point to encode rather than decode
def test_encode_string_can_decode():
    assert(encode_string("abc") == "yhv")
#Added this function for the purposes of decoding in case this was a requirement as well
def test_decode_string_can_decode():
    assert(decode_string("abc") == "ijz")

def test_decode_ingredient_can_decode():
    expected = Ingredient("1 cup", "butter")
    actual = decode_ingredient("8 vgl#hgiikf")
    assert(actual.amount == expected.amount)
    assert(actual.description == expected.description)