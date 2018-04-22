/*
 * Copyright © 2018 Matt Champion
 */

package com.mattunderscore.tuples;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.verify;

import java.util.function.Consumer;
import java.util.function.Function;

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
    /**
     * Mockito rule.
     */
    @Rule
    public final MockitoRule mockitoRule = MockitoJUnit.rule();

    @Mock
    private Consumer<Object> consumer;
    @Mock
    private Function<Object, Object> function;

    /**
     * Test value access.
     */
    @Test
    public void testAccess() {
        final Pair<Object, String> pair = Pair.of("a", "b");

        assertEquals("a", pair.v0());
        assertEquals("b", pair.v1());
    }

    /**
     * Test value consumers.
     */
    @Test
    public void testAccept() {
        final Pair<Object, String> pair = Pair.of("a", "b");

        pair.acceptV0(consumer);
        verify(consumer).accept("a");

        pair.acceptV1(consumer);
        verify(consumer).accept("b");
    }

    /**
     * Test applying functions to values.
     */
    @Test
    public void testApply() {
        final Pair<Object, String> pair = Pair.of("a", "b");

        pair.applyV0(function);
        verify(function).apply("a");

        pair.applyV1(function);
        verify(function).apply("b");
    }

    /**
     * Test mapping value 0.
     */
    @Test
    public void testMapV0() {
        final Pair<Object, String> pair0 = Pair.of("a", "b");
        final Pair<Object, String> pair1 = pair0.mapV0(Function.identity());

        assertEquals(pair0, pair1);
    }

    /**
     * Test mapping value 1.
     */
    @Test
    public void testMapV1() {
        final Pair<Object, String> pair0 = Pair.of("a", "b");
        final Pair<Object, String> pair1 = pair0.mapV1(Function.identity());

        assertEquals(pair0, pair1);
    }

    /**
     * Test mapping all values.
     */
    @Test
    public void testMap() {
        final Pair<Object, String> pair0 = Pair.of("a", "b");
        final Pair<Object, String> pair1 = pair0.map(Function.identity(), Function.identity());

        assertEquals(pair0, pair1);
    }

    /**
     * Test toString implementation.
     */
    @Test
    public void testToString() {
        final Pair<Object, String> pair = Pair.of("a", "b");

        assertEquals("[a, b]", pair.toString());
    }

    /**
     * Test two distinct objects are equal.
     */
    @Test
    public void testEquals() {
        final Pair<Object, String> pair0 = Pair.of("a", "b");
        final Pair<Object, String> pair1 = Pair.of("a", "b");

        assertTrue(pair0.equals(pair1));
        assertTrue(pair1.equals(pair0));
        assertEquals(pair0.hashCode(), pair1.hashCode());
    }

    /**
     * Test not equal to null.
     */
    @Test
    public void testNotEqualsNull() {
        final Pair<Object, String> pair0 = Pair.of("a", "b");

        assertFalse(pair0.equals(null));
    }

    /**
     * Test not equal to object of different type.
     */
    @Test
    public void testNotEqualsObject() {
        final Pair<Object, String> pair0 = Pair.of("a", "b");

        assertFalse(pair0.equals(new Object()));
    }

    /**
     * Test not equal to container with different values.
     */
    @Test
    public void testNotEqualsDifferent() {
        final Pair<Object, String> pair0 = Pair.of("a", "b");
        final Pair<Object, String> pair1 = Pair.of("a", "c");

        assertFalse(pair0.equals(pair1));
    }

    /**
     * Test object equals self.
     */
    @Test
    public void testEqualsSelf() {
        final Pair<Object, String> pair0 = Pair.of("a", "b");

        assertTrue(pair0.equals(pair0));
    }
}
