import assert from 'node:assert';
import test from 'node:test';
import { decodeString, decodeIngredient, decodeRecipe } from './secretRecipeDecoder.js';
import fs from 'fs';

test('decodeString can decode', () => {
    const expected = "1 cup";
    const actual = decodeString("8 vgl")
    assert.equal(expected, actual);
})

test('decodeIngredient can decode', () => {
    const expected = {
        amount: '1 cup',
        description: 'butter',
    }

    const actual = decodeIngredient("8 vgl#hgiikf")
    assert(actual.amount == expected.amount)
    assert(actual.description == expected.description)
})

test('decode list of ingredients', () => {
    const ingredients = [
        '8 vgl#hgiikf',
        '8 vgl#xyfe hfntq ogzyf, lyvekx',
        '8 vgl#zfyqgwyikx ogzyf',
        '4#kzzo',
        '8 ikyolnnq#jyqawwy',
        '4 8/4 vglo#nyiukyw',
        '4 vglo#pwngf',
        '8/4 ikyolnnq#oywi',
        '8 ikyolnnq#hyeaqz onxy',
        '8 ikyolnnq#hyeaqz lntxkf',
        '84 ngqvko#vsnvnwyik vsalo',
        '8#2-ngqvk uawe vsnvnwyik hyf',
        '8 8/4 vglo#vsnllkx qgio',
    ]

    const expected = [
        '1 cup butter',
        '1 cup dark brown sugar, packed',
        '1 cup granulated sugar',
        '2 eggs',
        '1 teaspoon vanilla',
        '2 1/2 cups oatmeal',
        '2 cups flour',
        '1/2 teaspoon salt',
        '1 teaspoon baking soda',
        '1 teaspoon baking powder',
        '12 ounces chocolate chips',
        '1 4-ounce milk chocolate bar',
        '1 1/2 cups chopped nuts'
    ]

    ingredients.forEach((ingredient, i) => {
        assert(expected[i], decodeIngredient(ingredient, 'string'))
    })
})

test ('decode recipe', async ()=>{
    const filePath = 'secret_recipe.txt';
    const outputPath = 'decoded_recipe.txt';
    await decodeRecipe(filePath);
    // assert file exists
    const result = fs.existsSync(outputPath);
    assert(result)
});