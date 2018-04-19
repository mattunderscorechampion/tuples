/*
 * Copyright © 2018 Matt Champion
 */

package com.mattunderscore.tuples;

import java.util.function.Consumer;
import java.util.function.Function;

/**
 * Interface for accessing value 0.
 *
 * @author Matt Champion 19/04/2018
 */
public interface V0<T0> {
    /**
     * @return value 0
     */
    T0 v0();

    /**
     * Pass value 0 to {@code consumer}.
     */
    void acceptV0(Consumer<? super T0> consumer);

    /**
     * Apply {@code function} to value 0 and return the result.
     */
    <U> U applyV0(Function<? super T0, U> function);
}
