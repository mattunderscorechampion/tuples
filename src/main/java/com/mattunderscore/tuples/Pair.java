/*
 * Copyright © 2018 Matt Champion
 */

package com.mattunderscore.tuples;

/**
 * A 2-tuple.
 *
 * @author Matt Champion 19/04/2018
 */
public final class Pair<T0, T1> {
    private final T0 v0;
    private final T1 v1;

    /*package*/ Pair(T0 v0, T1 v1) {
        this.v0 = v0;
        this.v1 = v1;
    }

    /**
     * @return value 0
     */
    public T0 v0() {
        return v0;
    }

    /**
     * @return value 1
     */
    public T1 v1() {
        return v1;
    }

    /**
     * @return a new pair
     */
    public static <T0, T1, U0 extends T0, U1 extends T1> Pair<T0, T1> of(U0 v0, U1 v1) {
        return new Pair<>(v0, v1);
    }
}
