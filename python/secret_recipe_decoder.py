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

    def __str__(self):
        return f"{self.amount} {self.description}"

def decode_string(str):
    """Given a string named str, use the Caesar encoding above to return the decoded string."""
    # empty string to store the decoded value
    decoded_str = ''

    # loop through each character in str
    for character in str:
        if character in ENCODING:
            # replace encoded character with decoded character
            decoded_str += ENCODING[character]
        else:
            # keep original character
            decoded_str += character

    return decoded_str

def decode_ingredient(line):
    """Given an ingredient, decode the amount and description, and return a new Ingredient"""
    # split the ingredient into two parts, amount and description
    line = line.split("#")
    
    #decode each part
    amount = decode_string(line[0])
    description = decode_string(line[1])

    return Ingredient(amount, description)

def main():
    """A program that decodes a secret recipe"""
    # empty string to hold decoded recipe
    decoded_recipe = ""

    # open encoded recipe
    with open("secret_recipe.txt", "r") as recipe:

    # decode recipe line by line
        for line in recipe:
            decoded_ingredient = decode_ingredient(line)
            decoded_ingredient = str(decoded_ingredient)
            with open("decoded_recipe.txt", "a") as file:
                file.write(decoded_ingredient)

if __name__ == "__main__":
    main()
