#!/usr/bin/python3
import sys
import os

# Caesar encoding, for use with decoding below
ENCODING = {
    'y': 'a','h': 'b','v': 'c','x': 'd','k': 'e','p': 'f',
    'z': 'g','s': 'h','a': 'i','b': 'j','e': 'k','w': 'l',
    'u': 'm','q': 'n','n': 'o','l': 'p','m': 'q','f': 'r',
    'o': 's','i': 't','g': 'u','j': 'v','t': 'w','d': 'x',
    'r': 'y','c': 'z',
    '3': '0','8': '1','4': '2','0': '3','2': '4','7': '5',
    '5': '6','9': '7','1': '8','6': '9'
}

class Ingredient:
    def __init__(self, amount, description):
        self.amount = amount
        self.description = description

def decode_string(s):
    """Given a string, decode it using the ENCODING dictionary."""
    return "".join(ENCODING.get(char, char) for char in s)

def decode_ingredient(line):
    """Given a line from the recipe, decode the amount and description, return an Ingredient object."""
    encoded_amount, encoded_description = line.strip().split("#")
    amount = decode_string(encoded_amount)
    description = decode_string(encoded_description)
    return Ingredient(amount, description)

def main():
    """Read the secret_recipe.txt, decode everything, and save to decoded_recipe.txt"""
    input_file = "secret_recipe.txt"
    output_file = "decoded_recipe.txt"

    if not os.path.exists(input_file):
        print(f"Error: {input_file} not found")
        return

    with open(input_file, "r") as f:
        lines = f.readlines()

    decoded_ingredients = [decode_ingredient(line) for line in lines]

    with open(output_file, "w") as f:
        for ing in decoded_ingredients:
            f.write(f"{ing.amount} {ing.description}\n")

    print(f"Decoded recipe written to {output_file}")

if __name__ == "__main__":
    main()