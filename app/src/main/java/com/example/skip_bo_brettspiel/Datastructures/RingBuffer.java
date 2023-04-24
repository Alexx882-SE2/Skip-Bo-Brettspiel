package com.example.skip_bo_brettspiel.Datastructures;

public class RingBuffer<T> {

    private final T[] buffer;
    private int size;
    private int readIndex;
    private int writeIndex;


    public RingBuffer(int capacity) {
        buffer = (T[]) new Object[capacity];
        size = 0;
        readIndex = 0;
        writeIndex = 0;
    }

    public int getSize() {
        return size;
    }

    public int getCapacity() {
        return buffer.length;
    }

    public T get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        return buffer[(readIndex + index) % buffer.length];
    }

    public void add(T item) {
        buffer[writeIndex] = item;
        writeIndex = (writeIndex + 1) % buffer.length;
        if (size < buffer.length) {
            size++;
        } else {
            readIndex = (readIndex + 1) % buffer.length;
        }
    }

    public T remove() {
        if (size == 0) {
            throw new IllegalStateException();
        }
        T item = buffer[readIndex];
        readIndex = (readIndex + 1) % buffer.length;
        size--;
        return item;
    }

    public int move(int position, int steps) {
        return (position + steps + buffer.length) % buffer.length;
    }
}
