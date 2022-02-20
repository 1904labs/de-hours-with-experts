#!/usr/bin/python3
import pydoc
import sys
import os

# Caesar encoding, for use with decoding below
ENCODING = {
    'a': 'y',
    'b': 'h',
    'c': 'v',
    'd': 'x',
    'e': 'k',
    'f': 'p',
    'g': 'z',
    'h': 's',
    'i': 'a',
    'j': 'b',
    'k': 'e',
    'l': 'w',
    'm': 'u',
    'n': 'q',
    'o': 'n',
    'p': 'l',
    'q': 'm',
    'r': 'f',
    's': 'o',
    't': 'i',
    'u': 'g',
    'v': 'j',
    'w': 't',
    'x': 'd',
    'y': 'r',
    'z': 'c',
    '0': '3',
    '1': '8',
    '2': '4',
    '3': '0',
    '4': '2',
    '5': '7',
    '6': '5',
    '7': '9',
    '8': '1',
    '9': '6'
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


def decode_ingredient(line):
    """Given an ingredient, decode the amount and description, and return a new Ingredient"""
    # TODO: implement me


def main():
    """A program that decodes a secret recipe"""
    # TODO: implement me

if __name__ == "__main__":
    main()
