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

    chars = []
    for character in str:
        if character.isalnum():
            decoded_char = character.replace(character, ENCODING[character])
            chars.append(decoded_char)
        else:
            chars.append(character)

    # This approach doesn't work. It changes ALL of the letters within the string if they are the same
    # for letter in str:
    #     if letter.isalnum():
    #         str = str.replace(letter, ENCODING[letter])

    return ''.join(chars)

def decode_ingredient(line):
    """Given an ingredient, decode the amount and description, and return a new Ingredient"""
    # TODO: implement me
    amount = line.split('#')[0]
    description = line.split('#')[1]

    # Decoding amount
    amount = decode_string(amount)

    # Decoding description
    description = decode_string(description)

    return Ingredient(amount=amount, description=description)

def main():
    """A program that decodes a secret recipe"""
    # TODO: implement me
    try:
        with open('secret_recipe.txt', 'r') as recipes:
            try:
                with open('decoded_recipe.txt', 'w') as output:
                    for recipe in recipes:
                        output.write(f"{decode_ingredient(recipe).amount} {decode_ingredient(recipe).description}")
            except FileNotFoundError:
                print("Error creating/opening 'decoded_recipe.txt' file")
    except FileNotFoundError:
        print("'secret_recipe.txt' file does not exist!")

if __name__ == "__main__":
    main()