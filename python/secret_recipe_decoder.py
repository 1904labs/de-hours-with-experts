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
    dec_string = []
    for i in string:
        if i.isalpha():
            dec_string.append(ENCODING[i])
        elif i.isdigit():
            dec_string.append(ENCODING[i])
        else:
            dec_string.append(i)
    return ''.join(dec_string)


def decode_ingredient(line):
    """Given an ingredient, decode the amount and description, and return a new Ingredient"""
    arr = line.split('#')
    amount = decode_string(''.join(arr[0]))
    desc = decode_string(''.join(arr[1]))
    return Ingredient(amount, desc)


def main():
    """A program that decodes a secret recipe"""
    with open("secret_recipe.txt", 'r') as file:
        ings = []
        for i in file.readlines():
            ings.append(decode_ingredient(i.strip()))

    with open("decoded_recipe.txt", 'w') as file:
        for i in ings:
            file.write(' '.join([i.amount, i.description, '\n']))


if __name__ == "__main__":
    main()
