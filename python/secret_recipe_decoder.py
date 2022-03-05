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

def decode_string(str):
    # TODO: implement me
    word=[]
    for character in str:
        if character not in ENCODING.keys():
            ENCODING[character]=character
        else:
            pass
        word.append(ENCODING.get(character))
    word=''.join(word)
    word= word.replace('#',' | ')
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
    return Ingredient(word[0],word[1])

def decode_recipe_file(file):
    """Decode and write txt file in a per-line fashion"""
     # TODO: implement me
    file=open(file,'r')
    file=file.readlines()
    newfile=open('decoded_recipe.txt','w')
    for lines in file:
        decoded_recipe=decode_string(lines)
        newfile.write(decoded_recipe)
    newfile.close()
    return f'{newfile} <----- The secret recipe is unveiled now. Enjoy yourself!'

def main():
    """A program that decodes a secret recipe"""
    # TODO: implement me
    decode_string('hgiikf')
    print('\ndecoding string function works!\n' + '\tword to decode: hgiikf\n\t' + 'decoding result: '+ decode_string('hgiikf'))

    ingredient=decode_ingredient('8 vgl#hgiikf')
    print('\ndecoding ingredients function works!\n' + '\tingredient to decode: 8 vgl#hgiikf\n\t' + 'ingredient amount: '+ ingredient.amount + '\n\t' + 'ingredient description: '+ ingredient.description)

    decode_recipe_file('secret_recipe.txt')
    print('\ndecoding file function works!\n' + '\t check out the decoded file' + '\n\t' + decode_recipe_file('secret_recipe.txt'))

if __name__ == "__main__":
    main()



