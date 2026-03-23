#!/usr/bin/python3
import pydoc
import sys
import os

# Caesar encoding, for use with decoding below
ENCODING = {
    'y': 'a',
    'h': 'b',
    'v': 'c',
    'x': 'd',
    'k': 'e',
    'p': 'f',
    'z': 'g',
    's': 'h',
    'a': 'i',
    'b': 'j',
    'e': 'k',
    'w': 'l',
    'u': 'm',
    'q': 'n',
    'n': 'o',
    'l': 'p',
    'm': 'q',
    'f': 'r',
    'o': 's',
    'i': 't',
    'g': 'u',
    'j': 'v',
    't': 'w',
    'd': 'x',
    'r': 'y',
    'c': 'z',
    '3': '0',
    '8': '1',
    '4': '2',
    '0': '3',
    '2': '4',
    '7': '5',
    '5': '6',
    '9': '7',
    '1': '8',
    '6': '9'
 }

"""An ingredient has an amount and a description.
For example: an Ingredient could have "1 cup" as the amount and "butter" as the description."""
class Ingredient():
    def __init__(self, amount, description) -> None:
        self.amount = amount
        self.description = description


def decode_string(str):
    """Given a string named str, use the Caesar encoding above to return the decoded string."""
    return ''.join(ENCODING.get(ch, ch) for ch in str)


def decode_ingredient(line):
    """Given an ingredient, decode the amount and description, and return a new Ingredient"""
    amount_encoded, description_encoded = line.split("#")

    amount = decode_string(amount_encoded.strip())
    description = decode_string(description_encoded.strip())

    return Ingredient(amount, description)


def main():
    
    """"Decoded String"""
    print(f"Decoded String: {decode_string("hgiikf")}")

    """Decoded Ingredient"""
    test_line = "8 vgl#hgiikf"
    ingredient = decode_ingredient(test_line)
    print(f"Decoded Ingredient: {ingredient.amount} {ingredient.description}")

    """A program that decodes a secret recipe"""
    input_file = "secret_recipe.txt"
    output_file = "decoded_recipe.txt"

    if not os.path.exists(input_file):
        print("Input file not found!")
        return

    with open(input_file, "r") as infile, open(output_file, "w") as outfile:
        for line in infile:
            line = line.strip()
            if not line:
                continue

            ingredient = decode_ingredient(line)

            # Write decoded result
            outfile.write(f"{ingredient.amount} {ingredient.description}\n")

    print(f"Decoded recipe saved to {output_file}")

if __name__ == "__main__":
    main()
