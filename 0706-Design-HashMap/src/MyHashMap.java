import java.util.Arrays;

/**
 * @author qybit
 * @create 2020-12-17 16:15
 * @Since 1.0.0
 */
public class MyHashMap {

    public static void main(String[] args) {
        MyHashMap hashMap = new MyHashMap();
        hashMap.put(1, 1);
        hashMap.put(2, 2);
        hashMap.get(1);
        hashMap.get(3);
        hashMap.put(2, 1);
        hashMap.get(2);
        hashMap.remove(2);
        hashMap.get(2);
    }

    static class Node {
        int key;
        int value;
        Node next;

        public Node() {
        }

        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "key=" + key +
                    ", value=" + value +
                    '}';
        }
    }

    int N = 2069;
    Node[] table;

    /**
     * Initialize your data structure here.
     */
    public MyHashMap() {
        table = new Node[N];
    }

    /**
     * value will always be non-negative.
     */
    public void put(int key, int value) {
        int k = key % N;
        if (table[k] == null) {
            table[k] = new Node(key, value);
        } else {
            Node node = table[k];
            if (node.key == key) {
                node.value = value;
                return;
            }
            while (node.next != null) {
                if (node.next.key == key) {
                    node.next.value = value;
                }
                node = node.next;
            }
            node.next = new Node(key, value);
        }
    }

    /**
     * Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key
     */
    public int get(int key) {
        int k = key % N;
        if (table[k] != null) {
            Node node = table[k];
            if (node.key == key) {
                return node.value;
            }
            while (node.next != null) {
                if (node.next.key == key) {
                    return node.next.value;
                }
                node = node.next;
            }
        }
        return -1;
    }

    /**
     * Removes the mapping of the specified value key if this map contains a mapping for the key
     */
    public void remove(int key) {
        int k = key % N;
        if (table[k] != null) {
            Node node = table[k];
            if (node.key == key) {
                table[k] = node.next;
            } else {
                while (node != null && node.next != null) {
                    if (node.next.key == key) {
                        node.next = node.next.next;
                    }
                    node = node.next;
                }
            }
        }
    }
}
