package dk.via.queue;

import java.util.*;

public class ThreadSafeQueue<T> implements Queue<T> {
    private final LinkedList<T> elements;

    public ThreadSafeQueue() {
        this.elements = new LinkedList<>();
    }

    @Override
    public synchronized int size() {
        return elements.size();
    }

    @Override
    public synchronized boolean isEmpty() {
        return elements.isEmpty();
    }

    @Override
    public synchronized boolean contains(Object o) {
        return elements.contains(o);
    }

    @Override
    public synchronized Iterator<T> iterator() {
        return elements.iterator();
    }

    @Override
    public synchronized Object[] toArray() {
        return elements.toArray();
    }

    @Override
    public synchronized <T1> T1[] toArray(T1[] a) {
        return elements.toArray(a);
    }

    @Override
    public synchronized boolean add(T t) {
        return add(t);
    }

    @Override
    public boolean remove(Object o) {
        return false;
    }

    @Override
    public synchronized boolean containsAll(Collection<?> c) {
        return elements.containsAll(c);
    }

    @Override
    public synchronized boolean addAll(Collection<? extends T> c) {
        return elements.addAll(c);
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        return false;
    }

    @Override
    public void clear() {
        throw new IllegalStateException();
    }

    @Override
    public synchronized boolean offer(T t) {
        elements.add(t);
        return true;
    }

    @Override
    public synchronized T remove() {
        if (elements.isEmpty()) {
            throw new NoSuchElementException();
        }
        return elements.remove(0);
    }

    @Override
    public synchronized T poll() {
        if (elements.isEmpty()) {
            return null;
        }
        return elements.remove(0);
    }

    @Override
    public synchronized T element() {
        if (elements.isEmpty()) {
            throw new NoSuchElementException();
        }
        return elements.get(0);
    }

    @Override
    public synchronized T peek() {
        if (elements.isEmpty()) {
            return null;
        }
        return elements.get(0);
    }
}
