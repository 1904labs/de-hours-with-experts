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
      
    def __repr__(self) -> str:
        return f'{self.amount} {self.description}'


def decode_string(S: str) -> str:
    """Given a string named str, use the Caesar encoding above to return the decoded string."""
    return ''.join([ENCODING.get(s, s) for s in S])


def decode_ingredient(line: str) -> Ingredient:
    """Given an ingredient, decode the amount and description, and return a new Ingredient"""
    return Ingredient(*(decode_string(l) for l in line.split("#")))


def main():
    """A program that decodes a secret recipe"""
    with open("secret_recipe.txt") as encoded_recipe, open("decoded_recipe.txt", "w") as decoded_recipe:
      for line in encoded_recipe:
        line_end = '\n' if line[-1] == '\n' else ''
        decoded_recipe.write(f'{decode_ingredient(line.rstrip())}{line_end}')

if __name__ == "__main__":
    main()
