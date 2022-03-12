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
    str_len = len(str)
    plain_text_list = [None] * str_len

    for i in range(str_len):
        if str[i].isalnum():
            plain_text_list[i] = ENCODING[str[i].lower()]
        else:
            plain_text_list[i] = str[i]

    return ''.join(plain_text_list)
    # return '1 cup'


def decode_ingredient(line):
    """Given an ingredient, decode the amount and description, and return a new Ingredient"""
    # TODO: implement me
    line_as_list = line.split("#")

    description = decode_string(line_as_list[0])
    amount = decode_string(line_as_list[1])

    return Ingredient(description, amount)
    # return Ingredient("1 cup", "butter")


def main():
    """A program that decodes a secret recipe"""
    # TODO: implement me
    with open("secret_recipe.txt") as cipher_file:
        lines = cipher_file.readlines()
        with open("decoded_recipe.txt", "a") as plain_file:
            for line in lines:
                ingredient = decode_ingredient(line)
                plain_file.write(ingredient.amount + ingredient.description)


if __name__ == "__main__":
    main()
