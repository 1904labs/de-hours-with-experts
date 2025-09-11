#!python3
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


def decode_string(cipher) -> int:
    """Given a string named cipher, use the Caesar encoding above to return the decoded string."""
    # Changed str to cipher, to not override Python's str
    # Decode convertable characters and leave the rest unchanged
    plain = [ENCODING[char] if char in ENCODING else char for char in cipher]
    return ''.join(plain)


def decode_ingredient(line):
    """Given an ingredient, decode the amount and description, and return a new Ingredient"""
    # This is assuming the [amount#description] format stays the same
    decoded = decode_string(line)
    words = decoded.split('#')
    return Ingredient(words[0], words[1])


def main():
    """A program that decodes a secret recipe"""
    # with [...] is a recommended practice for working with files
    with open(os.path.join(sys.path[0], "secret_recipe.txt"), "r") as secret:
        with open(os.path.join(sys.path[0], "decoded_recipe.txt"), "w") as newFile:
            for line in secret:
                newLine = decode_ingredient(line)
                newFile.write(f"{newLine.amount} {newLine.description}")
    return 0

if __name__ == "__main__":
    main()
