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
'''
In the main method, read all of the ingredients out of secret_recipe.txt, 
decode each ingredient (hopefully using the functions you implemented above), 
and save the output into a new file named decoded_recipe.txt.
'''

def main():
    """A program that decodes a secret recipe"""
    # TODO: implement me
    decoded_lines = []
    with open("secret_recipe.txt", "r") as input_file, open("decoded_recipe.txt", "w") as output_file:
            for line in input_file: # just iterating through the input file (secret_recipe.txt)
                line = line.strip() # removes the newline character and any other whitespace...because they're might be? I don't know, just being careful
                if line:
                    try:
                        ingredient = decode_ingredient(line)
                        decoded_lines.append(ingredient) # adds the ingredient object to the decoded_lines list
                        output_file.write(f"{ingredient.amount}#{ingredient.description}\n") # writes the decoded line to the new output file immediately
                    except ValueError:
                        print(f"Error: Invalid line '{line}'") # adds error handling for bad lines (which I know there won't be here)
                else:
                    print("Warning: Skipping empty line.") # adds a warning for empty lines (again, just for best practice or whatever)
    
if __name__ == "__main__":
    main()
