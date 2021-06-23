package lectures.disjointsets;

import static org.junit.Assert.*;

import org.junit.Test;

public class QuickFindDSTest {
    @Test
    public void testQuickFindDS() {
        QuickFindDS qf = new QuickFindDS(10);
        qf.connect(0, 1);
        qf.connect(0, 2);
        qf.connect(4, 7);
        qf.connect(7, 1);
        qf.connect(8, 9);
        assertTrue(qf.isConnected(2, 4));
        assertFalse(qf.isConnected(2, 8));
    }
}
