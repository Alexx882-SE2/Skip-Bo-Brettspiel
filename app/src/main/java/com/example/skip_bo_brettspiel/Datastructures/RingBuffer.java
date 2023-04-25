package com.example.skip_bo_brettspiel.Datastructures;

/**
 * A RingBuffer is a fixed-size buffer that behaves like a circular data structure.
 * It stores a maximum number of elements defined during instantiation and overwrites
 * the oldest element if the buffer is full.
 *
 * @param <T> the type of elements in this buffer
 */
public class RingBuffer<T> {

    private final T[] buffer;
    private int size;
    private int readIndex;
    private int writeIndex;

    /**
     * Constructs a RingBuffer with a given capacity.
     *
     * @param capacity the maximum number of elements this buffer can store
     */
    public RingBuffer(int capacity) {
        buffer = (T[]) new Object[capacity];
        size = 0;
        readIndex = 0;
        writeIndex = 0;
    }

    /**
     * Returns the number of elements in this buffer.
     *
     * @return the number of elements in this buffer
     */
    public int getSize() {
        return size;
    }

    /**
     * Returns the maximum number of elements this buffer can store.
     *
     * @return the capacity of this buffer
     */
    public int getCapacity() {
        return buffer.length;
    }

    /**
     * Returns the element at the specified index in this buffer.
     *
     * @param index the index of the element to return
     * @return the element at the specified index
     * @throws IndexOutOfBoundsException if the index is out of range (index < 0 || index >= size)
     */
    public T get(int index) throws IndexOutOfBoundsException {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        return buffer[(readIndex + index) % buffer.length];
    }

    /**
     * Adds an element to the end of this buffer.
     * If the buffer is full, the oldest element is overwritten.
     *
     * @param item the element to add
     */
    public void add(T item) {
        buffer[writeIndex] = item;
        writeIndex = (writeIndex + 1) % buffer.length;
        if (size < buffer.length) {
            size++;
        } else {
            readIndex = (readIndex + 1) % buffer.length;
        }
    }

    /**
     * Removes and returns the oldest element from this buffer.
     *
     * @return the oldest element in this buffer
     * @throws IllegalStateException if the buffer is empty
     */
    public T remove() throws IllegalStateException {
        if (size == 0) {
            throw new IllegalStateException();
        }
        T item = buffer[readIndex];
        readIndex = (readIndex + 1) % buffer.length;
        size--;
        return item;
    }

    /**
     * Moves the specified position by the given number of steps.
     * The position is treated as if it were an index in this buffer.
     * If the resulting position is out of range, it wraps around.
     *
     * @param position the initial position to move
     * @param steps the number of steps to move the position
     * @return the new position after moving
     */
    public int move(int position, int steps) {
        return (position + steps + buffer.length) % buffer.length;
    }
}

