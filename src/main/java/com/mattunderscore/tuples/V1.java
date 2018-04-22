/*
 * Copyright © 2018 Matt Champion
 */

package com.mattunderscore.tuples;

import java.util.function.Consumer;
import java.util.function.Function;

/**
 * Interface for accessing value 1.
 *
 * @param <T1> the type of value 1
 * @author Matt Champion 19/04/2018
 */
public interface V1<T1> {
    /**
     * @return value 1
     */
    T1 v1();

    /**
     * Pass value 1 to {@code consumer}.
     */
    void acceptV1(Consumer<? super T1> consumer);

    /**
     * Apply {@code function} to value 1 and return the result.
     */
    <U> U applyV1(Function<? super T1, U> function);
}
