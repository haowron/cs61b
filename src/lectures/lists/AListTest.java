package lectures.lists;

import org.junit.Test;

import static org.junit.Assert.*;

public class AListTest {

    @Test
    public void testAList1() {
        AList<Integer> l = new AList<Integer>();
        assertEquals(0, l.size());
        assertTrue(l.isEmpty());
        assertEquals("[]", l.toString());
    }

    @Test
    public void testALList2() {
        AList<Integer> l = new AList<Integer>();
        // 5 3 1 2 4
        l.addFirst(1);
        l.addLast(2);
        l.addFirst(3);
        l.addFirst(5);
        l.addLast(4);
        assertEquals(5, l.size());
        assertFalse(l.isEmpty());
        assertEquals("[5, 3, 1, 2, 4]", l.toString());
        assertEquals(5, (int) l.removeFirst());
        assertEquals(4, (int) l.removeLast());
        assertEquals(3, l.size());
        assertFalse(l.isEmpty());
        assertEquals("[3, 1, 2]", l.toString());
    }

    @Test
    public void testALList3() {
        AList<Integer> l = new AList<Integer>();
        l.addLast(6);
        l.addFirst(1);
        l.addLast(2);
        l.addFirst(3);
        l.addFirst(5);
        l.addLast(4);
        l.addLast(7);
        l.addLast(8);
        l.addFirst(9);
        assertEquals(9, l.size());
        assertFalse(l.isEmpty());
        assertEquals("[9, 5, 3, 1, 6, 2, 4, 7, 8]", l.toString());
        assertEquals(9, (int) l.removeFirst());
        assertEquals(8, (int) l.removeLast());
        assertEquals(7, l.size());
        assertFalse(l.isEmpty());
        assertEquals("[5, 3, 1, 6, 2, 4, 7]", l.toString());
        assertEquals(6, (int) l.get(3));
        assertEquals(4, (int) l.get(5));
    }
}
