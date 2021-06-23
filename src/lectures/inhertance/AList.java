package lectures.inhertance;

import org.jetbrains.annotations.NotNull;

public class AList<Item> {
    int RFACTOR;
    int _double_RFACTOR;
    int _half_RFACTOR;
    int first = 0;
    Item[] item;
    int size = 0;

    public AList() {
        RFACTOR = 8;
        _double_RFACTOR = 6;
        _half_RFACTOR = 2;
        item = (Item[]) new Object[RFACTOR];
    }

    public AList(int s) {
        RFACTOR = s;
        _double_RFACTOR = RFACTOR / 4 * 3;
        _half_RFACTOR = RFACTOR / 4;
        item = (Item[]) new Object[RFACTOR];
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    private void copy(@NotNull AList a) {
        // first to end
        System.arraycopy(a.item, a.first, item, 0, a.RFACTOR - a.first);
        // 0 to first
        System.arraycopy(a.item, 0, item, a.RFACTOR - a.first, (a.size + a.first) % a.RFACTOR);
    }

    private void check() {
        if (size > _double_RFACTOR) {
            resize(true);
        } else if (_half_RFACTOR != 2 && size < _half_RFACTOR) {
            resize(false);
        }
    }

    private void resize(@NotNull Boolean enlarge) {
        int new_RFACTOR = RFACTOR;
        if (enlarge) {
            new_RFACTOR *= 2;
        } else {
            new_RFACTOR = Math.max(8, RFACTOR / 2);
        }
        AList<Item> a = new AList(new_RFACTOR);
        a.copy(this);
        item = a.item;
        first = a.first;
        RFACTOR = a.RFACTOR;
        _double_RFACTOR = a._double_RFACTOR;
        _half_RFACTOR = a._half_RFACTOR;
    }

    public void addFirst(Item v) {
        check();
        first = (first - 1 + RFACTOR) % RFACTOR;
        item[first] = v;
        size += 1;
    }

    public void addLast(Item v) {
        check();
        item[(size + first) % RFACTOR] = v;
        size += 1;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        for (int i = 0; i < size - 1; ++i) {
            sb.append(item[(i + first) % RFACTOR]).append(", ");
        }
        if (!isEmpty()) {
            sb.append(item[(size + first - 1) % RFACTOR]);
        }
        sb.append("]");
        return sb.toString();
    }

    public Item removeFirst() {
        if (isEmpty()) {
            return null;
        }
        size -= 1;
        Item i = item[first];
        first = (first + 1) % RFACTOR;
        check();
        return i;
    }

    public Item removeLast() {
        if (size == 0) {
            return null;
        }
        size -= 1;
        Item i = item[(size + first) % RFACTOR];
        check();
        return i;
    }

    public Item get(int index) {
        if (index >= size) {
            return null;
        }
        return item[(first + index) % RFACTOR];
    }

    public static void main(String[] args) {

    }
}

