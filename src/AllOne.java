import java.util.HashMap;
import java.util.HashSet;

/**
 * Created by Bruno on 12/26/2016.
 */
public class AllOne {

    public static void main(String[] args){
        AllOne o = new AllOne();
        o.inc("a");
        o.inc("b");
        o.inc("b");
        o.inc("c");
        o.inc("c");
        o.inc("c");
        o.dec("b");
        o.dec("b");
        o.getMinKey();
        o.dec("a");
        o.getMaxKey();
        o.getMinKey();
    }


    private class Node {
        public Node next;
        public Node previous;
        private HashSet<String> set;
        private int num;

        public Node(int num) {
            this.num = num;
            this.set = new HashSet<String>();
        }

        public String getRandom(){
            for (String str: set) {
                return str;
            }
            return null;
        }

        public void add(String str){
            this.set.add(str);
        }

        public void remove(String str){
            this.set.remove(str);
        }

        public boolean isEmpty(){
            return this.set.isEmpty();
        }
    }

    private class HashLinkedList{
        public Node start;
        public Node end;

        public HashLinkedList() {
            start = new Node(0);
            end = new Node(Integer.MAX_VALUE);
            start.next = end;
            end.previous = start;
        }

        private Node insertNewAfterNode(Node node, int num){
            Node newNode = new Node(num);
            newNode.next = node.next;
            newNode.previous = node;
            node.next.previous = newNode;
            node.next = newNode;
            return newNode;
        }

        private void remove(Node node){
            node.previous.next = node.next;
            node.next.previous = node.previous;
        }
    }

    HashMap<String, Node> map;
    HashLinkedList ll;

    public AllOne() {
        this.map = new HashMap<String, Node>();
        this.ll = new HashLinkedList();
    }

    /** Inserts a new key <Key> with value 1. Or increments an existing key by 1. */
    public void inc(String key) {
        Node node;
        if(this.map.containsKey(key))   node = this.map.get(key);
        else    node = ll.start;
        Node targetNode;
        if(node.next.num == node.num + 1)   targetNode = node.next;
        else targetNode = ll.insertNewAfterNode(node, node.num + 1);
        node.remove(key);
        if(node != ll.start && node.isEmpty())  ll.remove(node);
        targetNode.add(key);
        this.map.put(key, targetNode);
    }

    /** Decrements an existing key by 1. If Key's value is 1, remove it from the data structure. */
    public void dec(String key) {
        if(!this.map.containsKey(key))  return;
        Node node = this.map.get(key);
        if(node.num == 1){
            this.map.remove(key);
            node.remove(key);
            if(node.isEmpty())  this.ll.remove(node);
        }
        else {
            Node targetNode;
            if(node.previous.num == node.num - 1)   targetNode = node.previous;
            else targetNode = ll.insertNewAfterNode(node.previous, node.num - 1);
            node.remove(key);
            if(node.isEmpty())  ll.remove(node);
            targetNode.add(key);
            this.map.put(key, targetNode);
        }
    }

    /** Returns one of the keys with maximal value. */
    public String getMaxKey() {
        Node node = this.ll.end.previous;
        if(node == this.ll.start)   return "";
        return node.getRandom();
    }

    /** Returns one of the keys with Minimal value. */
    public String getMinKey() {
        Node node = this.ll.start.next;
        if (node == this.ll.end)    return "";
        return node.getRandom();
    }

}
