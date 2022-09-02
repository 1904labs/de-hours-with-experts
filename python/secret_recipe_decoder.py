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


def decode_string(string):
    """Given a string named str, use the Caesar encoding above to return the decoded string."""
    decoded_string = []
    for i in string:
        if i.isalnum():
            decoded_string.append(ENCODING[i])
        else:
            decoded_string.append(i)
    return ''.join(decoded_string)


def decode_ingredient(line):
    """Given an ingredient, decode the amount and description, and return a new Ingredient"""
    line_array = line.split('#')
    amount = decode_string(''.join(line_array[0]))
    description = decode_string(''.join(line_array[1]))
    return Ingredient(amount, description)


def main():
    """A program that decodes a secret recipe"""
    with open("secret_recipe.txt", 'r') as file:
        ingredients = []
        for i in file.readlines():
            ingredients.append(decode_ingredient(i.strip()))

    with open("decoded_recipe.txt", 'w') as file:
        for i in ingredients:
            file.write(' '.join([i.amount, i.description, '\n']))


if __name__ == "__main__":
    main()
