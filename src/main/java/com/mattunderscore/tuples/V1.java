/*
 * Copyright © 2018 Matt Champion
 */

package com.mattunderscore.tuples;

import java.util.function.Consumer;

/**
 * Interface for accessing value 1.
 *
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
    void v1(Consumer<? super T1> consumer);
}
