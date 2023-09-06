#!/usr/bin/python3
import os
import pydoc
import sys

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


def decode_string(str):
    """Given a string named str, use the Caesar encoding above to return the decoded string."""
    for char in str:
        if char in ENCODING:
            str = str.replace(char, ENCODING[char])
    return str


def decode_ingredient(line):
    """Given an ingredient, decode the amount and description, and return a new Ingredient"""
    # split line on '#' character
    parts = line.split("#")
    # decode amount (parts[0])
    amount = decode_string(parts[0])
    # decode description (parts[1])
    description = decode_string(parts[1])
    return Ingredient(amount, description)


def main():
    """A program that decodes a secret recipe"""
    # open recipe file
    with open("secret_recipe.txt", "r") as f:
        recipe = f.read()
    # decode recipe into a string
    decoded_recipe = ""
    for line in recipe.split("\n"):
        if line:
            ingredient = decode_ingredient(line)
            # save decoded recipe in desired format
            decoded_recipe += ingredient.amount + " " + ingredient.description + "\n"
    # write decoded recipe to file
    with open("decoded_recipe.txt", "w") as f:
        f.write(decoded_recipe)


if __name__ == "__main__":
    main()
