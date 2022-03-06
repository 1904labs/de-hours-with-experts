from secret_recipe_decoder import decode_ingredient, decode_string, Ingredient

def test_decode_string_can_decode():
    print(decode_string("abc"))
    assert(decode_string("abc") == "yhv")

def test_decode_ingredient_can_decode():
    expected = Ingredient("1 cup", "butter")
    actual = decode_ingredient("8 vgl#hgiikf")
    assert(actual.amount == expected.amount)
    assert(actual.description == expected.description)

if __name__ == "__main__":
    test_decode_string_can_decode()
    test_decode_ingredient_can_decode()
    print("Passed all tests")