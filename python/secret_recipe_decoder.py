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
    '6': '9',
    ' ': ' ',
    '#': ' ',
    '/':'/',
    '-':'-'
 }

"""An ingredient has an amount and a description.
For example: an Ingredient could have "1 cup" as the amount and "butter" as the description."""
class Ingredient():
    def __init__(self, amount, description) -> None:
        self.amount = amount
        self.description = description


def decode_string(str):
    result = ''
    letter = ''

    for c in str:
        letter += c
        if letter in ENCODING:
            result +=ENCODING[letter]
            letter = ''

    return result


def decode_ingredient(line):
    line = decode_string(line)
    Ingredient = line
    """Given an ingredient, decode the amount and description, and return a new Ingredient"""
    return Ingredient

        
               

def main():
    txt_file = ('secret_recipe.txt')
    with open(txt_file) as recipe:
        lines = recipe.readlines()
    recipe = lines
    for i in recipe:
        x = (i)
        for l in x:
            secret_recipe = decode_ingredient(x)
        print(secret_recipe)
    
    """A program that decodes a secret recipe"""

if __name__ == "__main__":
    main()
    
