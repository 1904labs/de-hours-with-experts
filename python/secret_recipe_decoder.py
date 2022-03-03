#!/usr/bin/python3
from ast import AsyncFunctionDef
from base64 import decode
from fileinput import close
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
    ',': ',',
    '\n':'\n',
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
    """Given a string named str, use the Caesar encoding above to return the decoded string."""
    # TODO: implement me

    list = []

    for i in range(len(str)):
        list.append(ENCODING[str[i]]) 

    decodedString =''.join(list)
    return decodedString

print(decode_string("hgiikf"))


def decode_ingredient(line):
    """Given an ingredient, decode the amount and description, and return a new Ingredient"""
    # TODO: implement me

    ## i added a blank space to the ditionary to account for spacing to make things easier 

    entire_line =line.split("#")
    amount_encoded = entire_line[0]
    description_encoded = entire_line[1]
    i1 = Ingredient(decode_string(amount_encoded), decode_string(description_encoded))
    return decode_string(amount_encoded) + " " + decode_string(description_encoded)


print(decode_ingredient("8 vgl#hgiikf"))

def main():
    """A program that decodes a secret recipe"""
    # TODO: implement me

    encoded_recipe = open("./secret_recipe.txt", "r")
    # decoded_recipe = open("./decoded_recipe.txt", "x")
    temp_text = ""

    encoded_recipe.readline()

    file = open("decoded_recipe.txt", "w")
    
    for x in encoded_recipe:
        file.write(decode_ingredient(x))

    file.close()

        



if __name__ == "__main__":
    main()
