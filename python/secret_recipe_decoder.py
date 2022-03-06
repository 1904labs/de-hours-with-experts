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


def decode_string(enc_str):
    """Given a string named str, use the Caesar encoding above to return the decoded string."""
    dec_str = ''
    for c in enc_str:
        if c in ENCODING.keys():
            dec_str += ENCODING[c]
        else:
            dec_str += c
    return dec_str


def decode_ingredient(line):
    """Given an ingredient, decode the amount and description, and return a new Ingredient"""
    dec_amount, dec_description = list(map(decode_string, line.split('#')))
    return Ingredient(dec_amount, dec_description)


def main():
    """A program that decodes a secret recipe"""
    enc_file = open("python/secret_recipe.txt", "r")
    dec_file = open("python/decoded_recipe.txt", "a")
    for line in enc_file:
        ingredient = decode_ingredient(line)
        dec_file.write(ingredient.amount + " " + ingredient.description)
    enc_file.close()
    dec_file.close()
    

if __name__ == "__main__":
    main()
