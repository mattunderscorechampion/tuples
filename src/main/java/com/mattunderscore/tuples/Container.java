/*
 * Copyright © 2018 Matt Champion
 */

package com.mattunderscore.tuples;

import static java.util.Objects.requireNonNull;

import java.util.function.Consumer;
import java.util.function.Function;

/**
 * A 1-tuple.
 *
 * @author Matt Champion 20/04/2018
 */
public final class Container<T0> implements V0<T0> {
    private final T0 v0;

    /*package*/ Container(T0 v0) {
        this.v0 = requireNonNull(v0);
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
     * Map value 0 to new container.
     *
     * @param function function to apply to value 0
     * @param <U> the new type of value 0
     * @return the new container
     */
    public <U> Container<U> mapV0(Function<? super T0, U> function) {
        return map(function);
    }

    /**
     * Map value 0 to new container.
     *
     * @param function0 function0 to apply to value 0
     * @param <U0> the new type of value 0
     * @return the new container
     */
    public <U0> Container<U0> map(Function<? super T0, U0> function0) {
        return new Container<>(function0.apply(v0));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        final Container<?> container = (Container<?>) o;
        return v0.equals(container.v0);
    }

    @Override
    public int hashCode() {
        return v0.hashCode();
    }

    @Override
    public String toString() {
        return "[" + v0 + "]";
    }

    /**
     * @return a new container
     */
    public static <T0, U0 extends T0> Container<T0> of(U0 v0) {
        return new Container<>(v0);
    }
}
