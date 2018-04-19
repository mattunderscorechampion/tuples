/*
 * Copyright © 2018 Matt Champion
 */

package com.mattunderscore.tuples;

import java.util.function.Consumer;
import java.util.function.Function;

/**
 * Interface for accessing value 2.
 *
 * @author Matt Champion 20/04/2018
 */
public interface V2<T2> {
    /**
     * @return value 2
     */
    T2 v2();

    /**
     * Pass value 2 to {@code consumer}.
     */
    void acceptV2(Consumer<? super T2> consumer);

    /**
     * Apply {@code function} to value 2 and return the result.
     */
    <U> U applyV2(Function<? super T2, U> function);
}
