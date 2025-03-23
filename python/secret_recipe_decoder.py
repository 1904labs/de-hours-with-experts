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


def decode_string(encoded_str):
    """Given a string named str, use the Caesar encoding above to return the decoded string."""
    # TODO: implement me
    new_list = []

    # Loop over characters, if char is in the list, append the new value and then join the result
    for char in encoded_str:
        if char in ENCODING:
            new_list.append(ENCODING[char])
        else:
            new_list.append(char)
    return "".join(new_list)


def decode_ingredient(line):
    """Given an ingredient, decode the amount and description, and return a new Ingredient"""
    # TODO: implement me

    # Need to split the two by the amount and description
    encoded_amt, encoded_desc = line.split('#')

    # Decode each half
    decoded_amount = decode_string(encoded_amt)
    decoded_desc = decode_string(encoded_desc)

    # Combine each
    return Ingredient(decoded_amount, decoded_desc)


def main():
    """A program that decodes a secret recipe"""
    # TODO: implement me

    input_file = "./secret_recipe.txt"
    output_file = "./decoded_recipe.txt"

    # Loop over file, decode and output to new file
    with open(input_file, 'r') as in_file, open(output_file, 'w') as out_file:
        for ln in in_file:
            ingredient = decode_ingredient(ln.strip())

            out_file.write(f"{ingredient.amount} {ingredient.description}\n")
    
    print(f"Decoded recipe has been saved to {output_file}")


if __name__ == "__main__":
    main()
