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

#********* PART ONE *************#

def decode_string(str):
    """Given a string named str, use the Caesar encoding above to return the decoded string."""
    # TODO: implement me
    
    res = ""

    for i in str:
        res += ENCODING[i]
    # print(res)
    return res

decode_string("hgiikf")


#*********PART TWO **************#

"""An ingredient has an amount and a description.
For example: an Ingredient could have "1 cup" as the amount and "butter" as the description."""
class Ingredient():
    def __init__(self, amount, description) -> None:
        self.amount = amount
        self.description = description


def decode_ingredient(text): 
    """Given a string containing an instance of Class Ingredient, decode, parse and assign
    as the relevant objects."""

    for c in text:
        decoded = "".join(str(ENCODING[c]) if c in ENCODING else c for c in text)
        amount = decoded.split("#")[0]
        description = decoded.split("#")[-1]
    # print(f"a: {amount}, d: {description}")
   
    return Ingredient(amount, description)

decode_ingredient("8 vgl#xyfe hfntq ogzyf, lyvekx")

#*********PART THREE************#

#Struggled to leverage decode_ingredient(), cheated with quick and dirty solution. Submitting this now, may revisit if time allows.
#Kept getting memory address written in place of string

def main(): 
    """A program that decodes a secret recipe"""

    with open("python/secret_recipe.txt", "r") as encoded_recipe:

        with open("python/decoded_recipe.txt", "w") as decoded_recipe: 

            for line in encoded_recipe:
                text = "".join(str(ENCODING[c]) if c in ENCODING else c for c in line)
                amount = text.split("#")[0]
                description = text.split("#")[-1]
                recipe_line = amount + " " + description
                decoded_recipe.write(recipe_line)
            return decoded_recipe
        
if __name__ == "__main__":
    main()