import java.util.HashMap;
import java.util.Map;

/**
 * @author qybit
 * @create 2020-12-14 9:14
 * @Since 1.0.0
 */
public class LFUCache {

    Map<Integer, Node> cache;
    DoublyLinkedList firstLinkedList;
    DoublyLinkedList lastLinkedList;
    int size;
    int capacity;

    public LFUCache(int capacity) {
        cache = new HashMap<>(capacity);
        firstLinkedList = new DoublyLinkedList();
        lastLinkedList = new DoublyLinkedList();
        this.capacity = capacity;
        firstLinkedList.next = lastLinkedList;
        lastLinkedList.pre = firstLinkedList;
    }

    public int get(int key) {
        Node node = cache.get(key);
        if (node == null) {
            return -1;
        }
        // 访问频率 +1
        freInc(node);
        return node.value;
    }

    public void put(int key, int value) {
        if (capacity == 0) {
            return;
        }
        Node node = cache.get(key);
        if (node != null) {
            node.value = value;
            // 频率 +1
            freInc(node);
        } else {
            // 若 key 不存在
            if (size == capacity) {
                // 如果容量满了，此时需要移除最小访问频率的那个key
                cache.remove(lastLinkedList.pre.tail.pre.key);
                lastLinkedList.removeNode(lastLinkedList.pre.tail.pre);
                size--;
                // 如果为空了，此时需要删除链表
                if (lastLinkedList.pre.head.next == lastLinkedList.pre.tail) {
                    removeDoublyLinkedList(lastLinkedList.pre);
                }
            }
            // 新节点，如果没有 freq == 1的链表则添加，
            Node newNode = new Node(key, value);
            cache.put(key, newNode);
            if (lastLinkedList.pre.freq != 1) {
                DoublyLinkedList doublyLinkedList = new DoublyLinkedList(1);
                addDoublyLinkedList(doublyLinkedList, lastLinkedList.pre);
                doublyLinkedList.addNode(newNode);
            } else {
                lastLinkedList.pre.addNode(newNode);
            }
            size++;
        }
    }

    private void addDoublyLinkedList(DoublyLinkedList doublyLinkedList, DoublyLinkedList preLinkedList) {
        doublyLinkedList.next = preLinkedList.next;
        doublyLinkedList.next.pre = doublyLinkedList;
        doublyLinkedList.pre = preLinkedList;
        preLinkedList.next = doublyLinkedList;
    }

    private void removeDoublyLinkedList(DoublyLinkedList doublyLinkedList) {
        doublyLinkedList.pre.next = doublyLinkedList.next;
        doublyLinkedList.next.pre = doublyLinkedList.pre;
    }

    private void freInc(Node node) {
        // 先从原链表中 移除 node ，然后放入前一个节点，如果移除后，链表为空则删除，如果前一个链表不存在则创建新链表
        DoublyLinkedList doublyLinkedList = node.linkedList;
        DoublyLinkedList preDoublyLinkedList = doublyLinkedList.pre;
        doublyLinkedList.removeNode(node);
        if (doublyLinkedList.head.next == doublyLinkedList.tail) {
            removeDoublyLinkedList(doublyLinkedList);
        }
        node.freq++;
        if (preDoublyLinkedList.freq != node.freq) {
            DoublyLinkedList linkedList = new DoublyLinkedList(node.freq);
            addDoublyLinkedList(linkedList, preDoublyLinkedList);
            linkedList.addNode(node);
        } else {
            preDoublyLinkedList.addNode(node);
        }
    }
}

class Node {
    int key;
    int value;
    int freq = 1;
    Node pre;
    Node next;
    DoublyLinkedList linkedList;

    public Node() {
    }

    public Node(int key, int value) {
        this.key = key;
        this.value = value;
    }

}

class DoublyLinkedList {
    int freq;
    DoublyLinkedList pre;
    DoublyLinkedList next;
    Node head;
    Node tail;

    public DoublyLinkedList() {
        head = new Node();
        tail = new Node();
        head.next = tail;
        tail.pre = head;
    }

    public DoublyLinkedList(int freq) {
        this.freq = freq;
        head = new Node();
        tail = new Node();
        head.next = tail;
        tail.pre = head;
    }

    public void addNode(Node node) {
        node.next = head.next;
        head.next.pre = node;
        head.next = node;
        node.pre = head;
        node.linkedList = this;
    }

    public void removeNode(Node node) {
        node.pre.next = node.next;
        node.next.pre = node.pre;
    }
}
