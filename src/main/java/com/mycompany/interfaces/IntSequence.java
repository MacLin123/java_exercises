package com.mycompany.interfaces;

public interface IntSequence {
    default boolean hasNext() {
        return false;
    }

    int next();

    static IntSequence of(int... numbers) {
        IntSequence intSequence = new IntSequence() {
            private int ind = 0;

            @Override
            public boolean hasNext() {
                return ind < numbers.length;
            }

            @Override
            public int next() {
                return numbers[ind++];
            }
        };
        return intSequence;
    }

    static IntSequence constant(int number) {
        IntSequence intSequence = () -> number;
        return intSequence;
    }
}
