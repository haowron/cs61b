package lectures.disjointsets;

import org.junit.Test;

import static org.junit.Assert.*;

public class QuickUnionDSTest {
    @Test
    public void testQuickFindDS() {
        QuickUnionDS qu = new QuickUnionDS(10);
        qu.connect(0, 1);
        qu.connect(0, 2);
        qu.connect(4, 7);
        qu.connect(7, 1);
        qu.connect(8, 9);
        assertTrue(qu.isConnected(2, 4));
        assertFalse(qu.isConnected(2, 8));
    }
}
