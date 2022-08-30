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


def decode_string(string: str, encoder_dict: dict = ENCODING) -> str:
    """Given a string named str, use the Caesar encoding above to return the decoded string."""
    return ''.join([encoder_dict[c] if c in encoder_dict.keys() else c for c in string])


def decode_ingredient(line: str) -> Ingredient:
    """Given an ingredient, decode the amount and description, and return a new Ingredient"""
    amt, desc = tuple(map(decode_string, line.split("#")))

    return Ingredient(amt, desc)


def main():
    """A program that decodes a secret recipe"""
    # read in and create a list of ingredient objects
    with open("secret_recipe.txt") as f:
        ingreds = [decode_ingredient(line.strip()) for line in f.readlines()]

    # write out each ingredient class attr separately
    with open("decoded_recipe.txt", 'w') as f:
        [f.write(' '.join([i.amount, i.description, '\n'])) for i in ingreds]

if __name__ == "__main__":
    main()
