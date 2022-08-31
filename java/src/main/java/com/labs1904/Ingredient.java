package com.labs1904;

public class Ingredient {
    private String amount;
    private String description;

    public Ingredient(String amount, String description) {
        setAmount(amount);
        setDescription(description);
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return amount + " of " + description;
    }
}