package dk.via.collection;

import java.util.ArrayList;

public class RecentElements<E> {
    private final ArrayList<E> elements;
    private final int capacity;

    public RecentElements(int capacity) {
        if (capacity <= 0) {
            throw new IllegalArgumentException("capacity must be at least one");
        }
        this.capacity = capacity;
        elements = new ArrayList<>();
    }

    public int size() {
        return elements.size();
    }

    public void add(E e) {
        if (size() == capacity) {
            elements.remove(size() - 1);
        }
        elements.add(0, e);
    }

    public E get(int index) {
        return elements.get(index);
    }
}
