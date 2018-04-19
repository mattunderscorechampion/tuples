/*
 * Copyright © 2018 Matt Champion
 */

package com.mattunderscore.tuples;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
 * Unit test for {@link Pair}.
 * @author Matt Champion 19/04/2018
 */
public final class PairTest {
    @Test
    public void testPair() {
        final Pair<Object, String> pair = Pair.of("a", "b");

        assertEquals("a", pair.v0());
        assertEquals("b", pair.v1());
    }
}
