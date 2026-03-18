import pydoc
import sys
import os

#Pranav Reddy Danda
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
    dstr=""
    for l in str:
      if l in ENCODING:
        dstr = dstr + ENCODING[l]
      else:
        dstr = dstr + l
    return dstr


def decode_ingredient(line):
    """Given an ingredient, decode the amount and description, and return a new Ingredient"""
    # TODO: implement me
    ln = line.split("#")
    amount = decode_string(ln[0])
    Ing = decode_string(ln[1])
    return Ingredient(amount, Ing)


def main():
    """A program that decodes a secret recipe"""
    # TODO: implement me
    f = open("./secret_recipe.txt","r")
    h = f.read()
    h1=h.split("\n")
    hkk=""
    for xx in h1:
        if(xx != ""):
            Ing = decode_ingredient(xx)
            hkk = hkk + f'{Ing.amount} {Ing.description}\n'
    f1 = open("./decoded_recipe.txt","w")
    f1.write(hkk)
    print(hkk)
if __name__ == "__main__":
    main()