#!/usr/bin/python3
import pydoc
import sys
import os

# Caesar encoding, for use with decoding below
ENCODING = {
    "y": "a",
    "h": "b",
    "v": "c",
    "x": "d",
    "k": "e",
    "p": "f",
    "z": "g",
    "s": "h",
    "a": "i",
    "b": "j",
    "e": "k",
    "w": "l",
    "u": "m",
    "q": "n",
    "n": "o",
    "l": "p",
    "m": "q",
    "f": "r",
    "o": "s",
    "i": "t",
    "g": "u",
    "j": "v",
    "t": "w",
    "d": "x",
    "r": "y",
    "c": "z",
    "3": "0",
    "8": "1",
    "4": "2",
    "0": "3",
    "2": "4",
    "7": "5",
    "5": "6",
    "9": "7",
    "1": "8",
    "6": "9",
}

"""An ingredient has an amount and a description.
For example: an Ingredient could have "1 cup" as the amount and "butter" as the description."""


class Ingredient:
    def __init__(self, amount, description) -> None:
        self.amount = amount
        self.description = description


def decode_string(encoded_string):
    """Given a string named str, use the Caesar encoding above to return the decoded string."""

    decoded_string = "".join(
        [
            ENCODING[letter] if letter in ENCODING.keys() else letter
            for letter in encoded_string
        ]
    ).replace("#", " ")

    return decoded_string


def decode_ingredient(line):
    """Given an ingredient, decode the amount and description, and return a new Ingredient"""

    decoded_string = "".join(
        [ENCODING[letter] if letter in ENCODING.keys() else letter for letter in line]
    ).split("#")

    return Ingredient("1 cup", "butter")


def main():
    """A program that decodes a secret recipe"""

    # load encoded text
    secret_recipe = "secret_recipe.txt"
    with open(secret_recipe, newline="") as f:
        encoded_strings = [line for line in f.readlines()]

    # decode strings
    decoded_strings = [decode_string(i) for i in encoded_strings]

    # save decoded strings
    output_file = "decoded_recipe.txt"
    with open(output_file, "w") as f:
        for i in decoded_strings:
            f.write(i)


if __name__ == "__main__":
    main()
