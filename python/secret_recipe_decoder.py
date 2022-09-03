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
    # TODO: implement me
    result = ''

    for c in str:
        translation = ENCODING[c]
        result += translation
    return result


def decode_ingredient(line):
    """Given an ingredient, decode the amount and description, and return a new Ingredient"""
    # TODO: implement me 
    translated = decode_string(line)

    num = translated.split(' ')[0]
    desc = translated.split(' ')[1]

    return Ingredient(num, desc)


def main():
    """A program that decodes a secret recipe"""
    # TODO: implement me
    ingredients = []

    for line in sys.stdin:
        ingredients.append(decode_ingredient(line))
    for ingredient in ingredients:
        print(f"{ingredient.amount} {ingredient.description}")


if __name__ == "__main__":
    main()
