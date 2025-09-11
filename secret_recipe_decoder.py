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
    decoded = "".join(ENCODING.get(ch, ch) for ch in str)
    return decoded



def decode_ingredient(line):
    """Given an ingredient, decode the amount and description, and return a new Ingredient"""
    # TODO: implement me
 # Split on "#" to separate amount and description
    parts = line.split("#")
    amount_encoded = parts[0]
    description_encoded = parts[1] if len(parts) > 1 else ""
     # Decode both
    amount_decoded = decode_string(amount_encoded)
    description_decoded = decode_string(description_encoded)

    return Ingredient(amount_decoded, description_decoded)


def main():
    """A program that decodes a secret recipe"""
    # TODO: implement me
    ingredients=['8 vgl#hgiikf','8 vgl#xyfe hfntq ogzyf, lyvekx','8 vgl#zfyqgwyikx ogzyf', '4#kzzo','8 ikyolnnq#jyqawwy','4 8/4 vglo#nyiukyw','4 vglo#pwngf','8/4 ikyolnnq#oywi','8 ikyolnnq#hyeaqz onxy','8 ikyolnnq#hyeaqz lntxkf','84 ngqvko#vsnvnwyik vsalo','8#2-ngqvk uawe vsnvnwyik hyf','8 8/4 vglo#vsnllkx qgio']
    for ingredient in ingredients:
        decoded_ingredient = decode_ingredient(ingredient)
        print(f"{decoded_ingredient.amount} {decoded_ingredient.description}")

if __name__ == "__main__":
    main()
