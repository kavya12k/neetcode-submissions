class Node {
    public int key;
    public int val;
    public Node prev;
    public Node next;
    
    public Node(int key, int val) {
        this.key = key;
        this.val = val;
    }
    
   
}

class LRUCache {
    Map<Integer, Node> lookup;
    int cap;
    Node head;
    Node tail;

    public LRUCache(int capacity) {
        lookup = new HashMap<Integer, Node>();
        cap = capacity; 
        head = new Node(-1, -1);
        tail = new Node(-1, -1);
        head.next = tail;
        tail.prev = head;
    }

    protected void insert(Node nd) {
        nd.prev = tail.prev;
        nd.next = tail;
        tail.prev.next = nd;
        tail.prev = nd;
    }

    protected void remove(Node nd) {
        nd.prev.next = nd.next;
        nd.next.prev = nd.prev;
    }
    
    public int get(int key) {
        if (lookup.containsKey(key)) {
            Node nd = lookup.get(key);
            remove(nd);
            insert(nd);
            return nd.val;
        }
        return -1;
    }
    
    public void put(int key, int value) {
        if (lookup.containsKey(key)) {
            Node nd = lookup.get(key);
            nd.val = value;
            remove(nd);
            insert(nd);
        } else {
            if (lookup.size() == cap) {
                Node extract = head.next;
                remove(extract);
                lookup.remove(extract.key);
            }
            Node newNd = new Node(key, value);
            lookup.put(key, newNd);
            insert(newNd);
        }
       
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */