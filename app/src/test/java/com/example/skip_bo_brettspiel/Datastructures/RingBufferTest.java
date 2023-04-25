package com.example.skip_bo_brettspiel.Datastructures;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class RingBufferTest {

    private RingBuffer<Integer> buffer;

    @BeforeEach
    public void setup() {
        buffer = new RingBuffer<>(5);
    }

    @AfterEach
    public void destroy(){buffer = null;}

    @Test
    public void testAdd() {
        buffer.add(1);
        assertEquals(1, buffer.getSize());
        assertEquals(1, buffer.get(0));
    }

    @Test
    public void testAddFullBuffer() {
        buffer.add(1);
        buffer.add(2);
        buffer.add(3);
        buffer.add(4);
        buffer.add(5);
        assertEquals(5, buffer.getSize());
        assertEquals(1, buffer.get(0));
        assertEquals(5, buffer.get(4));
    }


    @Test
    public void testRemove() {
        buffer.add(1);
        buffer.add(2);
        int item = buffer.remove();
        assertEquals(1, buffer.getSize());
        assertEquals(1, item);
        assertEquals(2, buffer.get(0));
    }

    @Test
    public void testRemoveEmpty() {
        assertThrows(IllegalStateException.class, () -> buffer.remove());
    }

    @Test
    public void testGet() {
        buffer.add(1);
        buffer.add(2);
        buffer.add(3);
        assertEquals(2, buffer.get(1));
    }

    @Test
    public void testGetEmpty() {
        assertThrows(IndexOutOfBoundsException.class, () -> buffer.get(0));
    }

    @Test
    public void testGetInvalidIndex() {
        buffer.add(1);
        assertThrows(IndexOutOfBoundsException.class, () -> buffer.get(1));
    }

    @Test
    public void testMoveWithinBounds() {
        assertEquals(2, buffer.move(0, 2));
        assertEquals(3, buffer.move(1, 2));
    }

    @Test
    public void testGetCapacity(){
        assertEquals(5,buffer.getCapacity());
    }
}

