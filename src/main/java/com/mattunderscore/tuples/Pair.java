/*
 * Copyright © 2018 Matt Champion
 */

package com.mattunderscore.tuples;

import net.jcip.annotations.Immutable;

import java.util.Objects;
import java.util.function.Consumer;
import java.util.function.Function;

/**
 * A 2-tuple.
 *
 * @param <T0> the type of value 0
 * @param <T1> the type of value 1
 * @author Matt Champion 19/04/2018
 */
@Immutable
public final class Pair<T0, T1> implements V0<T0>, V1<T1> {
    private final T0 v0;
    private final T1 v1;

    /*package*/ Pair(T0 v0, T1 v1) {
        this.v0 = v0;
        this.v1 = v1;
    }

    @Override
    public T0 v0() {
        return v0;
    }

    @Override
    public void acceptV0(Consumer<? super T0> consumer) {
        consumer.accept(v0);
    }

    @Override
    public <U> U applyV0(Function<? super T0, U> function) {
        return function.apply(v0);
    }

    /**
     * Map value 0 to new pair.
     *
     * @param function function to apply to value 0
     * @param <U> the new type of value 0
     * @return the new pair
     */
    public <U> Pair<U, T1> mapV0(Function<? super T0, U> function) {
        return new Pair<>(function.apply(v0), v1);
    }

    @Override
    public T1 v1() {
        return v1;
    }

    @Override
    public void acceptV1(Consumer<? super T1> consumer) {
        consumer.accept(v1);
    }

    @Override
    public <U> U applyV1(Function<? super T1, U> function) {
        return function.apply(v1);
    }

    /**
     * Map value 1 to new pair.
     *
     * @param function function to apply to value 1
     * @param <U> the new type of value 1
     * @return the new pair
     */
    public <U> Pair<T0, U> mapV1(Function<? super T1, U> function) {
        return new Pair<>(v0, function.apply(v1));
    }

    /**
     * Map all values to new pair.
     *
     * @param function0 function to apply to value 0
     * @param function1 function to apply to value 1
     * @param <U0> the new type of value 0
     * @param <U1> the new type of value 1
     * @return the new pair
     */
    public <U0, U1> Pair<U0, U1> map(Function<? super T0, U0> function0, Function<? super T1, U1> function1) {
        return new Pair<>(function0.apply(v0), function1.apply(v1));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        else if (o == null || getClass() != o.getClass()) {
            return false;
        }
        else {
            final Pair<?, ?> pair = (Pair<?, ?>) o;
            return Objects.equals(v0, pair.v0) && Objects.equals(v1, pair.v1);
        }
    }

    @Override
    public int hashCode() {
        return Objects.hash(v0, v1);
    }

    @Override
    public String toString() {
        return "[" + v0 + ", " + v1 + "]";
    }

    /**
     * @return a new pair
     */
    public static <T0, T1, U0 extends T0, U1 extends T1> Pair<T0, T1> of(U0 v0, U1 v1) {
        return new Pair<>(v0, v1);
    }
}
