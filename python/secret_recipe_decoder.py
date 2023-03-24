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

'''This is the delimiter for splitting amounts from the actual item in a line.'''
AMOUNT_DESCRIPTION_DELIMITER = "#"


"""An ingredient has an amount and a description.
For example: an Ingredient could have "1 cup" as the amount and "butter" as the description."""
class Ingredient():
    def __init__(self, amount, description) -> None:
        self.amount = amount
        self.description = description


def decode_string(encoded_str: str):
    """Given a string named str, use the Caesar encoding above to return the decoded string."""
    accum_str: str = ""
    for c in encoded_str:
        if c in ENCODING:
            accum_str += ENCODING[c]
        else:
            accum_str += c
    return accum_str


def decode_ingredient(line):
    """Given an ingredient, decode the amount and description, and return a new Ingredient.
    If the line isn't formatted as expected, return None."""
    line_parts: [] = line.split(AMOUNT_DESCRIPTION_DELIMITER)
    if len(line_parts) != 2:
        return None
    return Ingredient(decode_string(line_parts[0]), decode_string(line_parts[1]))


def main():
    """A program that decodes a secret recipe"""
    in_file_path: str = 'secret_recipe.txt'
    out_file_path: str = 'decoded_recipe.txt'

    with open(out_file_path, mode='w') as out_file:
        out_file.write('amount, description\n')
        with open(in_file_path, mode='r') as in_file:
            # read all the lines out of 'secret_recipes.txt'
            for encoded_line in in_file:
                # decode each line
                ingredient: Ingredient = decode_ingredient(encoded_line.strip())
                # save output to 'decoded_recipe.txt'
                out_file.write(f'{ingredient.amount}, {ingredient.description}\n')

if __name__ == "__main__":
    main()
