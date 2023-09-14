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

    def toStr(self):
         return self.amount + " " + self.description


def decode_string(str):
    """Given a string named str, use the Caesar encoding above to return the decoded string."""
    # TODO: implement me
    decoded = ""
    for ch in str:
        if ch in ENCODING:
             decoded = decoded + ENCODING[ch]
             continue
        if ch == "\n":
                continue 
        decoded = decoded + ch
        # add ENCODiNG[ch] to decoded
    print(decoded)
    return decoded


def decode_ingredient(line):
    """Given an ingredient, decode the amount and description, and return a new Ingredient"""
    # TODO: implement me
    splitline = line.split('#')
    print(splitline)
    amount = decode_string(splitline[0])
    description =decode_string(splitline[1])
    return Ingredient(amount, description)


def main():
    """A program that decodes a secret recipe"""
    # decode_string('hgiikf')
    # decode_ingredient('8 vgl#hgiikf')

    # Open files
    inputfile = open("python/secret_recipe.txt", "r")
    outputfile = open("decoded_recipe.txt", "w")

    # For each line in the input file
    for line in inputfile:
        print("input: " + line)
        # get the decoded ingredient using our function from step 2
        ingredient = decode_ingredient(line)
        # write the decoded ingredient to a new line in the output file
        outputfile.write(ingredient.toStr() + "\n")
        print("output" + ingredient.toStr())

    # Close files
    inputfile.close()
    outputfile.close()

if __name__ == "__main__":
    main()

