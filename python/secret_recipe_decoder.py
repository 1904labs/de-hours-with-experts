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
            return f"Amount: {self.amount}, Description: {self.description}"

Ingredient1 = Ingredient("1 cup", "butter")


def decode_string(str):
    """Given a string named str, use the Caesar encoding above to return the decoded string."""
    decoded_str = ""
    for char in str:
        if char in ENCODING:
            decoded_str += ENCODING[char]
        else:
            decoded_str += char
    return decoded_str


def decode_ingredient(encoded_line):
    """Given an ingredient, decode the amount and description, and return a new Ingredient"""
    encoded_amount, encoded_description = encoded_line.split('#')
    amount = decode_string(encoded_amount)
    description = decode_string(encoded_description)
    return Ingredient(amount, description)








def main():
    """A program that decodes a secret recipe"""
    input_file = "python/secret_recipe.txt"
    output_file = "python/decoded_recipe.txt"
    try:   
        with open(input_file, 'r') as in_file, open(output_file, 'w') as out_file:
                lines = in_file.readlines()
                for l in lines:
                    print(decode_ingredient(l))
                    out_file.write(str(decode_ingredient(l)))
    except FileNotFoundError:
        return f"Error: File '{filename}' not found."
    except IOError:
        return f"Error: An IO error occurred while trying to read the file at {file_path}."



if __name__ == "__main__":
    main()
