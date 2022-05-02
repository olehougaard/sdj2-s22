package dk.via.collection;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RecentElementsTest {

    private RecentElements<Integer> recent;

    @BeforeEach
    void setUp() {
        recent = new RecentElements<>(2);
    }

    // Zero
    @Test
    public void new_collection_has_size_0() {
        assertEquals(0, recent.size());
    }

    // One
    @Test
    public void collection_has_size_1_after_adding_element() {
        recent.add(3);
        assertEquals(1, recent.size());
    }

    @Test
    public void adding_an_element_to_empty_collection_puts_it_in_0() {
        recent.add(3);
        assertEquals(3, recent.get(0));
    }

    // Many
    @Test
    public void adding_a_second_element_gives_size_2() {
        recent.add(3);
        recent.add(4);
        assertEquals(2, recent.size());
    }
    
    @Test
    public void adding_a_second_element_puts_it_at_0() {
        recent.add(3);
        recent.add(4);
        assertEquals(4, recent.get(0));
    }

    @Test
    public void adding_a_second_element_pushes_first_element_to_1() {
        recent.add(3);
        recent.add(4);
        assertEquals(3, recent.get(1));
    }

    // Boundary (most are already covered)
    @Test
    public void index_size_minus_1_gives_last_element() {
        recent.add(3);
        recent.add(4);
        assertEquals(3, recent.get(recent.size() - 1));
    }

    @Test
    public void adding_an_element_to_a_collection_at_capacity_pushes_last_element_out() {
        recent.add(3);
        recent.add(4);
        recent.add(5);
        assertEquals(2, recent.size());
        assertEquals(5, recent.get(0));
        assertEquals(4, recent.get(1));
    }

    // Exception
    @Test
    public void negative_indices_throws_IndexOutOfBounds() {
        recent.add(3);
        assertThrows(IndexOutOfBoundsException.class, () -> recent.get(-1));
    }

    @Test
    public void index_equal_to_size_throws_IndexOutOfBounds() {
        recent.add(3);
        recent.add(4);
        assertThrows(IndexOutOfBoundsException.class, () -> recent.get(recent.size()));
    }

    @Test
    public void get_on_empty_collection_throws_IndexOutOfBounds() {
        assertThrows(IndexOutOfBoundsException.class, () -> recent.get(0));
    }

    @Test
    public void zero_capacity_throws_IllegalArgument() {
        assertThrows(IllegalArgumentException.class, () -> new RecentElements<Integer>(0));
    }

    @Test
    public void negative_capacity_throws_IllegalArgument() {
        assertThrows(IllegalArgumentException.class, () -> new RecentElements<Integer>(-1));
    }
}
