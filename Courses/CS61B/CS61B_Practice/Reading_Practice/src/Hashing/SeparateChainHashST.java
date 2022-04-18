package Hashing;

public class SeparateChainHashST<Key, Value> {

    private class LinkedListNode<Key, Value> {
        // Store the key
        private Key key;

        // Store the value
        private Value val;

        // Previous Node
        private LinkedListNode prev;

        // Next Node
        private LinkedListNode next;

        private LinkedListNode(Key key, Value val) {
            this.key = key;
            this.val = val;
            this.next = null;
        }
    }

    private LinkedListNode<Key, Value>[] keys;

    // Number of keys inserted in table.
    private int N;

    // Size of Separate Chaining table
    private int size;

    public SeparateChainHashST(int s) {
        keys = (LinkedListNode<Key, Value>[]) new LinkedListNode[s];
        this.size = s;
        this.N = 0;
    }

    // Private helper method to hash
    private int hash(Key key) {
        return (key.hashCode() & 0x7fffffff) % size;
    }

    /**
     * Put the key-value pair into table
     *
     * @param key
     * @param val
     */
    public void put(Key key, Value val) {
        int hash = hash(key);
        if (keys[hash] == null) {
            keys[hash] = new LinkedListNode(key, val);
            N += 1;
            return;
        }
        LinkedListNode p = keys[hash];
        for (LinkedListNode q = keys[hash]; q != null; q = q.next) {
            if (q.key == key) {
                q.val = val;
                return;
            }
            p = q;
        }
        LinkedListNode cmp = new LinkedListNode(key, val);
        cmp.prev = p;
        p.next = cmp;
        N += 1;
    }

    /**
     * Get the value through key
     *
     * @param key
     * @return
     */
    public Value get(Key key) {
        int hash = hash(key);
        for (LinkedListNode p = keys[hash]; p != null; p = p.next) {
            if (p.key == key) {
                return (Value) p.val;
            }
        }
        return null;
    }

    /**
     * The number of Key-Value pairs in table
     *
     * @return
     */
    public int size() {
        return N;
    }

    /**
     * Find whether the table contains specific key
     *
     * @param key
     * @return
     */
    public boolean contains(Key key) {
        if (get(key) == null) {
            return false;
        } else {
            return true;
        }
    }

    public void delete(Key key) {
        if (!contains(key)) {
            return;
        }
        int hash = hash(key);
        if (keys[hash].next == null) {
            keys[hash] = null;
        } else {
            LinkedListNode<Key, Value> p = keys[hash];
            LinkedListNode<Key, Value> q = p;
            while (p.key != key) {
                q = p;
                p = p.next;
            }
            q.next = p.next;
            p.next.prev = q;
        }
    }
}
