#!/usr/bin/python3
import pydoc
import sys
import os
from collections import UserDict
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
    """Given a string named x, use the Caesar encoding above to return the decoded string."""
    # TODO: implement me
    decoded = ''
    for i in range(len(str)):
        if str[i] in ENCODING:
            decoded = decoded + ENCODING[str[i]]
        else:
            decoded = decoded + str[i]

    return decoded


def decode_ingredient(line):
    """Given an ingredient, decode the amount and description, and return a new Ingredient"""
    # TODO: implement me
    ingredient_list = []
    for i in range(len(line)):
        if line[i] == '#':
            ingredient_list = line.split("#")

    for i in range(len(ingredient_list)):
        x = decode_string(ingredient_list[i])
        ingredient_list[i] = x

    return Ingredient(ingredient_list[0], ingredient_list[1])


def main():
    """A program that decodes a secret recipe"""
    # TODO: implement me
    secret = open("secret_recipe.txt", "r")
    decoded = open("decoded_recipe.txt", "a")
    for i in secret:
        x = decode_ingredient(i)
        decoded.write(x.amount+" "+x.description)
    secret.close()
    decoded.close()

if __name__ == "__main__":
    main()
