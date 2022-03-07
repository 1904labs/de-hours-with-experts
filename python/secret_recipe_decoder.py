#!/usr/bin/python3
import codecs
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
        return codecs.decode(str, encoding='ENCODING', errors='strict')

    def decode_ingredient(line):
        """Given an ingredient, decode the amount and description, and return a new Ingredient"""
        # Insert decoding function here
        # Parses amount from description
        new_ingredient = Ingredient()
        split_ingredient = line.split('#')
        new_ingredient.amount, new_ingredient.description = split_ingredient[0], split_ingredient[1]

    def main():
        """A program that decodes a secret recipe"""
        # Reads secret recipe file
        open('python/secret_recipe.txt','r')
        secret_recipe = open('python/secret_recipe.txt', 'r')
        encoded_recipe = secret_recipe.read()
        secret_recipe.close()

        decoded_recipe = codecs.decode(encoded_recipe, encoding='ENCODING', errors='strict')
        print(decoded_recipe)

    if __name__ == "__main__":
        main()
