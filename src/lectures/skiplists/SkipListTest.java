package lectures.skiplists;

import org.junit.Test;

import static org.junit.Assert.*;

public class SkipListTest {
    public SkipList<Integer> generateSkipList() {
        SkipList<Integer> sl = new SkipList<>();
        sl.insert(5);
        sl.insert(3);
        sl.insert(1);
        sl.insert(2);
        sl.insert(7);
        sl.insert(9);
        sl.insert(6);
        sl.insert(4);
        sl.insert(0);
        sl.insert(8);
        return sl;
    }

    @Test
    public void testFind() {
        SkipList<Integer> sl = generateSkipList();
        assertEquals(1, (int) sl.find(1));
        assertEquals(null, sl.find(11));
    }
}
