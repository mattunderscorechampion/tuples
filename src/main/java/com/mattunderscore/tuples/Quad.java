/*
 * Copyright © 2018 Matt Champion
 */

package com.mattunderscore.tuples;

import net.jcip.annotations.Immutable;

import java.util.Objects;
import java.util.function.Consumer;
import java.util.function.Function;

import static java.util.function.Function.identity;

/**
 * A 4-tuple.
 *
 * @param <T0> the type of value 0
 * @param <T1> the type of value 1
 * @param <T2> the type of value 2
 * @param <T3> the type of value 3
 * @author Matt Champion 21/04/2018
 */
@Immutable
public final class Quad<T0, T1, T2, T3> implements V0<T0>, V1<T1>, V2<T2>, V3<T3> {
    private final T0 v0;
    private final T1 v1;
    private final T2 v2;
    private final T3 v3;

    /*package*/ Quad(T0 v0, T1 v1, T2 v2, T3 v3) {
        this.v0 = v0;
        this.v1 = v1;
        this.v2 = v2;
        this.v3 = v3;
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
     * Map value 0 to new quad.
     *
     * @param function function to apply to value 0
     * @param <U> the new type of value 0
     * @return the new quad
     */
    public <U> Quad<U, T1, T2, T3> mapV0(Function<? super T0, U> function) {
        return map(function, identity(), identity(), identity());
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
     * Map value 1 to new quad.
     *
     * @param function function to apply to value 1
     * @param <U> the new type of value 1
     * @return the new quad
     */
    public <U> Quad<T0, U, T2, T3> mapV1(Function<? super T1, U> function) {
        return map(identity(), function, identity(), identity());
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
     * Map value 2 to new quad.
     *
     * @param function function to apply to value 2
     * @param <U> the new type of value 2
     * @return the new quad
     */
    public <U> Quad<T0, T1, U, T3> mapV2(Function<? super T2, U> function) {
        return map(identity(), identity(), function, identity());
    }

    @Override
    public T3 v3() {
        return v3;
    }

    @Override
    public void acceptV3(Consumer<? super T3> consumer) {
        consumer.accept(v3);
    }

    @Override
    public <U> U applyV3(Function<? super T3, U> function) {
        return function.apply(v3);
    }

    /**
     * Map value 2 to new quad.
     *
     * @param function function to apply to value 2
     * @param <U> the new type of value 2
     * @return the new quad
     */
    public <U> Quad<T0, T1, T2, U> mapV3(Function<? super T3, U> function) {
        return map(identity(), identity(), identity(), function);
    }

    /**
     * Map all values to new quad.
     *
     * @param function0 function to apply to value 0
     * @param function1 function to apply to value 1
     * @param function2 function to apply to value 2
     * @param function3 function to apply to value 3
     * @param <U0> the new type of value 0
     * @param <U1> the new type of value 1
     * @param <U2> the new type of value 2
     * @param <U3> the new type of value 3
     * @return the new quad
     */
    public <U0, U1, U2, U3> Quad<U0, U1, U2, U3> map(
            Function<? super T0, U0> function0,
            Function<? super T1, U1> function1,
            Function<? super T2, U2> function2,
            Function<? super T3, U3> function3) {
        return new Quad<>(function0.apply(v0), function1.apply(v1), function2.apply(v2), function3.apply(v3));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        final Quad<?, ?, ?, ?> quad = (Quad<?, ?, ?, ?>) o;
        return Objects.equals(v0, quad.v0) &&
            Objects.equals(v1, quad.v1) &&
            Objects.equals(v2, quad.v2) &&
            Objects.equals(v3, quad.v3);
    }

    @Override
    public int hashCode() {
        return Objects.hash(v0, v1, v2, v3);
    }

    @Override
    public String toString() {
        return "[" + v0 + ", " + v1 + ", " + v2 + ", " + v3 + "]";
    }

    /**
     * @return a new quad
     */
    public static <T0, T1, T2, T3, U0 extends T0, U1 extends T1, U2 extends T2, U3 extends T3>
            Quad<T0, T1, T2, T3> of(U0 v0, U1 v1, U2 v2, U3 v3) {
        return new Quad<>(v0, v1, v2, v3);
    }
}
