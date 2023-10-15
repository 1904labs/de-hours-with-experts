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


def decode_string(encoded_string):
    """Given a string named str, use the Caesar encoding above to return the decoded string."""
    # Declare the variable from the decoding response stored 
    response = []
    for letter  in encoded_string:
        # The purpose is to leave the charaters which are not in encoding as the same format
        if letter not in ENCODING.keys():
            response.append(letter)
        else:
            response.append(ENCODING[letter])

    return "".join(response)


def decode_ingredient(line):
    """Given an ingredient, decode the amount and description, and return a new Ingredient"""
    # Using # to separate the quanitity and ingredient
    encoded_quantity = line.split("#")[0]
    encoded_ingredient = line.split("#")[1]
    # Make it return the quantity and ingredient
    return Ingredient(decode_string(encoded_quantity), 
                      decode_string(encoded_ingredient))


def main(recipe_path):
    """A program that decodes a secret recipe"""
    # Where you can open and read the file
    with open(recipe_path, "r") as f:
      lines = f.readlines()

    recipe = []
    for line in lines:
      recipe.append(decode_ingredient(line))
    # Return the objects and string of the recipe
    return(
        {"recipe_objects": recipe, 
            "recipe_text": "".join([f"amount: {ingredient.amount}, item: {ingredient.description}" for ingredient in recipe])})


if __name__ == "__main__":
    main()

    
