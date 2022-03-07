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
    """Given a string named str, use the Caesar encoding above to return the decoded string."""
    # TODO: implement me
    result = ""
    char = 1
    last_char = str[0]
    
    for i in range(1, len(str)):
        if last_char == str[i]:
            char += 1
        else:
            result += str(char) + last_char
            char = 0
            last_char = str[i]
            char += 1
    result += str(char) + last_char
    return result

def decode_ingredient(line):
    """Given an ingredient, decode the amount and description, and return a new Ingredient"""
    # TODO: implement me
    i = 0
    with open("secret_recipe.txt", "r") as file:
        for word in file:
            i = i + 1
            if line in word:
                print(i)

def main():
    """A program that decodes a secret recipe"""
    # TODO: implement me
    file1 = open("secret_recipe.txt", "r")
    secret_recipe = file1.read()

    with open("decoded_recipet.txt", "a+") as secret_recipe:
        secret_recipe.seek(0)
        data = secret_recipe.read()
        if len(data) > 0:
            secret_recipe.write("\n")
        secret_recipe.write(decode_string, decode_ingredient)

if __name__ == "__main__":
    main()
