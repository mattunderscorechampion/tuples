/*
 * Copyright © 2018 Matt Champion
 */

package com.mattunderscore.tuples;

import java.util.function.Consumer;
import java.util.function.Function;

/**
 * Interface for accessing value 3.
 *
 * @param <T3> the type of value 3
 * @author Matt Champion 21/04/2018
 */
public interface V3<T3> {
    /**
     * @return value 3
     */
    T3 v3();

    /**
     * Pass value 3 to {@code consumer}.
     */
    void acceptV3(Consumer<? super T3> consumer);

    /**
     * Apply {@code function} to value 3 and return the result.
     */
    <U> U applyV3(Function<? super T3, U> function);
}
