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
    encoded_string = str
    encoded_string_in_arr = []
    decoded_string = ""

    for char in range(len(encoded_string)):
        encoded_string_in_arr.append(encoded_string[char])

    for char in range(len(encoded_string_in_arr)):
        if encoded_string_in_arr[char] in ENCODING:
            encoded_string_in_arr[char] = ENCODING[encoded_string_in_arr[char]]
            decoded_string = decoded_string + encoded_string_in_arr[char]

    return decoded_string


def decode_ingredient(line):
    encoded_line_separated_by_spaces = line
    encoded_line_in_arr_separated_by_spaces = encoded_line_separated_by_spaces.split(" ")
    encoded_line_in_arr = []
    decoded_amount = ""
    decoded_description = ""
    print("This is the recipe line separated by spaces: " + str(encoded_line_in_arr_separated_by_spaces))

    for char in range(len(encoded_line_in_arr_separated_by_spaces)):
        encoded_word_separated_by_pound_symbol = encoded_line_in_arr_separated_by_spaces[char].split("#")
        print("this is the separated list by #: " + str(encoded_word_separated_by_pound_symbol))
        if (len(encoded_word_separated_by_pound_symbol)>1):
            decoded_description += str(decode_string(encoded_word_separated_by_pound_symbol[1]))
        encoded_line_in_arr.append(encoded_word_separated_by_pound_symbol)

    print(encoded_line_in_arr)

    amount_cnt = 1

    for i in range(len(encoded_line_in_arr)):
        for j in range(len(encoded_line_in_arr[i])):
            if ( (len(encoded_line_in_arr[i]) > 1)  and (amount_cnt < 2)):
                decoded_amount += decode_string(encoded_line_in_arr[i][j])
                amount_cnt += 1

    print("this is the amount: " + decoded_amount)
    print("this is the description: " + decoded_description)


def main():
    """A program that decodes a secret recipe"""
    # TODO: implement me

if __name__ == "__main__":
    main()
