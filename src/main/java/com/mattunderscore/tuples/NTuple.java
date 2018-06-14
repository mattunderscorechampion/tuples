/*
 * Copyright © 2018 Matt Champion
 */

package com.mattunderscore.tuples;

import net.jcip.annotations.Immutable;

import static java.util.Objects.requireNonNull;

import java.util.Arrays;
import java.util.function.Consumer;
import java.util.function.Function;

/**
 * A n-tuple.
 * <p>
 * Lacks type and arity safety.
 *
 * @author Matt Champion 21/04/2018
 */
@Immutable
public final class NTuple {
    private final Object[] values;

    /*package*/ NTuple(Object[] values) {
        this.values = requireNonNull(values);
    }

    /**
     * Return value {@code i}.
     *
     * @param i the index of the value to access
     * @param <T> the type of value {@code i}
     * @return value {@code i}
     * @throws ClassCastException if the expected type is not the actual type
     * @throws IndexOutOfBoundsException if the arity is wrong
     */
    @SuppressWarnings("unchecked")
    public <T> T v(int i) {
        return (T) values[i];
    }

    /**
     * Pass value {@code i} to {@code consumer}.
     *
     * @param i the index of the value to access
     * @param <T> the type of value {@code i}
     * @throws ClassCastException if the expected type is not the actual type
     * @throws IndexOutOfBoundsException if the arity is wrong
     */
    public <T> void acceptV(int i, Consumer<? super T> consumer) {
        consumer.accept(v(i));
    }

    /**
     * Apply {@code function} to value {@code i} and return the result.
     *
     * @param <T> the type of value {@code i}
     * @param <U> the new type of value {@code i}
     * @throws ClassCastException if the expected type is not the actual type
     * @throws IndexOutOfBoundsException if the arity is wrong
     */
    public <T, U> U applyV(int i, Function<? super T, U> function) {
        return function.apply(v(i));
    }

    /**
     * Map value {@code i} to new tuple.
     *
     * @param function function to apply to value {@code i}
     * @param <T> the type of value {@code i}
     * @param <U> the new type of value {@code i}
     * @return the new tuple
     * @throws ClassCastException if the expected type is not the actual type
     * @throws IndexOutOfBoundsException if the arity is wrong
     */
    public <T, U> NTuple mapV(int i, Function<? super T, U> function) {
        final T value = v(i);
        final Object[] newValues = Arrays.copyOf(values, values.length);
        newValues[i] = function.apply(value);
        return new NTuple(newValues);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        final NTuple nTuple = (NTuple) o;
        return Arrays.equals(values, nTuple.values);
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(values);
    }

    @Override
    public String toString() {
        return Arrays.toString(values);
    }

    /**
     * @return a new n-tuple
     */
    public static NTuple of(Object... values) {
        return new NTuple(Arrays.copyOf(values, values.length));
    }
}
