package com.labs1904;

import org.junit.Assert;
import org.junit.Test;

public class TestSecretRecipeDecoder {
    @Test
    public void testDecodeString() {
        Assert.assertEquals("ijz", SecretRecipeDecoder.decodeString("abc"));
    }

    @Test
    public void testDecodeIngredient() {
        Ingredient expected = new Ingredient("1 cup", "butter");
        Ingredient actual = SecretRecipeDecoder.decodeIngredient("8 vgl#hgiikf");
        Assert.assertEquals(expected.getAmount(), actual.getAmount());
        Assert.assertEquals(expected.getDescription(), actual.getDescription());
    }
}
