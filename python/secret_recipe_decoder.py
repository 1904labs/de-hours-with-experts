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
    decode='' #empty string to store decoded string
    for char in str:
        if char in ENCODING:
            decode += ENCODING[char]
        else:
            decode += char
    return decode


def decode_ingredient(line):
#     """Given an ingredient, decode the amount and description, and return a new Ingredient"""
#     # TODO: implement me
    decoded_line = ''
    for char in line:
        if char in ENCODING:
            decoded_line += ENCODING[char]
        else:
            decoded_line += char

    # Replace # with space if needed
    decoded_line = decoded_line.replace('#', ' ')

    parts = decoded_line.split(' ', 1)
    amount = parts[0]
    description = parts[1] if len(parts) > 1 else ''
    return f"{amount} {description}"


def main():
     """A program that decodes a secret recipe"""
     # TODO: implement me
     print(decode_string("hgiikf"))
     print(decode_ingredient("8 vgl#hgiikf"))

if __name__ == "__main__":
     main()
