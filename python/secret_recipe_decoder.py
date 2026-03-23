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


def decode_string(encoded_string):
    """Given a string named str, use the Caesar encoding above to return the decoded string."""
    decoded = ""
    for char in encoded_string:
        if char in ENCODING:
            decoded += ENCODING[char]
    else:
        decoded += char
    return decoded


def decode_ingredient(line):
    """Given an ingredient, decode the amount and description, and return a new Ingredient"""
    parts = line.split("#")
    encoded_amount = parts[0].strip()
    encoded_description = parts[1].strip()
    
    decoded_description = decode_string(encoded_description)
    
    return Ingredient("1 cup", decoded_description)


def main():
    """A program that decodes a secret recipe"""
    with open("secret_recipe.txt", "r") as file:
        lines = file.readlines()
    with open("decoded_recipe.txt", "w") as output:
        for line in lines:
            ingredient = decode_ingredient(line)
            output.write(f"{ingredient.amount} {ingredient.description}\n")

if __name__ == "__main__":
    main()
