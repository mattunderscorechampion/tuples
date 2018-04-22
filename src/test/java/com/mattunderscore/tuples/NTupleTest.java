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

    @Test
    public void testAccess() {
        final NTuple tuple = NTuple.of("a", "b");

        assertEquals("a", tuple.v(0));
        assertEquals("b", tuple.v(1));
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testAccessWrongArity() {
        final NTuple tuple = NTuple.of("a", "b");

        tuple.v(3);
    }

    @Test(expected = ClassCastException.class)
    public void testAccessWrongType() {
        final NTuple tuple = NTuple.of("a", "b");

        final Integer integer = tuple.v(0);
    }

    @Test
    public void testAccept() {
        final NTuple tuple = NTuple.of("a", "b");

        tuple.acceptV(0, consumer);
        verify(consumer).accept("a");

        tuple.acceptV(1, consumer);
        verify(consumer).accept("b");
    }

    @Test
    public void testApply() {
        final NTuple tuple = NTuple.of("a", "b");

        tuple.applyV(0, function);
        verify(function).apply("a");

        tuple.applyV(1, function);
        verify(function).apply("b");
    }

    @Test
    public void testMapV0() {
        final NTuple tuple0 = NTuple.of("a", "b");
        final NTuple tuple1 = tuple0.mapV(0, Function.identity());

        assertEquals(tuple0, tuple1);
    }

    @Test
    public void testMapV1() {
        final NTuple tuple0 = NTuple.of("a", "b");
        final NTuple tuple1 = tuple0.mapV(1, Function.identity());

        assertEquals(tuple0, tuple1);
    }

    @Test
    public void testToString() {
        final NTuple tuple = NTuple.of("a", "b");

        assertEquals("[a, b]", tuple.toString());
    }

    @Test
    public void testEquals() {
        final NTuple tuple0 = NTuple.of("a", "b");
        final NTuple tuple1 = NTuple.of("a", "b");

        assertTrue(tuple0.equals(tuple1));
        assertTrue(tuple1.equals(tuple0));
        assertEquals(tuple0.hashCode(), tuple1.hashCode());
    }

    @Test
    public void testNotEqualsNull() {
        final NTuple tuple0 = NTuple.of("a", "b");

        assertFalse(tuple0.equals(null));
    }

    @Test
    public void testNotEqualsObject() {
        final NTuple tuple0 = NTuple.of("a", "b");

        assertFalse(tuple0.equals(new Object()));
    }

    @Test
    public void testNotEqualsDifferent() {
        final NTuple tuple0 = NTuple.of("a", "b");
        final NTuple tuple1 = NTuple.of("a", "c");

        assertFalse(tuple0.equals(tuple1));
    }

    @Test
    public void testEqualsSelf() {
        final NTuple tuple1 = NTuple.of("a", "b");

        assertTrue(tuple1.equals(tuple1));
    }
}
