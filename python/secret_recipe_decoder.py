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
    fixed = ""
    for i in str:
        for x in ENCODING:
            if i == ' ':
                fixed = fixed + " "
                break
            elif i.lower() == x:
                fixed = fixed + ENCODING[x]
                break
            elif i not in ENCODING.keys():
                fixed = fixed + i
                break
    return fixed


def decode_ingredient(line):
    """Given an ingredient, decode the amount and description, and return a new Ingredient"""
    # TODO: implement me
    split = line.split('#')
    amount = decode_string(split[0])
    description = decode_string(split[1])
    newIngredient = Ingredient(amount, description)
    # newIngredient.amount = decode_string(split[0])
    # newIngredient.description = decode_string(split[1])
    return newIngredient


def main():
    """A program that decodes a secret recipe"""
    # TODO: implement me
    with open('secret_recipe.txt', 'r') as input:
        with open('decoded_recipe.txt', 'w') as output:
            for line in input:
                newIngredient = decode_ingredient(line)
                output.write(newIngredient.amount + ' ' + newIngredient.description)

if __name__ == "__main__":
    main()
print(decode_string('abc'))