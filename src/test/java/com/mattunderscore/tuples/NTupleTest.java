/*
 * Copyright © 2018 Matt Champion
 */

package com.mattunderscore.tuples;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import static org.mockito.Mockito.verify;

import java.util.function.Consumer;
import java.util.function.Function;

import org.junit.Rule;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

/**
 * Unit test for {@link NTuple}.
 *
 * @author Matt Champion 21/04/2018
 */
public final class NTupleTest {
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
        final NTuple tuple = NTuple.of("a", "b");

        assertEquals("a", tuple.v(0));
        assertEquals("b", tuple.v(1));
    }

    /**
     * Test value accessing value with wrong arity throws exception.
     */
    @Test(expected = IndexOutOfBoundsException.class)
    public void testAccessWrongArity() {
        final NTuple tuple = NTuple.of("a", "b");

        final Object v = tuple.v(3);
        fail("Exception expected when returning " + v);
    }

    /**
     * Test value accessing value with wrong type throws exception.
     */
    @Test(expected = ClassCastException.class)
    public void testAccessWrongType() {
        final NTuple tuple = NTuple.of("a", "b");

        final Integer v = tuple.v(0);
        fail("Exception expected when returning " + v);
    }

    /**
     * Test value consumers.
     */
    @Test
    public void testAccept() {
        final NTuple tuple = NTuple.of("a", "b");

        tuple.acceptV(0, consumer);
        verify(consumer).accept("a");

        tuple.acceptV(1, consumer);
        verify(consumer).accept("b");
    }

    /**
     * Test applying functions to values.
     */
    @Test
    public void testApply() {
        final NTuple tuple = NTuple.of("a", "b");

        tuple.applyV(0, function);
        verify(function).apply("a");

        tuple.applyV(1, function);
        verify(function).apply("b");
    }

    /**
     * Test mapping value 0.
     */
    @Test
    public void testMapV0() {
        final NTuple tuple0 = NTuple.of("a", "b");
        final NTuple tuple1 = tuple0.mapV(0, Function.identity());

        assertEquals(tuple0, tuple1);
    }

    /**
     * Test mapping value 1.
     */
    @Test
    public void testMapV1() {
        final NTuple tuple0 = NTuple.of("a", "b");
        final NTuple tuple1 = tuple0.mapV(1, Function.identity());

        assertEquals(tuple0, tuple1);
    }

    /**
     * Test toString implementation.
     */
    @Test
    public void testToString() {
        final NTuple tuple = NTuple.of("a", "b");

        assertEquals("[a, b]", tuple.toString());
    }

    /**
     * Test two distinct objects are equal.
     */
    @Test
    public void testEquals() {
        final NTuple tuple0 = NTuple.of("a", "b");
        final NTuple tuple1 = NTuple.of("a", "b");

        assertTrue(tuple0.equals(tuple1));
        assertTrue(tuple1.equals(tuple0));
        assertEquals(tuple0.hashCode(), tuple1.hashCode());
    }

    /**
     * Test two distinct objects wrapping null are equal.
     */
    @Test
    public void testEqualsWrappingNull() {
        final NTuple tuple0 = NTuple.of("a", "b", null);
        final NTuple tuple1 = NTuple.of("a", "b", null);

        assertTrue(tuple0.equals(tuple1));
        assertTrue(tuple1.equals(tuple0));
        assertEquals(tuple0.hashCode(), tuple1.hashCode());
    }

    /**
     * Test not equal to null.
     */
    @Test
    public void testNotEqualsNull() {
        final NTuple tuple0 = NTuple.of("a", "b");

        assertFalse(tuple0.equals(null));
    }

    /**
     * Test not equal to object of different type.
     */
    @Test
    public void testNotEqualsObject() {
        final NTuple tuple0 = NTuple.of("a", "b");

        assertFalse(tuple0.equals(new Object()));
    }

    /**
     * Test not equal to container with different values.
     */
    @Test
    public void testNotEqualsDifferent() {
        final NTuple tuple0 = NTuple.of("a", "b");
        final NTuple tuple1 = NTuple.of("a", "c");

        assertFalse(tuple0.equals(tuple1));
    }

    /**
     * Test not equal to container with different values, one null.
     */
    @Test
    public void testNotEqualsDifferentWrappingNull() {
        final NTuple tuple0 = NTuple.of("a", "b", "c", "d");
        final NTuple tuple1 = NTuple.of("a", "b", "c", null);

        assertFalse(tuple0.equals(tuple1));
    }

    /**
     * Test object equals self.
     */
    @Test
    public void testEqualsSelf() {
        final NTuple tuple1 = NTuple.of("a", "b");

        assertTrue(tuple1.equals(tuple1));
    }
}
