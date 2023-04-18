package dk.via.queue;

import java.util.*;

public class ThreadSafeQueue<T> implements Queue<T> {
    private final ArrayDeque<T> elements;

    public ThreadSafeQueue() {
        this.elements = new ArrayDeque<>();
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
        return elements.add(t);
    }

    @Override
    public synchronized boolean remove(Object o) {
        return elements.remove(o);
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
    public synchronized boolean removeAll(Collection<?> c) {
        return elements.removeAll(c);
    }

    @Override
    public synchronized boolean retainAll(Collection<?> c) {
        return elements.retainAll(c);
    }

    @Override
    public synchronized void clear() {
        elements.clear();
    }

    @Override
    public synchronized boolean offer(T t) {
        return elements.offer(t);
    }

    @Override
    public synchronized T remove() {
        return elements.remove();
    }

    @Override
    public synchronized T poll() {
        return elements.poll();
    }

    @Override
    public synchronized T element() {
        return elements.element();
    }

    @Override
    public synchronized T peek() {
        return elements.peek();
    }
}
