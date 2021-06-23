package lectures.lists;

import org.junit.Test;

import static org.junit.Assert.*;

public class DLListTest {
    @Test
    public void testDLList1() {
        DLList<Integer> l = new DLList<Integer>();
        assertEquals(l.size(), 0);
        assertTrue(l.isEmpty());
        assertEquals("[]", l.toString());
    }

    @Test
    public void testDLList2() {
        DLList<Integer> l = new DLList<Integer>();
        l.addFirst(1);
        l.addLast(2);
        l.addFirst(3);
        l.addFirst(5);
        l.addLast(4);
        assertEquals(5, l.size());
        assertFalse(l.isEmpty());
        assertEquals("[5 3 1 2 4]", l.toString());
        assertEquals(5, (int) l.removeFirst());
        assertEquals(4, (int) l.removeLast());
        assertFalse(l.isEmpty());
        assertEquals("[3 1 2]", l.toString());
    }

    @Test
    public void testDLList3() {
        DLList<Integer> l = new DLList<Integer>();
        l = new DLList<Integer>(6);
        assertEquals(1, l.size());
        assertFalse(l.isEmpty());
        assertEquals("[6]", l.toString());
        l.addFirst(1);
        l.addLast(2);
        l.addFirst(3);
        l.addFirst(5);
        l.addLast(4);
        assertEquals(6, l.size());
        assertFalse(l.isEmpty());
        assertEquals("[5 3 1 6 2 4]", l.toString());
        assertEquals(5, (int) l.removeFirst());
        assertEquals(4, (int) l.removeLast());
        assertEquals(4, l.size());
        assertFalse(l.isEmpty());
        assertEquals("[3 1 6 2]", l.toString());
    }
}
