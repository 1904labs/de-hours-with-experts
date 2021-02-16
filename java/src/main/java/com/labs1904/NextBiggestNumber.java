package com.labs1904;

import java.util.function.Consumer;

public class NextBiggestNumber {
    public static void main(String[] args) {
        final Integer input = Integer.parseInt(args[0]);
        System.out.println("Input: " + input);
        final Integer nextBiggestNumber = getNextBiggestNumber(input);
        System.out.println("Next biggest number: " + nextBiggestNumber);
    }

    public static int getNextBiggestNumber(final Integer input) {
        // TODO will break on negative numbers at this time
        final BestFit<String, Integer> fit = new BestFit<>(Integer::parseInt);
        final String value = input.toString();

        // start best-fitting with our input value because we want to select
        // the lowest number that is greater than the (first) input value
        fit.accept(value);

        // walk through all the permutations trying to find ones that are better fix
        permutation(value, fit);

        final Integer best = fit.best();
        return (best != null && !best.equals(input)) ? best : -1;
    }

    // Generic string permutation logic that takes a Consumer to handle all the
    // generated choices
    public static void permutation(final String input, final Consumer<String> consumer) {
        // we start with an initial empty prefix and iterate through all the possible
        // suffixes
        permutation("", input, consumer);
    }

    // inner permutation method that takes a pre-permutated prefix and a word to
    // append and runs through the remaining permutations of the trailing word.
    private static void permutation(final String prefix, final String word, Consumer<String> consumer) {
        if (word.isEmpty()) {
            // no more suffixes to permute, so accept the completed permutation choice into
            // the consumer
            consumer.accept(prefix + word);
        } else {
            // there are more suffix characters in the remaining word, extract each one in
            // turn
            // append to the current prefix and then recurse with the remaining word
            for (int i = 0; i < word.length(); i++) {
                permutation(prefix + word.charAt(i), word.substring(0, i) + word.substring(i + 1, word.length()),
                        consumer);
            }
        }
    }
}
