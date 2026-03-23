#!/usr/bin/python3
import pydoc
import sys
import os

# Caesar-style substitution mapping used to decode the recipe.
# Each key is the encoded character and the value is the decoded character.
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


class Ingredient:
    """
    Simple data holder for one ingredient in the recipe.

    Example:
        amount = "1 cup"
        description = "butter"
    """

    def __init__(self, amount: str, description: str) -> None:
        self.amount = amount
        self.description = description

    def __str__(self) -> str:
        # This makes it easy to print or write the ingredient to a file.
        return f"{self.amount} {self.description}"


def decode_string(encoded_text: str) -> str:
    """
    Decode a single string using the ENCODING mapping above.

    The function walks through each character in the input and looks it up
    in the ENCODING dictionary. If the character is present, we replace it
    with the decoded value. If it is not present (for example spaces or
    punctuation), we leave it as-is.
    """
    decoded_characters = []

    for character in encoded_text:
        decoded_character = ENCODING.get(character, character)
        decoded_characters.append(decoded_character)

    decoded_text = "".join(decoded_characters)
    return decoded_text


def decode_ingredient(encoded_line: str) -> Ingredient:
    """
    Decode a single line from the recipe file into an Ingredient instance.

    The input format looks like this (before decoding):

        "8 vgl#hgiikf"

    The '#' character separates the amount from the description:
        - left side:  encoded amount   -> "8 vgl"
        - right side: encoded item     -> "hgiikf"
    """
    # Remove any trailing newline or extra whitespace.
    cleaned_line = encoded_line.strip()

    # Split once on '#' to separate amount and description.
    encoded_amount, encoded_description = cleaned_line.split("#", 1)

    # Decode each part using the helper function above.
    decoded_amount = decode_string(encoded_amount)
    decoded_description = decode_string(encoded_description)

    return Ingredient(decoded_amount, decoded_description)


def main() -> None:
    """
    Read the encoded recipe from 'secret_recipe.txt', decode each line into
    an Ingredient, and write the human-readable version to 'decoded_recipe.txt'.
    """
    decoded_ingredients = []

    # Use the directory containing this script so the program works when
    # executed from another working directory (fixes FileNotFoundError).
    script_dir = os.path.abspath(os.path.dirname(__file__))
    input_path = os.path.join(script_dir, "secret_recipe.txt")
    output_path = os.path.join(script_dir, "decoded_recipe.txt")

    # Step 1: read and decode each line from the input file.
    with open(input_path, "r", encoding="utf-8") as recipe_file:
        for raw_line in recipe_file:
            # Skip completely empty lines to avoid creating empty ingredients.
            if not raw_line.strip():
                continue

            ingredient = decode_ingredient(raw_line)
            decoded_ingredients.append(ingredient)

    # Step 2: write the decoded ingredients to the output file.
    with open(output_path, "w", encoding="utf-8") as output_file:
        for ingredient in decoded_ingredients:
            output_file.write(str(ingredient) + "\n")

    print(f"Wrote decoded recipe to: {output_path}")


if __name__ == "__main__":
    main()