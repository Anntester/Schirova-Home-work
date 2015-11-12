package com.kblyumkin.lecture8.examples.mystack;

import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class  MyStack<T> implements Iterable<T> {
    private static final int DEFAULT_HOLDER_SIZE = 2;
    private T[] holder;
    private int size;

    public MyStack() {
        holder = (T[]) new Object[DEFAULT_HOLDER_SIZE];
        size = 0;
    }

    public MyStack(T...values) {
        holder = (T[])new Object[values.length];
        int index = 0;
        for (T value : values) {
            holder[index++] = value;
            size++;
        }
    }

    public void push(T value) {
        ensureCapacity();
        holder[size++] = value;
    }

    public T pop() {
        return holder[--size];
    }

    @Override
    public String toString() {
        List<T> list = Arrays.asList(Arrays.copyOfRange(holder, 0, size));
        Collections.reverse(list);
        return Arrays.toString(list.toArray());
    }

    private void ensureCapacity() {
        if (holder.length == size) {
            T[] newHolder = (T[])new Object[holder.length << 1];
            System.arraycopy(holder, 0, newHolder, 0, holder.length);
            holder = newHolder;
        }
    }

    @Override
    public Iterator<T> iterator() {
        return new MyStackIterator();
    }

    private class MyStackIterator implements Iterator<T> {
        private int position = size;

        @Override
        public boolean hasNext() {
            return position > 0;
        }

        @Override
        public T next() {
            return holder[--position];
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException();
        }
    }
}
