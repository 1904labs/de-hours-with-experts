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
"""read a given file and store in variable"""
def read_file(filename):
    # Get the directory of the current script or executable
    dir_path = os.path.dirname(os.path.realpath(__file__))
    
    # Construct the full path to the file
    file_path = os.path.join(dir_path, filename)
    
    # Open the file and read its contents
    with open(file_path, 'r') as file:
        content = file.read()
    return content
text_body = read_file('secret_recipe.txt')

def decode_string(str):
    """Given a string named str, use the Caesar encoding above to return the decoded string."""
    # Create the decryption dictionary
    DECODING = {v: k for v, k in ENCODING.items()}
    #Build decrpyted string
    decrypted_string = ''.join([DECODING.get(char, char) for char in str])
    return decrypted_string

#print(decode_string(text_body))


def decode_ingredient(line):
    """Given an ingredient, decode the amount and description, and return a new Ingredient"""
    decoded_string=decode_string(line)
    #print(decoded_string)
    #Set Ingredient fields
    amount, description = decoded_string.split('#')   
    return Ingredient(amount, description)
#print(decode_string(text_body))

def main():
    """A program that decodes a secret recipe"""
    # Wrote tp File
orig_string  = decode_string(text_body)
mod_string = orig_string.replace("#"," ")
with open('decoded_recipe.txt', 'w') as file:
    file.write(mod_string)
if __name__ == "__main__":
    main()
