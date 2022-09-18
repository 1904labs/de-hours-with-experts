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
<<<<<<< Updated upstream
    # TODO: implement me
=======
    #instantiate decoded string to return. 
    decodedstr = ""
    for letter in str:
        if letter.isalnum() == False:
            decoded = letter
        #elif letter.isalnum == False
        else:
            decoded = ENCODING[letter]
        decodedstr += decoded
    return decodedstr
>>>>>>> Stashed changes


def decode_ingredient(line):
    """Given an ingredient, decode the amount and description, and return a new Ingredient"""
<<<<<<< Updated upstream
    # TODO: implement me
=======
    #create list to store decoded ingrediant parts
    decodedList = []
    inlist = line.split("#")
    for part in inlist:
        decodedList.append(decode_string(part))
    

    return Ingredient(decodedList[0], decodedList[1])
>>>>>>> Stashed changes


def main():
    """A program that decodes a secret recipe"""
    secretRecipe = open("secret_recipe.txt", "r")
    decodedrecipe =  open("decoded_recipe.txt", "w+")
    #Populate array with file text
    recList = secretRecipe.read().split("\n")
    #String to write to decoded text file. 
    stringtoWrite=""
    #Remove Blank Rows from array to keep decode_ingredient from erroring out.
    recList = [x for x in recList if x] 
    #iteratively decode and write to string
    for line in recList:
        #print(line)
        recipeIngredient = decode_ingredient(line) #method returns Ingredient Object
        stringtoWrite = stringtoWrite + recipeIngredient.amount + " " + recipeIngredient.description + "\n" 

    #write string to decoded_recipe.txt
    decodedrecipe.write(stringtoWrite)
    decodedrecipe.close()

    

if __name__ == "__main__":
    main()
