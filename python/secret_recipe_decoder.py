#!/usr/bin/python3
import pydoc
import sys
import os
from concurrent.futures import ThreadPoolExecutor

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


def decode_string(str) -> str:
    """Given a string named str, use the Caesar encoding above to return the decoded string."""
    with ThreadPoolExecutor() as executor:
        decoded_chars = list(executor.map(lambda c: ENCODING.get(c, c), str))
    return ''.join(decoded_chars)


def decode_ingredient(line):
    """Given an ingredient, decode the amount and description, and return a new Ingredient"""
    encoded_amount, encoded_description = line.split('#')

    decoded_amount = decode_string(encoded_amount)
    decoded_description = decode_string(encoded_description)
    
    return Ingredient(decoded_amount, decoded_description)

ingredient = decode_ingredient("8 vgl#hgiikf")
print(ingredient.amount, ingredient.description)



def main():
    """A program that decodes a secret recipe"""
    input_path = "secret_recipe.txt"
    output_path = "decoded_recipe.txt"

    # 1. Read lines (fast sequential I/O)
    with open(input_path, 'r', encoding='utf-8') as f:
        lines: list[str] = [ln.strip() for ln in f if ln.strip()]

    # 2. Decode all lines in parallel across processes
    with ThreadPoolExecutor() as pool:
        decoded: list[Ingredient] = list(pool.map(decode_ingredient, lines))

    # 3. Write all results at once (fast sequential I/O)
    with open(output_path, 'w', encoding='utf-8') as outfile:
        for ing in decoded:
            # Use the defined __str__ or explicit formatting:
            outfile.write(f"{ing.amount} {ing.description}\n")


if __name__ == "__main__":
    main()
