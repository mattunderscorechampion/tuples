/*
 * Copyright © 2018 Matt Champion
 */

package com.mattunderscore.tuples;

import static java.util.Objects.requireNonNull;
import static java.util.function.Function.identity;

import java.util.function.Consumer;
import java.util.function.Function;

/**
 * A 3-tuple.
 *
 * @author Matt Champion 20/04/2018
 */
public final class Triple<T0, T1, T2> implements V0<T0>, V1<T1>, V2<T2> {
    private final T0 v0;
    private final T1 v1;
    private final T2 v2;

    /*package*/ Triple(T0 v0, T1 v1, T2 v2) {
        this.v0 = requireNonNull(v0);
        this.v1 = requireNonNull(v1);
        this.v2 = requireNonNull(v2);
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
     * Map value to new pair.
     *
     * @param function function to apply to value 0
     * @param <U> the new type of value 0
     * @return the new pair
     */
    public <U> Triple<U, T1, T2> mapV0(Function<? super T0, U> function) {
        return map(function, identity(), identity());
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
     * Map value to new pair.
     *
     * @param function function to apply to value 1
     * @param <U> the new type of value 1
     * @return the new pair
     */
    public <U> Triple<T0, U, T2> mapV1(Function<? super T1, U> function) {
        return map(identity(), function, identity());
    }

    @Override
    public T2 v2() {
        return v2;
    }

    @Override
    public void acceptV2(Consumer<? super T2> consumer) {
        consumer.accept(v2);
    }

    @Override
    public <U> U applyV2(Function<? super T2, U> function) {
        return function.apply(v2);
    }

    /**
     * Map value to new pair.
     *
     * @param function function to apply to value 2
     * @param <U> the new type of value 2
     * @return the new pair
     */
    public <U> Triple<T0, T1, U> mapV2(Function<? super T2, U> function) {
        return map(identity(), identity(), function);
    }

    /**
     * Map value to new pair.
     *
     * @param function0 function0 to apply to value 0
     * @param function1 function1 to apply to value 1
     * @param function2 function2 to apply to value 2
     * @param <U0> the new type of value 0
     * @param <U1> the new type of value 1
     * @param <U2> the new type of value 2
     * @return the new pair
     */
    public <U0, U1, U2> Triple<U0, U1, U2> map(
            Function<? super T0, U0> function0,
            Function<? super T1, U1> function1,
            Function<? super T2, U2> function2) {
        return new Triple<>(function0.apply(v0), function1.apply(v1), function2.apply(v2));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        final Triple<?, ?, ?> pair = (Triple<?, ?, ?>) o;
        return v0.equals(pair.v0) && v1.equals(pair.v1) && v2.equals(pair.v2);
    }

    @Override
    public int hashCode() {
        int result = v0.hashCode();
        result = 31 * result + v1.hashCode();
        result = 31 * result + v2.hashCode();
        return result;
    }

    /**
     * @return a new pair
     */
    public static <T0, T1, T2, U0 extends T0, U1 extends T1, U2 extends T2> Triple<T0, T1, T2> of(U0 v0, U1 v1, U2 v2) {
        return new Triple<>(v0, v1, v2);
    }
}
