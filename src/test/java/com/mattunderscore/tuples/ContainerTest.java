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
 * Unit test for {@link Container}.
 *
 * @author Matt Champion 20/04/2018
 */
public final class ContainerTest {
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
        final Container<Object> container = Container.of("a");

        assertEquals("a", container.v0());
    }

    @Test
    public void testAccept() {
        final Container<Object> container = Container.of("a");

        container.acceptV0(consumer);
        verify(consumer).accept("a");
    }

    @Test
    public void testApply() {
        final Container<Object> container = Container.of("a");

        container.applyV0(function);
        verify(function).apply("a");
    }

    @Test
    public void testMapV0() {
        final Container<Object> container0 = Container.of("a");
        final Container<Object> container1 = container0.mapV0(Function.identity());

        assertEquals(container0, container1);
    }

    @Test
    public void testMap() {
        final Container<Object> container0 = Container.of("a");
        final Container<Object> container1 = container0.map(Function.identity());

        assertEquals(container0, container1);
    }

    @Test
    public void testToString() {
        final Container<Object> container = Container.of("a");

        assertEquals("[a]", container.toString());
    }

    @Test
    public void testEquals() {
        final Container<Object> container0 = Container.of("a");
        final Container<Object> container1 = Container.of("a");

        assertTrue(container0.equals(container1));
        assertTrue(container1.equals(container0));
        assertEquals(container0.hashCode(), container1.hashCode());
    }

    @Test
    public void testNotEqualsNull() {
        final Container<Object> container0 = Container.of("a");

        assertFalse(container0.equals(null));
    }

    @Test
    public void testNotEqualsObject() {
        final Container<Object> container0 = Container.of("a");

        assertFalse(container0.equals(new Object()));
    }

    @Test
    public void testNotEqualsDifferent() {
        final Container<Object> container0 = Container.of("a");
        final Container<Object> container1 = Container.of("b");

        assertFalse(container0.equals(container1));
    }

    @Test
    public void testEqualsSelf() {
        final Container<Object> container0 = Container.of("a");

        assertTrue(container0.equals(container0));
    }
}
