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
 * Unit test for {@link Triple}.
 *
 * @author Matt Champion 19/04/2018
 */
public final class TripleTest {
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
        final Triple<Object, String, String> triple = Triple.of("a", "b", "c");

        assertEquals("a", triple.v0());
        assertEquals("b", triple.v1());
        assertEquals("c", triple.v2());
    }

    /**
     * Test value consumers.
     */
    @Test
    public void testAccept() {
        final Triple<Object, String, String> triple = Triple.of("a", "b", "c");

        triple.acceptV0(consumer);
        verify(consumer).accept("a");

        triple.acceptV1(consumer);
        verify(consumer).accept("b");

        triple.acceptV2(consumer);
        verify(consumer).accept("c");
    }

    /**
     * Test applying functions to values.
     */
    @Test
    public void testApply() {
        final Triple<Object, String, String> triple = Triple.of("a", "b", "c");

        triple.applyV0(function);
        verify(function).apply("a");

        triple.applyV1(function);
        verify(function).apply("b");

        triple.applyV2(function);
        verify(function).apply("c");
    }

    /**
     * Test mapping value 0.
     */
    @Test
    public void testMapV0() {
        final Triple<Object, String, String> triple0 = Triple.of("a", "b", "c");
        final Triple<Object, String, String> triple1 = triple0.mapV0(Function.identity());

        assertEquals(triple0, triple1);
    }

    /**
     * Test mapping value 1.
     */
    @Test
    public void testMapV1() {
        final Triple<Object, String, String> triple0 = Triple.of("a", "b", "c");
        final Triple<Object, String, String> triple1 = triple0.mapV1(Function.identity());

        assertEquals(triple0, triple1);
    }

    /**
     * Test mapping value 2.
     */
    @Test
    public void testMapV2() {
        final Triple<Object, String, String> triple0 = Triple.of("a", "b", "c");
        final Triple<Object, String, String> triple1 = triple0.mapV2(Function.identity());

        assertEquals(triple0, triple1);
    }

    /**
     * Test mapping all values.
     */
    @Test
    public void testMap() {
        final Triple<Object, String, String> triple0 = Triple.of("a", "b", "c");
        final Triple<Object, String, String> triple1 = triple0.map(Function.identity(), Function.identity(), Function.identity());

        assertEquals(triple0, triple1);
    }

    /**
     * Test toString implementation.
     */
    @Test
    public void testToString() {
        final Triple<Object, String, String> triple = Triple.of("a", "b", "c");

        assertEquals("[a, b, c]", triple.toString());
    }

    /**
     * Test two distinct objects are equal.
     */
    @Test
    public void testEquals() {
        final Triple<Object, String, String> triple0 = Triple.of("a", "b", "c");
        final Triple<Object, String, String> triple1 = Triple.of("a", "b", "c");

        assertTrue(triple0.equals(triple1));
        assertTrue(triple1.equals(triple0));
        assertEquals(triple0.hashCode(), triple1.hashCode());
    }

    /**
     * Test not equal to null.
     */
    @Test
    public void testNotEqualsNull() {
        final Triple<Object, String, String> triple0 = Triple.of("a", "b", "c");

        assertFalse(triple0.equals(null));
    }

    /**
     * Test not equal to object of different type.
     */
    @Test
    public void testNotEqualsObject() {
        final Triple<Object, String, String> triple0 = Triple.of("a", "b", "c");

        assertFalse(triple0.equals(new Object()));
    }

    /**
     * Test not equal to container with different values.
     */
    @Test
    public void testNotEqualsDifferent() {
        final Triple<Object, String, String> triple0 = Triple.of("a", "b", "c");
        final Triple<Object, String, String> triple1 = Triple.of("a", "b", "d");

        assertFalse(triple0.equals(triple1));
    }

    /**
     * Test object equals self.
     */
    @Test
    public void testEqualsSelf() {
        final Triple<Object, String, String> triple0 = Triple.of("a", "b", "c");

        assertTrue(triple0.equals(triple0));
    }
}
