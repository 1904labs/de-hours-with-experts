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
    # Return string of the Ingredient
    def show(self):
        return '{} {}'.format(self.amount, self.description)


def decode_string(str):
    """Given a string named str, use the Caesar encoding above to return the decoded string."""

    dec_str = ''
    # loop through all chars in the input string
    for char in str:
        # If it's a character in the cipher, decode it
        if ENCODING.get(char):
            dec_str += ENCODING[char]
        # Otherwise just use the char
        else:
            dec_str += char
    return dec_str


def decode_ingredient(line):
    """Given an ingredient, decode the amount and description, and return a new Ingredient"""

    split_line = []
    # Split the incoming line into 2 on the pound/hashtag
    for entry in line.split('#'):
        # Decode the entry and add it to the split line
        split_line.append(decode_string(entry))
    
    # return an Ingredient made from the splits.
    return Ingredient(split_line[0], split_line[1])


def main():
    """A program that decodes a secret recipe"""

    # Open, read in, and close secret_recipe.txt
    with open('python\secret_recipe.txt') as f:
        lines = f.readlines()
    f.close()

    # Create if needed, Open, overwrite decoded lines to, and close decoded_recipe.txt
    f = open('python\decoded_recipe.txt', "w")
    for line in lines:
        f.write((decode_ingredient(line)).show())
    f.close()

if __name__ == "__main__":
    main()
