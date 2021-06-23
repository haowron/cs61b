package lectures.iterators;

import org.junit.Test;

import java.lang.reflect.Executable;

import static org.junit.Assert.*;

public class SLListTest {
    @Test
    public void testEmptyListLengthIsZero() {
        SLList<Integer> l = new SLList<>();
        assertEquals(l.size(), 0);
    }

    @Test
    public void testAddFirstAddLast() {
        SLList<Integer> l = new SLList<>();
        l.addFirst(3);
        l.addFirst(2);
        l.addFirst(1);
        l.addLast(4);
        assertEquals(l.size(), 4);
        assertEquals(l.toString(), "[1, 2, 3, 4]");
    }

    @Test(expected = Exception.class)
    public void testRemoveLastWithEmptyListThrowException() throws Exception {
        SLList<Integer> l = new SLList<>();
        l.removeLast();
    }

    @Test
    public void testGetFirstGetLast() {
        SLList<Integer> l = new SLList<>();
        l.addLast(3);
        l.addLast(4);
        assertEquals(3, (int) l.getFirst());
        assertEquals(4, (int) l.getLast());
        assertEquals(2, l.size());
    }


    @Test
    public void testRemoveLast() throws Exception {
        SLList<Integer> l = new SLList<>();
        l.addFirst(3);
        l.addLast(4);
        l.addLast(5);
        assertEquals(5, (int) l.removeLast());
        assertEquals("[3, 4]", l.toString());
        assertEquals(2, l.size());
    }

    @Test
    public void testGet() throws Exception {
        SLList<Integer> l = new SLList<>();
        // 5 4 3
        l.addFirst(3);
        l.addFirst(4);
        l.addFirst(5);
        assertEquals(5, (int) l.get(0));
        assertEquals(4, (int) l.get(1));
        assertEquals(3, (int) l.get(2));
    }

    @Test(expected = Exception.class)
    public void testGetOutOfRange() throws Exception {
        SLList<Integer> l = new SLList<>();
        // 5 4 3
        l.addFirst(3);
        l.addFirst(4);
        l.addFirst(5);
        l.get(3);
    }

    @Test
    public void testInsert() throws Exception {
        SLList<Integer> l = new SLList<>();
        l.addLast(3);
        l.addLast(4);
        l.addLast(5);
        l.insert(2, 0);
        assertEquals("[3, 2, 4, 5]", l.toString());
    }

    @Test(expected = Exception.class)
    public void testInsertOutOfRange() throws Exception {
        SLList<Integer> l = new SLList<>();
        l.addLast(3);
        l.addLast(4);
        l.addLast(5);
        l.insert(3, 3);
    }

    @Test
    public void testIterator() {
        SLList<Integer> l = new SLList<>();
        l.addLast(3);
        l.addLast(4);
        l.addLast(5);
        StringBuilder actual = new StringBuilder();
        for (int i : l) {
            actual.append(i);
        }
        assertEquals("345", actual.toString());
    }

    @Test
    public void testEquals() {
        SLList<Integer> l1 = new SLList<>();
        l1.addLast(3);
        l1.addLast(4);
        l1.addLast(5);
        SLList<Integer> l2 = new SLList<>();
        l2.addFirst(5);
        l2.addFirst(4);
        l2.addFirst(3);
        assertEquals(l1, l2);
        assertEquals(l1, l1);
        assertNotEquals(l1, null);
        assertNotEquals(l1, "[3, 4, 5]");
    }
}
