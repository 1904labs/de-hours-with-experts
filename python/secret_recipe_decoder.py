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
# Define the Ingredient class with an amount and a description
class Ingredient():
    def __init__(self, amount, description) -> None:
        self.amount = amount
        self.description = description

# Function that decodes a string using the Caesar encoding
def decode_string(str):
    # Initialize an empty decoded string
    decoded_str = ""
    # Iterate through each character in the input string
    for char in str:
        # Get the decoded character from the encoding dictionary
        decoded_char = ENCODING.get(char)
        # Append the decoded character to the decoded string
        decoded_str += decoded_char
    return decoded_str

# Function that decodes an ingredient line and returns an Ingredient object
def decode_ingredient(line):
    decoded_amount = ""
    decoded_description = ""
    
    # Decode the amount part of the ingredient line
    for char in line:
        if char == "#":
            str_length = len(decoded_amount)
            break
        else:
            if char == " " or char is None:
                decoded_amount += "~"
            else:
                decoded_char = ENCODING.get(char)
                if decoded_char is not None:
                    decoded_amount += decoded_char
                else:
                    decoded_amount += char

    # Decode the description part of the ingredient line
    for char in line[str_length+1:]:
        if char == " " or char is None:
            decoded_description += "~"
        else:
            decoded_char = ENCODING.get(char)
            if decoded_char is not None:
                decoded_description += decoded_char
            else:
                decoded_description += char

    return Ingredient(decoded_amount, decoded_description)

def main():
    """A program that decodes a secret recipe"""
  
    # Define input and output file paths
    input_file_path = 'secret_recipe.txt'
    output_file_path = 'decoded_recipe.txt'

    # Open the input file for reading and the output file for writing
    with open(input_file_path, 'r') as input_file:
        with open(output_file_path, 'w') as output_file:
            # Loop through each line in the input file
            for line in input_file:
                # Decode the ingredient line and create an Ingredient object
                ingredient = decode_ingredient(line)
                # Combine the decoded amount and description with a space separator
                decoded_line = (ingredient.amount+" "+ingredient.description)
                # Replace tilde characters with spaces in the decoded line
                decoded_line_no_tilde = decoded_line.replace('~', ' ')
                # Write the decoded line to the output file
                output_file.write(decoded_line_no_tilde)

if __name__ == "__main__":
    main()
