package dk.via.adapter;

import java.util.Dictionary;
import java.util.Enumeration;
import java.util.Map;

public class DictionaryAdapter<T, U> extends Dictionary<T, U> {
    private final Map<T, U> map;

    public DictionaryAdapter(Map<T, U> map) {
        this.map = map;
    }

    @Override
    public int size() {
        return map.size();
    }

    @Override
    public boolean isEmpty() {
        return map.isEmpty();
    }

    @Override
    public Enumeration<T> keys() {
        return new EnumerationAdapter<>(map.keySet().iterator());
    }

    @Override
    public Enumeration<U> elements() {
        return new EnumerationAdapter<>(map.values().iterator());
    }

    @Override
    public U get(Object key) {
        return map.get(key);
    }

    @Override
    public U put(T key, U value) {
        return map.put(key, value);
    }

    @Override
    public U remove(Object key) {
        return map.remove(key);
    }
}
