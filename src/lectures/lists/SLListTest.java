package lectures.lists;

import org.junit.Test;

import static org.junit.Assert.*;

public class SLListTest {
    @Test
    public void testSLList1() {
        SLLists l = new SLLists();
        assertEquals(l.size, 0);

        l = new SLLists(3);
        l.addFirst(2);
        l.addLast(4);
        assertEquals(l.size, 3);
        assertEquals(l.toString(), "2 3 4");
    }

    @Test
    public void testSLList2() {
        SLLists l;
        l = new SLLists(3);
        l.addFirst(2);
        l.addLast(4);
        assertEquals(l.size, 3);
        assertEquals(l.toString(), "2 3 4");
    }
}
