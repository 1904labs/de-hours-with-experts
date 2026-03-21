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
    # turn string into array, loop through, get value from keys, return string

    broken_str = list(str)
    fixed_str = list()

    for char in broken_str:
        if char == ' ':
            fixed_str.append(char)
        else:
            encoded_str = ENCODING[char]
            fixed_str.append(encoded_str)

    joined = ''.join(fixed_str)

    return print(joined)


def decode_ingredient(line):
    """Given an ingredient, decode the amount and description, and return a new Ingredient"""
    # use code from previous function to help decode entire line. # signals a breakpoint
    # TODO: implement me

    broken_line = list(line)
    measurement = list()
    fixed_line = list()
    hash_position = 1

    for char in broken_line:
        if char == '#':
            break
        elif char == ' ':
            measurement.append(char)
            hash_position += 1
        else:
            encoded_str = ENCODING[char]
            measurement.append(encoded_str)
            hash_position += 1

    amount = ''.join(measurement)

    for char2 in broken_line[hash_position:]:
        if char2 == ' ' or ',':
            fixed_line.append(char2)
        else:
            encoded_line = ENCODING[char2]
            fixed_line.append(encoded_line)

    description = ''.join(fixed_line)

    # full_line = Ingredient(x, y)
    return print(description)
    # return Ingredient("1 cup", "butter")


def main():
    """A program that decodes a secret recipe"""
    # print(ENCODING.items())
    # print(ENCODING['y'])
    # TODO: implement me

    decode_string("8 vgl")
    decode_ingredient("8 vgl#hgiikf")


if __name__ == "__main__":
    main()
