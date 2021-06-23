package lectures.heaps;

import java.util.ArrayList;
import java.util.List;

public class Heap<Item extends Comparable<Item>> {
    private final List<Item> arr;

    public Heap() {
        arr = new ArrayList<>();
    }


    private void swim(int cur, int par) {
        Item tmp = arr.get(cur);
        arr.set(cur, arr.get(par));
        arr.set(par, tmp);
    }

    public Item getSmallest() {
        if (arr.isEmpty()) {
            return null;
        }
        return arr.get(0);
    }

    public void insert(Item x) {
        arr.add(x);
        int cur = arr.size() - 1;
        while (cur != 0 && arr.get(cur).compareTo(arr.get(cur >> 1)) < 0) {
            swim(cur, cur >> 1);
            cur = cur >> 1;
        }
    }

    public void popSmallest() {
        arr.set(0, arr.get(arr.size() - 1));
        arr.remove(arr.size() - 1);
        int cur = 0;
        while (cur < arr.size()) {
            int left = (cur << 1) + 1;
            int right = left + 1;
            Item c = arr.get(cur);
            Item l = null, r = null;
            if (left < arr.size()) {
                l = arr.get(left);
            }
            if (right < arr.size()) {
                r = arr.get(right);
            }
            if (r != null) {
                if (c.compareTo(l) > 0 && l.compareTo(r) < 0) {
                    swim(cur, left);
                    cur = left;
                } else if (c.compareTo(r) > 0 && r.compareTo(l) < 0) {
                    swim(cur, right);
                    cur = right;
                } else {
                    break;
                }
            } else if (l != null) {
                if (c.compareTo(l) > 0) {
                    swim(cur, left);
                    break;
                } else {
                    break;
                }
            } else {
                break;
            }
        }
    }
}
