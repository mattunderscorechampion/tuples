/*
 * Copyright © 2018 Matt Champion
 */

package com.mattunderscore.tuples;

import static java.util.Objects.requireNonNull;

import java.util.function.Consumer;

/**
 * A 2-tuple.
 *
 * @author Matt Champion 19/04/2018
 */
public final class Pair<T0, T1> implements V0<T0>, V1<T1> {
    private final T0 v0;
    private final T1 v1;

    /*package*/ Pair(T0 v0, T1 v1) {
        this.v0 = requireNonNull(v0);
        this.v1 = requireNonNull(v1);
    }

    @Override
    public T0 v0() {
        return v0;
    }

    @Override
    public void v0(Consumer<? super T0> consumer) {
        consumer.accept(v0);
    }

    @Override
    public T1 v1() {
        return v1;
    }

    @Override
    public void v1(Consumer<? super T1> consumer) {
        consumer.accept(v1);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        final Pair<?, ?> pair = (Pair<?, ?>) o;
        return v0.equals(pair.v0) && v1.equals(pair.v1);
    }

    @Override
    public int hashCode() {
        int result = v0.hashCode();
        result = 31 * result + v1.hashCode();
        return result;
    }

    /**
     * @return a new pair
     */
    public static <T0, T1, U0 extends T0, U1 extends T1> Pair<T0, T1> of(U0 v0, U1 v1) {
        return new Pair<>(v0, v1);
    }
}
