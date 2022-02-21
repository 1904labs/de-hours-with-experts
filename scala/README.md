# Hours with Experts Coding Challenge: Scala

Many years ago, the perfect cookie recipe was created and then lost... until now. An encrypted version was discovered
and it is up to you to recover the recipe so that the perfect cookie can be created once again.

The recipe is encrypted using a simple substitution cipher. For example, the encoded string `hgiikf` can be decoded to `butter`:

```
encoded -> decoded
      h -> b
      g -> u
      i -> t
      i -> t
      k -> e
      f -> r
```

The cipher is provided for you in a variable named `ENCODING`. 

## Challenge #1: Decode a string

Implement a function named `decodeString` that takes an encoded string and returns the decoded value (`hgiikf` is decoded to `butter`).

Hint: See the function definition in `SecretRecipeDecoder.scala`.

## Challenge #2: Decode an Ingredient

Implement a function named `decodeIngredient` that takes a line from the recipe and returns a new Ingredient (a class already defined for you).
The `#` sign delimits the encoded amount and the description of an ingredient. For example, the line `8 vgl#hgiikf` would return an Ingredient 
with an amount of `1 cup` and a description of `butter`. 

Hint: See the function definition inside the `SecretRecipeDecoder.scala` file.

## Challenge #3: Decode the entire recipe

In the `main` method, read all of the ingredients out of `secret_recipe.txt`, decode each ingredient (hopefully using the functions
you implemented above), and save the output into a new file named `decoded_recipe.txt`.

# Testing the project

There are some unit tests in `SecretRecipeDecoderTest.scala`