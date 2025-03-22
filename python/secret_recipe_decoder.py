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
    # TODO: implement me
    decoded_string = ''
    for char in str:
        if char in ENCODING:
            decoded_string += ENCODING[char]
        else:
            decoded_string += char
    return decoded_string


def decode_ingredient(line):
    """Given an ingredient, decode the amount and description, and return a new Ingredient"""
    # TODO: implement me

    decoded_line = decode_string(line)
    ing = decoded_line.split('#')
    ingredient = Ingredient(ing[0], ing[1])

    return ingredient

def main():
    """A program that decodes a secret recipe"""
    # TODO: implement me
    with open("output.txt","w") as output_file:
        with open("secret_recipe.txt","r") as input_file:
            for line in input_file:
                decoded = decode_ingredient(line)
                output_file.write(f"{decoded.amount} {decoded.description}")
    print(f"Decoded recipe can be found in {output_file.name}.")

if __name__ == "__main__":
    main()
