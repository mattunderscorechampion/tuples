/*
 * Copyright © 2018 Matt Champion
 */

package com.mattunderscore.tuples;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
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

    @Test
    public void testEquals() {
        final Pair<Object, String> pair0 = Pair.of("a", "b");
        final Pair<Object, String> pair1 = Pair.of("a", "b");

        assertTrue(pair0.equals(pair1));
        assertTrue(pair1.equals(pair0));
        assertEquals(pair0.hashCode(), pair1.hashCode());
    }

    @Test
    public void testNotEqualsNull() {
        final Pair<Object, String> pair0 = Pair.of("a", "b");

        assertFalse(pair0.equals(null));
    }

    @Test
    public void testNotEqualsObject() {
        final Pair<Object, String> pair0 = Pair.of("a", "b");

        assertFalse(pair0.equals(new Object()));
    }

    @Test
    public void testNotEqualsDifferent() {
        final Pair<Object, String> pair0 = Pair.of("a", "b");
        final Pair<Object, String> pair1 = Pair.of("a", "c");

        assertFalse(pair0.equals(pair1));
    }
}
