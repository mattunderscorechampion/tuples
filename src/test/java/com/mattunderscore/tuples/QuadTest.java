/*
 * Copyright © 2018 Matt Champion
 */

package com.mattunderscore.tuples;

import org.junit.Rule;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

import java.util.function.Consumer;
import java.util.function.Function;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.verify;

/**
 * Unit test for {@link Quad}.
 *
 * @author Matt Champion 21/04/2018
 */
public final class QuadTest {
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
        final Quad<Object, String, String, String> quad = Quad.of("a", "b", "c", "d");

        assertEquals("a", quad.v0());
        assertEquals("b", quad.v1());
        assertEquals("c", quad.v2());
        assertEquals("d", quad.v3());
    }

    /**
     * Test value consumers.
     */
    @Test
    public void testAccept() {
        final Quad<Object, String, String, String> quad = Quad.of("a", "b", "c", "d");

        quad.acceptV0(consumer);
        verify(consumer).accept("a");

        quad.acceptV1(consumer);
        verify(consumer).accept("b");

        quad.acceptV2(consumer);
        verify(consumer).accept("c");

        quad.acceptV3(consumer);
        verify(consumer).accept("d");
    }

    /**
     * Test applying functions to values.
     */
    @Test
    public void testApply() {
        final Quad<Object, String, String, String> quad = Quad.of("a", "b", "c", "d");

        quad.applyV0(function);
        verify(function).apply("a");

        quad.applyV1(function);
        verify(function).apply("b");

        quad.applyV2(function);
        verify(function).apply("c");

        quad.applyV3(function);
        verify(function).apply("d");
    }

    /**
     * Test mapping value 0.
     */
    @Test
    public void testMapV0() {
        final Quad<Object, String, String, String> quad0 = Quad.of("a", "b", "c", "d");
        final Quad<Object, String, String, String> quad1 = quad0.mapV0(Function.identity());

        assertEquals(quad0, quad1);
    }

    /**
     * Test mapping value 1.
     */
    @Test
    public void testMapV1() {
        final Quad<Object, String, String, String> quad0 = Quad.of("a", "b", "c", "d");
        final Quad<Object, String, String, String> quad1 = quad0.mapV1(Function.identity());

        assertEquals(quad0, quad1);
    }

    /**
     * Test mapping value 2.
     */
    @Test
    public void testMapV2() {
        final Quad<Object, String, String, String> quad0 = Quad.of("a", "b", "c", "d");
        final Quad<Object, String, String, String> quad1 = quad0.mapV2(Function.identity());

        assertEquals(quad0, quad1);
    }

    /**
     * Test mapping value 3.
     */
    @Test
    public void testMapV3() {
        final Quad<Object, String, String, String> quad0 = Quad.of("a", "b", "c", "d");
        final Quad<Object, String, String, String> quad1 = quad0.mapV3(Function.identity());

        assertEquals(quad0, quad1);
    }

    /**
     * Test mapping all values.
     */
    @Test
    public void testMap() {
        final Quad<Object, String, String, String> quad0 = Quad.of("a", "b", "c", "d");
        final Quad<Object, String, String, String> quad1 =
            quad0.map(Function.identity(), Function.identity(), Function.identity(), Function.identity());

        assertEquals(quad0, quad1);
    }

    /**
     * Test toString implementation.
     */
    @Test
    public void testToString() {
        final Quad<Object, String, String, String> quad = Quad.of("a", "b", "c", "d");

        assertEquals("[a, b, c, d]", quad.toString());
    }

    /**
     * Test two distinct objects are equal.
     */
    @Test
    public void testEquals() {
        final Quad<Object, String, String, String> quad0 = Quad.of("a", "b", "c", "d");
        final Quad<Object, String, String, String> quad1 = Quad.of("a", "b", "c", "d");

        assertTrue(quad0.equals(quad1));
        assertTrue(quad1.equals(quad0));
        assertEquals(quad0.hashCode(), quad1.hashCode());
    }

    /**
     * Test two distinct objects wrapping null are equal.
     */
    @Test
    public void testEqualsWrappingNull() {
        final Quad<Object, String, String, String> quad0 = Quad.of("a", "b", "c", null);
        final Quad<Object, String, String, String> quad1 = Quad.of("a", "b", "c", null);

        assertTrue(quad0.equals(quad1));
        assertTrue(quad1.equals(quad0));
        assertEquals(quad0.hashCode(), quad1.hashCode());
    }

    /**
     * Test not equal to null.
     */
    @Test
    public void testNotEqualsNull() {
        final Quad<Object, String, String, String> quad0 = Quad.of("a", "b", "c", "d");

        assertFalse(quad0.equals(null));
    }

    /**
     * Test not equal to object of different type.
     */
    @Test
    public void testNotEqualsObject() {
        final Quad<Object, String, String, String> quad0 = Quad.of("a", "b", "c", "d");

        assertFalse(quad0.equals(new Object()));
    }

    /**
     * Test not equal to container with different values.
     */
    @Test
    public void testNotEqualsDifferent() {
        final Quad<Object, String, String, String> quad0 = Quad.of("a", "b", "c", "d");
        final Quad<Object, String, String, String> quad1 = Quad.of("a", "b", "c", "e");

        assertFalse(quad0.equals(quad1));
    }

    /**
     * Test not equal to container with different values, one null.
     */
    @Test
    public void testNotEqualsDifferentWrappingNull() {
        final Quad<Object, String, String, String> quad0 = Quad.of("a", "b", "c", "d");
        final Quad<Object, String, String, String> quad1 = Quad.of("a", "b", "c", null);

        assertFalse(quad0.equals(quad1));
    }

    /**
     * Test object equals self.
     */
    @Test
    public void testEqualsSelf() {
        final Quad<Object, String, String, String> quad0 = Quad.of("a", "b", "c", "d");

        assertTrue(quad0.equals(quad0));
    }
}
