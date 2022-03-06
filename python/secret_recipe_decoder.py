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
    decoded_character_list = [ENCODING[character] if character in ENCODING.keys() else character for character in str]
    decoded_string = "".join(decoded_character_list)
    return decoded_string

def decode_ingredient(line):
    """Given an ingredient, decode the amount and description, and return a new Ingredient"""
    seperated_strings = line.split('#')
    decoded_amount = decode_string(seperated_strings[0])
    decoded_description = decode_string(seperated_strings[1])
    return Ingredient(decoded_amount, decoded_description)

def main(filepath):
    """A program that decodes a secret recipe"""

    with open(filepath, 'r') as encoded_recipe:
        with open('decoded_recipe.txt', 'w') as decoded_recipe:
            for encoded_ingredient in encoded_recipe:
                decoded_ingredient = decode_ingredient(encoded_ingredient)
                decoded_recipe.write(f'{decoded_ingredient.amount} {decoded_ingredient.description}')


if __name__ == "__main__":
    try:
        file = open(sys.argv[1], 'r')
        main(os.path.realpath(file.name))
        file.close()
    except IndexError:
        file = open('secret_recipe.txt')
        main(os.path.realpath(file.name))
        file.close()
