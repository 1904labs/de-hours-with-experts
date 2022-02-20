# Hours with Experts Coding Challenge: Scala

Many years ago, the perfect cookie recipe was created and then lost... until now. An encrypted version was discovered
and it is up to you to recover the recipe so that the perfect cookie can be created once again.

## The challenge

Decode the cookie recipe and save the output in a file named `decoded_recipe.txt`.

### Challenge #1: Implement the decode_string method

Inside the `SecretRecipeDecoder.java` file there is a method named `decodeString`. This function should take an encoded string like
`hgiikf` and return the decoded value (`butter`). Implement this method.

Hint: The Caesar encoding is given to you, check out the `ENCODING` map.

### Challenge #2: Implement the decode_ingredient method

Inside the `SecretRecipeDecoder.java` file there is a method named `decodeIngredient`. This function takes an ingredient. An
ingredient is a class that has an amount and a description. For example: an Ingredient could have "1 cup" as the amount and
"butter" as the description. This method should take an encoded string like `8 vgl#hgiikf` and return an Ingredient.

Hint: The `#` sign delimits the amount and the description.

### Challenge #3: Decode the entire recipe

The `main` method should read all of the ingredients out of `secret_recipe.txt`, decode each ingredient (hopefully using the methods
you implemented above), and save the output into a new file named `decoded_recipe.txt`.

## Testing the project

There are some unit tests in `TestSecretRecipeDecoder.java`
