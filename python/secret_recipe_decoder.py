#!/usr/bin/python3
import pydoc
import sys
import os

f = open('secret_recipe.txt','r')
print(f)
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

    def __repr__(self) -> str: 
        return f"{self.amount} {self.description}"
    
def decode_string(str):
    """Given a string named str, use the Caesar encoding above to return the decoded string."""
    # TODO: implement me
    result = ''
    for character in str:
        if character in ENCODING:
            result = result + ENCODING[character]
        else:
            result = result + character
    return result

def decode_ingredient(line):
    """Given an ingredient, decode the amount and description, and return a new Ingredient"""
    # TODO: implement me
    split_line = line.split('#')
    amount = decode_string(split_line[0])
    description = decode_string(split_line[1])
    return Ingredient(amount,description)
       
print(str(decode_ingredient('8 vgl#hgiikf')))

def main():
    """A program that decodes a secret recipe"""
    # TODO: implement me
    contents = []
    with open('secret_recipe.txt') as f:
        contents = f.readlines()
        print(contents)
    
        #for item in contents:
    with open('decoded_recipe.txt', "w") as f:
        for item in contents:
            line = str(decode_ingredient(item))
            f.write(line)
            f.close
            #g.writelines('\n')
                
            #print(str(decode_ingredient(item)))
            
if __name__ == "__main__":
    main()