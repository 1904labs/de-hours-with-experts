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
    # for each encoded str, loop through it, get its corresponding de-coded char?
    decoded_str = ''
    for c in str:
        if c.isalpha() or c.isdigit():
            decoded_str += ENCODING[c]
        else:
            decoded_str += c
            
    
    return decoded_str

# print (decode_string('hgiikf'))

def decode_ingredient(line):
    """Given an ingredient, decode the amount and description, and return a new Ingredient"""
    # TODO: implement me
    # decode each line, separate the amount and description and creat new Ingredient instance

    decoded_line = decode_string(line)
    amount, description = decoded_line.split('#')
    new_ingredient = Ingredient(amount, description)

    return new_ingredient

def main():
    """A program that decodes a secret recipe"""
    # TODO: implement me
    # read, get each line of recipe instruction, decode
    new_file = open('decoded_recipe.txt', 'w')
    
    with open('secret_recipe.txt', 'r') as recipe_file:
        lines = recipe_file.readlines()
        for line in lines:
            print (line)
            new_ingredient = decode_ingredient(line)
            decoded_line =  new_ingredient.amount + ' ' + new_ingredient.description
            new_file.write(decoded_line)



main()