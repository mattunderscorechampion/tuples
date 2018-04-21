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
 * Unit test for {@link Quad}.
 *
 * @author Matt Champion 21/04/2018
 */
public final class QuadTest {
    @Rule
    public MockitoRule mockitoRule = MockitoJUnit.rule();

    @Mock
    private Consumer<Object> consumer;
    @Mock
    private Function<Object, Object> function;

    @Test
    public void testPair() {
        final Quad<Object, String, String, String> quad = Quad.of("a", "b", "c", "d");

        assertEquals("a", quad.v0());
        assertEquals("b", quad.v1());
        assertEquals("c", quad.v2());
        assertEquals("d", quad.v3());
    }

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

    @Test
    public void testMapV0() {
        final Quad<Object, String, String, String> quad0 = Quad.of("a", "b", "c", "d");
        final Quad<Object, String, String, String> quad1 = quad0.mapV0(Function.identity());

        assertEquals(quad0, quad1);
    }

    @Test
    public void testMapV1() {
        final Quad<Object, String, String, String> quad0 = Quad.of("a", "b", "c", "d");
        final Quad<Object, String, String, String> quad1 = quad0.mapV1(Function.identity());

        assertEquals(quad0, quad1);
    }

    @Test
    public void testMapV2() {
        final Quad<Object, String, String, String> quad0 = Quad.of("a", "b", "c", "d");
        final Quad<Object, String, String, String> quad1 = quad0.mapV2(Function.identity());

        assertEquals(quad0, quad1);
    }

    @Test
    public void testMapV3() {
        final Quad<Object, String, String, String> quad0 = Quad.of("a", "b", "c", "d");
        final Quad<Object, String, String, String> quad1 = quad0.mapV3(Function.identity());

        assertEquals(quad0, quad1);
    }

    @Test
    public void testMap() {
        final Quad<Object, String, String, String> quad0 = Quad.of("a", "b", "c", "d");
        final Quad<Object, String, String, String> quad1 =
            quad0.map(Function.identity(), Function.identity(), Function.identity(), Function.identity());

        assertEquals(quad0, quad1);
    }

    @Test
    public void testToString() {
        final Quad<Object, String, String, String> quad = Quad.of("a", "b", "c", "d");

        assertEquals("[a, b, c, d]", quad.toString());
    }

    @Test
    public void testEquals() {
        final Quad<Object, String, String, String> quad0 = Quad.of("a", "b", "c", "d");
        final Quad<Object, String, String, String> quad1 = Quad.of("a", "b", "c", "d");

        assertTrue(quad0.equals(quad1));
        assertTrue(quad1.equals(quad0));
        assertEquals(quad0.hashCode(), quad1.hashCode());
    }

    @Test
    public void testNotEqualsNull() {
        final Quad<Object, String, String, String> quad0 = Quad.of("a", "b", "c", "d");

        assertFalse(quad0.equals(null));
    }

    @Test
    public void testNotEqualsObject() {
        final Quad<Object, String, String, String> quad0 = Quad.of("a", "b", "c", "d");

        assertFalse(quad0.equals(new Object()));
    }

    @Test
    public void testNotEqualsDifferent() {
        final Quad<Object, String, String, String> quad0 = Quad.of("a", "b", "c", "d");
        final Quad<Object, String, String, String> quad1 = Quad.of("a", "b", "c", "e");

        assertFalse(quad0.equals(quad1));
    }

    @Test
    public void testEqualsSelf() {
        final Quad<Object, String, String, String> quad0 = Quad.of("a", "b", "c", "d");

        assertTrue(quad0.equals(quad0));
    }
}
