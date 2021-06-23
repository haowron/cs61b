package lectures.skiplists;

import java.util.ArrayList;
import java.util.List;

public class SkipList<Item extends Comparable<Item>> {
    public class SkipListNode<Item extends Comparable<Item>> {
        Item value;
        List<SkipListNode<Item>> left, right;

        public SkipListNode() {
            value = null;
            left = new ArrayList<>();
            right = new ArrayList<>();
        }

        public SkipListNode(Item x) {
            value = x;
            left = new ArrayList<>();
            right = new ArrayList<>();
        }
    }

    int height;
    SkipListNode<Item> start;
    SkipListNode<Item> end;

    public SkipList() {
        start = new SkipListNode<>();
        end = new SkipListNode<>();
        start.right.add(end);
        end.left.add(start);
    }

    public Item find(Item x) {
        SkipListNode<Item> f = start;
        int h = height;
        while (h >= 0) {
            if (f == start) {
                f = f.right.get(h);
            } else if (f == end) {
                f = f.left.get(h);
                --h;
            } else if (x.compareTo(f.value) < 0) {
                f = f.left.get(h);
                --h;
            } else if (x.compareTo(f.value) > 0) {
                f = f.right.get(h);
            } else {
                return x;
            }
        }
        return null;
    }

    public boolean insert(Item x) {
        List<SkipListNode<Item>> updateLeft = new ArrayList<>();
        List<SkipListNode<Item>> updateRight = new ArrayList<>();
        SkipListNode<Item> f = start;
        int h = height;
        while (h >= 0) {
            if (f == start) {
                f = f.right.get(h);
            } else if (f == end) {
                updateRight.add(f);
                f = f.left.get(h);
                updateLeft.add(f);
                --h;
            } else if (x.compareTo(f.value) < 0) {
                updateRight.add(f);
                f = f.left.get(h);
                updateLeft.add(f);
                --h;
            } else if (x.compareTo(f.value) > 0) {
                f = f.right.get(h);
            } else {
                return false;
            }
        }
        SkipListNode<Item> new_node = new SkipListNode<>(x);
        int h_ = 0;
        while (h_ == 0 || Math.random() < 0.5) {
            if (h_ < height) {
                new_node.left.add(updateLeft.get(height - h_));
                updateLeft.get(height - h_).right.set(h_, new_node);
                new_node.right.add(updateRight.get(height - h_));
                updateRight.get(height - h_).left.set(h_, new_node);
            } else {
                new_node.left.add(start);
                new_node.right.add(end);
                start.right.set(h_, new_node);
                end.left.set(h_, new_node);
                start.right.add(end);
                end.left.add(start);
                ++height;
            }
            ++h_;
        }
        return true;
    }
}
