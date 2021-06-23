package lectures.heaps;

import org.junit.Test;

import static org.junit.Assert.*;

public class HeapTest {
    public Heap<Integer> generateHeap() {
        Heap<Integer> h = new Heap<>();
        h.insert(3);
        h.insert(4);
        h.insert(7);
        h.insert(2);
        h.insert(1);
        h.insert(5);
        h.insert(8);
        h.insert(9);
        h.insert(10);
        h.insert(6);
        return h;
    }

    @Test
    public void testInsert() {
        Heap<Integer> h = generateHeap();
        assertEquals(1, (int) h.getSmallest());
        h.popSmallest();
        assertEquals(2, (int) h.getSmallest());
        h.popSmallest();
        assertEquals(3, (int) h.getSmallest());
        h.popSmallest();
        assertEquals(4, (int) h.getSmallest());
        h.popSmallest();
        assertEquals(5, (int) h.getSmallest());
        h.popSmallest();
        assertEquals(6, (int) h.getSmallest());
        h.popSmallest();
        assertEquals(7, (int) h.getSmallest());
        h.popSmallest();
        assertEquals(8, (int) h.getSmallest());
        h.popSmallest();
        assertEquals(9, (int) h.getSmallest());
        h.popSmallest();
        assertEquals(10, (int) h.getSmallest());
        h.popSmallest();
    }
}
