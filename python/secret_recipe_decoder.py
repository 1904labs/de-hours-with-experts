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
    decoded_str = ''.join(ENCODING.get(char, char) for char in str)
    return decoded_str


def decode_ingredient(line):
    """Given an ingredient, decode the amount and description, and return a new Ingredient"""
    encoded_amt, encoded_desc = line.split('#', 1)
    decoded_amt = decode_string(encoded_amt)
    decoded_desc = decode_string(encoded_desc)
    # TODO: implement me
    return Ingredient(decoded_amt, decoded_desc)


def main():
    """A program that decodes a secret recipe"""
    input_file = 'secret_recipe.txt'
    output_file = 'decoded_recipe.txt'

    with open(input_file, 'r') as file:
        lines = file.readlines()
    decoded_recipe = [decode_ingredient(line) for line in lines]
    print(f'{decoded_recipe}')

    output = '\n'.join(f"{i.amount} {i.description}" for i in decoded_recipe)
    with open(output_file, 'w') as file:
        file.write(output)

if __name__ == "__main__":
    main()
