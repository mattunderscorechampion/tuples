/*
 * Copyright © 2018 Matt Champion
 */

package com.mattunderscore.tuples;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.verify;

import java.util.function.Consumer;

import org.junit.Rule;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

/**
 * Unit test for {@link Pair}.
 * @author Matt Champion 19/04/2018
 */
public final class PairTest {
    @Rule
    public MockitoRule mockitoRule = MockitoJUnit.rule();

    @Mock
    private Consumer<Object> consumer;

    @Test
    public void testPair() {
        final Pair<Object, String> pair = Pair.of("a", "b");

        assertEquals("a", pair.v0());
        assertEquals("b", pair.v1());
    }

    @Test
    public void testConsumer() {
        final Pair<Object, String> pair = Pair.of("a", "b");

        pair.v0(consumer);
        verify(consumer).accept("a");

        pair.v1(consumer);
        verify(consumer).accept("b");
    }
}
