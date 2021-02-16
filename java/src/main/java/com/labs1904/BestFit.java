package com.labs1904;

import java.util.function.Consumer;
import java.util.function.Function;

// This nested class consumes strings one at time and
// implements a best-fit state manager that starts off
// with a unknown best value and a starting value and
// keeps the lowest item that is greater than the
// starting value
// TOutput is of some comparable nullable class like Integer
// TInput is of some class like String

public final class BestFit<TInput, TOutput extends Comparable<TOutput>> implements Consumer<TInput> {
    private TOutput bestSoFar = null;
    private TOutput startingValue = null;
    private final Function<TInput, TOutput> consumer;

    // consume is a Consumer function that converts values from TInput to TOutput
    public BestFit(final Function<TInput, TOutput> consume) {
        consumer = consume;
    }

    public void accept(final TInput value) {
        // Convert value to TOutput using provided mapper
        final TOutput current = consumer.apply(value);

        // if we don't have a starting value yet, take this
        // current one as our starting value
        if (startingValue == null) {
            startingValue = current;
        }

        // if the current is GREATER than the starting
        // and we either don't have best yet, or
        // current is LESS than
        if (current.compareTo(startingValue) > 0 && (bestSoFar == null || current.compareTo(bestSoFar) < 0)) {
            bestSoFar = current;
        }
    }

    public TOutput best() {
        return bestSoFar;
    }
}