package dk.via.adapter;

import java.util.HashMap;

public class TestClass {
    public static void main(String[] args) {
        Counter<String> counter = new Counter<>();
        counter.add("Cod");
        counter.add("Cow");
        counter.add("Cat");
        counter.add("Cod");
        counter.add("Cod");
        counter.add("Cat");
        counter.add("Dog");
        HashMap<String, Integer> theCount = counter.getTheCount();

        LegacyCode legacy = new LegacyCode();
        DictionaryAdapter<String, Integer> adapter = new DictionaryAdapter<>(theCount);
        legacy.printDict(adapter);
    }
}
