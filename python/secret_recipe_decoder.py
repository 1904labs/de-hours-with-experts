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
    
    # Create new list variable that will hold the decoded characters
    decoded_list = []
    
    # Loop through each character
    for char in str:
        # If char in ENCODING, then decode
        if char in ENCODING:
            # For each character in str, decode with the key-value pair in Caesar encoding
            # Append decoded character to string
            decoded_list.append(ENCODING.get(char))
        else:
            # If not in ENCODING, then simply include char in string
            decoded_list.append(char)
    
    # Join all characters together
    decoded_str = ''.join(decoded_list)
    return decoded_str


def decode_ingredient(line):
    """Given an ingredient, decode the amount and description, and return a new Ingredient"""

    # Split line into strings
    strings = line.split('#')
    
    # Decode first string
    amount = decode_string(strings[0])    
    
    # Decode second string
    description = decode_string(strings[1])
    new_Ingredient = Ingredient(amount, description)
    return new_Ingredient


def main():
    """A program that decodes a secret recipe"""
    
    # Create list to hold lines of recipe
    recipe = []

    # Open up recipe text file
    with open("secret_recipe.txt") as fp:
        Lines = fp.readlines()
        for line in Lines:
            recipe.append(decode_ingredient(line))
            
    # Open up decoded recipe text file to write into
    with open('decoded_recipe.txt', 'w') as f:
        
        # Loop through each line of a recipe
        for line in recipe:
            # Place both ingredient and description into decoded recipe text file
            f.write(line.amount)
            f.write(' ')
            f.write(line.description)

if __name__ == "__main__":
    main()
