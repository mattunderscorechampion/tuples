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
    @Rule
    public MockitoRule mockitoRule = MockitoJUnit.rule();

    @Mock
    private Consumer<Object> consumer;
    @Mock
    private Function<Object, Object> function;

    @Test
    public void testPair() {
        final Triple<Object, String, String> triple = Triple.of("a", "b", "c");

        assertEquals("a", triple.v0());
        assertEquals("b", triple.v1());
        assertEquals("c", triple.v2());
    }

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

    @Test
    public void testMapV0() {
        final Triple<Object, String, String> triple0 = Triple.of("a", "b", "c");
        final Triple<Object, String, String> triple1 = triple0.mapV0(Function.identity());

        assertEquals(triple0, triple1);
    }

    @Test
    public void testMapV1() {
        final Triple<Object, String, String> triple0 = Triple.of("a", "b", "c");
        final Triple<Object, String, String> triple1 = triple0.mapV1(Function.identity());

        assertEquals(triple0, triple1);
    }

    @Test
    public void testMapV2() {
        final Triple<Object, String, String> triple0 = Triple.of("a", "b", "c");
        final Triple<Object, String, String> triple1 = triple0.mapV2(Function.identity());

        assertEquals(triple0, triple1);
    }

    @Test
    public void testMap() {
        final Triple<Object, String, String> triple0 = Triple.of("a", "b", "c");
        final Triple<Object, String, String> triple1 = triple0.map(Function.identity(), Function.identity(), Function.identity());

        assertEquals(triple0, triple1);
    }

    @Test
    public void testEquals() {
        final Triple<Object, String, String> triple0 = Triple.of("a", "b", "c");
        final Triple<Object, String, String> triple1 = Triple.of("a", "b", "c");

        assertTrue(triple0.equals(triple1));
        assertTrue(triple1.equals(triple0));
        assertEquals(triple0.hashCode(), triple1.hashCode());
    }

    @Test
    public void testNotEqualsNull() {
        final Triple<Object, String, String> triple0 = Triple.of("a", "b", "c");

        assertFalse(triple0.equals(null));
    }

    @Test
    public void testNotEqualsObject() {
        final Triple<Object, String, String> triple0 = Triple.of("a", "b", "c");

        assertFalse(triple0.equals(new Object()));
    }

    @Test
    public void testNotEqualsDifferent() {
        final Triple<Object, String, String> triple0 = Triple.of("a", "b", "c");
        final Triple<Object, String, String> triple1 = Triple.of("a", "b", "d");

        assertFalse(triple0.equals(triple1));
    }
}
