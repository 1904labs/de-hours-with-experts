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
        self.amount = amount # this stores the ingredient's amount
        self.description = description # this stores the ingredient's description

def decode_string(str):
    """Given a string named str, use the Caesar encoding above to return the decoded string."""
    for char in str: # ok, so for every character that is in the string, follow this conditional logic:
        if char in ENCODING: # if the charater is up there in the ENCODING dict,
            str = str.replace(char, ENCODING[char]) # replace that charater with the corresponding value from the dict
    return str # and then return that newly decoded string
# okay, so coding challenge #1 (I think) is done. at least, pytest seems happy.

def decode_ingredient(line):
    """Given an ingredient, decode the amount and description, and return a new Ingredient"""
    amount, description = line.split("#") # splits the line at the delimiter
    decoded_amount = decode_string(amount) # decodes the amount
    decode_description = decode_string(description) # decodes the description
    return Ingredient(decoded_amount, decode_description)
# it looks like coding challenge #2 is working.
    
    
# now for coding challenge #3
# TODO: CODING CHALLENGE #3

# alright, so the README says that this function takes a line from the recipe and returns a new Ingredient (a class already defined for me).
# aha! there's a secret_recipe.txt. That took me WAY too long to notice. Good thing I'm recording all my stream of consciousness in comments. Is that how you spell that?
# if the line has a # in it, that's the mark (delimiter) betwixt the amount and the description.
# so let's get the amount and the description, and then return a new Ingredient. Easy, right?

def main():
    """A program that decodes a secret recipe"""
    # TODO: implement me

    
if __name__ == "__main__":
    main()
