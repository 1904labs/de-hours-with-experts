#!/usr/bin/python3
import pydoc
import string
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
    '/': '/'
 }

"""An ingredient has an amount and a description.
For example: an Ingredient could have "1 cup" as the amount and "butter" as the description."""
class Ingredient():
    def __init__(self, amount, description) -> None:
        self.amount = amount
        self.description = description


def decode_string(str, ENCODING):
    """Given a string named str, use the Caesar encoding above to return the decoded string."""
    # TODO: implement me
#1 create an empty string for the result
    decoded_string = ""
#2 loop through string
    for char in str:
#3 for each letter/key, append the corresponding value into a decoded list
        decoded_string = decoded_string + ENCODING[char]
#4 return the decoded list
    return decoded_string


def decode_ingredient(line, ENCODING):
    """Given an ingredient, decode the amount and description, and return a new Ingredient"""
#1 create an empty string for the decoded_measurement
    decoded_measurement = ""
#2 split the line at the "#" save the measurement as measure and the ingredient as str
    with open('secret_recipe.txt', 'r') as f:
        split_line = f.split("#")
    measurement = split_line[0]
    str = split_line[1]
#3 add a space and a "/" to the dictionary(ENCODING) above, having them equal themselves
#5 call decode_string w/ string as decoded_string
    decode_string(str, ENCODING)
#6 loop through in measurement
    for char in measurement:
#7 for each letter/key, append the corresponding value into decoded_measurement
        decoded_string = decoded_string + ENCODING[char]
#8 return decoded_measurement, decoded_string
        return decoded_measurement, decoded_string


def main():
    """A program that decodes a secret recipe"""
#1 open with (r, 'secret_recipe.txt) current code opens the file....but not line by line
    
#2 loop through the lines
        
#call decode_ingredient for each line
            

if __name__ == "__main__":
    main()

with open('secret_recipe.txt', 'r') as f:
    for line in f:
        print(decode_ingredient(line, ENCODING))