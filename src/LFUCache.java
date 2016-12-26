import java.util.HashMap;

/**
 * Created by Bruno on 12/26/2016.
 */
public class LFUCache {


//    public static void main(String[] args){
//        LFUCache lfu = new LFUCache(2);
//        lfu.set(1,1);
//        lfu.set(2,2);
//        lfu.get(1);
//        lfu.set(3,3);
//        lfu.get(2);
//        lfu.get(3);
//        lfu.set(4,4);
//        lfu.get(1);
//        lfu.get(3);
//        lfu.get(4);
//
//    }

    public static void main(String[] args){
        LFUCache lfu = new LFUCache(2);
        lfu.set(2,1);
        lfu.set(1,1);
        lfu.set(2,3);
        lfu.set(4,1);
        lfu.get(1);
        lfu.get(2);
    }


    private class Node{
        private Node next;
        private Node previous;
        private int value;
        private int freq;
        private int key;

        public Node(int key, int value) {
            this.key = key;
            this.value = value;
            this.freq = 1;
        }

        public void inc(){
            this.freq++;
        }
    }

    private class LinkedList{

        private Node start;
        private Node end;

        public LinkedList() {
            this.start = new Node(Integer.MIN_VALUE, Integer.MIN_VALUE);
            this.end = new Node(Integer.MAX_VALUE, Integer.MAX_VALUE);
            this.start.next = end;
            this.end.previous = start;
        }

        private Node delete(Node node){
            Node previous = node.previous;
            Node next = node.next;
            previous.next = next;
            next.previous = previous;
            node.previous = null; node.next = null;
            return node;
        }

        private Node deleteLast(){
            return delete(this.start.next);
        }

        private Node insert(Node previous, Node node){
            Node next = previous.next;
            previous.next = node;
            node.previous = previous;
            next.previous = node;
            node.next = next;
            return node;
        }

    }

    private int capacity = 0;
    private HashMap<Integer, Node> keyToNode;
    private HashMap<Integer, Node> freqToNode;
    private LinkedList ll;
    private int quantity;

    public LFUCache(int capacity) {
        this.capacity = capacity;
        this.keyToNode = new HashMap<Integer, Node>();
        this.freqToNode = new HashMap<Integer, Node>();
        this.ll = new LinkedList();
        this.quantity = 0;
    }

    public int get(int key) {
        if(!this.keyToNode.containsKey(key))    return -1;
        Node node = this.keyToNode.get(key);
        Node nodef1 = this.freqToNode.getOrDefault(node.freq + 1, null);
        Node nodef = this.freqToNode.get(node.freq);
        if(nodef == node){
            nodef = node.previous;
            if(node.previous != this.ll.start && node.previous.freq == node.freq){
                this.freqToNode.put(node.freq, node.previous);
            } else {
                this.freqToNode.remove(node.freq);
            }
        }
        this.ll.delete(node);
        if(nodef1 != null){
            this.ll.insert(nodef1, node);
        } else {
            this.ll.insert(nodef, node);
        }
        this.freqToNode.put(node.freq + 1, node);
        node.inc();
        return node.value;
    }

    public void set(int key, int value) {
        if(capacity <= 0)   return;
        if(this.keyToNode.containsKey(key)){
            Node node = this.keyToNode.get(key);
            node.value = value;
            get(key);
            return;
        }
        if(quantity == capacity){
            Node node = this.ll.deleteLast();
            if(this.freqToNode.containsKey(node.freq) && this.freqToNode.get(node.freq) == node){
                this.freqToNode.remove(node.freq);
            }
            this.keyToNode.remove(node.key);
            quantity--;
        }
        Node lastAddedOneFreq = this.freqToNode.getOrDefault(1, this.ll.start);
        Node newNode = this.ll.insert(lastAddedOneFreq, new Node(key, value));
        this.freqToNode.put(1, newNode);
        this.keyToNode.put(key, newNode);
        quantity++;
    }
}
