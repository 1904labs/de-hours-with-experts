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
    #Goes through each letter and decodes them
    decoded_str = ''
    for char in str:
        if char in ENCODING:
            decoded_str += ENCODING[char]
        else:
            decoded_str += char
    return decoded_str


def decode_ingredient(line):
    """Given an ingredient, decode the amount and description, and return a new Ingredient"""
    #Parts becomes and array with 2 parts of line
    parts = line.split('#', 1)
    amount = decode_string(parts[0])
    description = decode_string(parts[1])
    return Ingredient(amount, description)


def main():
    #Changes Directory
    os.chdir('python')

    
    try:
        #Opens and decodes secret_recipe.txt
        with open("secret_recipe.txt", "r") as f:
            decoded_ingredients = [decode_ingredient(line.strip()) for line in f]

        #Writes decoded recipe to decoded_recipe.txt
        with open("decoded_recipe.txt", "w") as j:
            for ingredient in decoded_ingredients:
                j.write(f"{ingredient.amount} {ingredient.description}\n")

        print("Recipe successfully decoded and saved to 'decoded_recipe.txt'")
    except FileNotFoundError:
        print("File 'secret_recipe.txt' not found.")



if __name__ == "__main__":
    main()
