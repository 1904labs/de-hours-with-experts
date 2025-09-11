import assert from 'node:assert';
import test from 'node:test';
import { decodeString, decodeIngredient } from './secretRecipeDecoder.js';


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
