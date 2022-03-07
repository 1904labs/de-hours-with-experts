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
    decoded_string= ""
    for char in str.lower():
        if char in ENCODING.keys():
            d_letter = ENCODING[char]
        decoded_string += d_letter
            
    return decoded_string


def decode_ingredient(line):
    """Given an ingredient, decode the amount and description, and return a new Ingredient"""
    # TODO: implement me
    Ingredient = ''
    for char in line.lower():
        if char in ENCODING.keys():
            new_char = ENCODING[char]
        elif char == '#':
            new_char = ', '    
        else:
            new_char = ' '
        Ingredient += new_char
    return Ingredient


def main():
    """A program that decodes a secret recipe"""
    # TODO: implement me
    file = open('secret_recipe.txt','r')
    lines = file.readline()

    with open ('decoded_recipe.txt','w') as f:
        for line in lines:
            new_line = decode_ingredient(line)
            f.write(new_line)
            f.write('\n')  

if __name__ == "__main__":
    main()
