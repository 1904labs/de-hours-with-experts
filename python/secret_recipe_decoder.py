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

    decoded_str = ""

    for character in str:
        if character not in ENCODING:
            decoded_str += character
        else:
            decoded_str += ENCODING.get(character)

    return decoded_str


def decode_ingredient(line):

    # Split line to seperate amount and descripton on delimiter.
    new_line = line.split("#")

    # Use previous decode string method to decode the split lines.
    decoded_amount = decode_string(new_line[0])
    decoded_description = decode_string(new_line[1])

    return Ingredient(decoded_amount, decoded_description)


def main():
    decoded_file = open("decoded_recipe.txt", 'w')
    with open("secret_recipe.txt", "r") as source_file:
        for line in source_file:
            ingredient = decode_ingredient(line)
            decoded_file.write(f"{ingredient.amount} {ingredient.description}")

        decoded_file.close()

if __name__ == "__main__":
    main()