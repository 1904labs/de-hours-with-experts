#!/usr/bin/python3
import pydoc
import sys
import os
import pytest

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


def encode_string(str):
    """Given a string named str, use the Caesar encoding above to return the decoded string."""
    # TODO: implement me
    reversed_encoding = {value : key for (key, value) in ENCODING.items()}
    word=[]
    for character in str:
        if character not in reversed_encoding.keys():
            pass
        else:
            word.append(reversed_encoding.get(character))
    word=''.join(word)
    return word

def decode_string(str):
    # TODO: implement me
    word=[]
    for character in str:
        if character not in ENCODING.keys():
            pass
        else:
            word.append(ENCODING.get(character))
    word=''.join(word)
    return word

def decode_ingredient(line):
    """Given an ingredient, decode the amount and description, and return a new Ingredient"""
    # TODO: implement me
    word=[]
    for character in line:
        if character not in ENCODING.keys():
            ENCODING[character]=character
        if character==character:
            word.append(ENCODING.get(character))
    word=''.join(word)
    word=word.split("#")
    return Ingredient(str(word[0]),str(word[1]))

def main():
    """A program that decodes a secret recipe"""
    # TODO: implement me

if __name__ == "__main__":
    main()
