//import java.util.HashMap;
//import java.util.concurrent.Semaphore;
//
///**
// * Created by Bruno on 7/18/2016.
// */
//public class Cache {
//
//
//    public static void main(String[] args){
//        Cache cache = new Cache(3);
//        System.out.println(cache.get(0));
//        cache.put(0, 0);
//        System.out.println(cache.get(0));
//        cache.put(1,1);
//        System.out.println(cache.get(1));
//        System.out.println(cache);
//        cache.put(2,2);
//        System.out.println(cache.get(2));
//        cache.put(3,3);
//        System.out.println(cache.get(3));
//        System.out.println(cache);
//        cache.get(2);
//        System.out.println(cache);
//        cache.get(1);
//        System.out.println(cache);
//        cache.put(3, -3);
//        System.out.println(cache);
//    }
//
//    // Least Recent Used
//
//    private int capacity;
//    private int length;
//    private Node dummy;
//    private HashMap<Integer, Node> map;
//    private Object lockObject = new Object();
//    private Semaphore semaphoreRead = new Semaphore(0);
//    private Semaphore semaphoreWrite = new Semaphore(1);
//    // [1] -> [2] -> [3]
//    // put (4, something)
//    // [4] -> [1] -> [2]
//    // put (2, something)
//    // [2] - > [4] -> [1]
//
//
//    // [dummy] < - > [2] <- > [4] <-> [1] -|
//    // <-------------------------------
//    // capacity 0 or negative
//    public Cache(int capacity) {
//        this.capacity = (capacity < 0 ? 0 : capacity);
//        this.map = new HashMap<Integer, Node>();
//        this.dummy = new Node();
//        this.dummy.setNext(this.dummy); // [Dummy] -> itself
//        this.dummy.setPrevious(this.dummy); // [Dummy] -> itself
//        this.length = 0;
//    }
//
//    // t1 t2 t3 get1 1 get2 2   dummy <-> 2 <->  1 <-> rest <-> || dummy <-> 1 <->  2 <-> rest <->
//
//
//    // null if not in the cache
//    public Object get(int key) throws InterruptedException {
//        semaphoreRead.release();
//        if(!map.containsKey(key)){
//            return null;
//        }
//        Node node = map.get(key);
//        moveToFirst(node); //syncronized
//        semaphoreRead.acquire();
//        return node.getObj();
//    }
//
//
//
//
//    //CACHE put1 unlock after put1 finished  get1 put2 would wait until get1 finishes
//    // r1 -> deleteLastNode | r2 -> capacity - 1 ==> length = capacity - 1 + 1 => r1 -> length = capacity + 1
//    public void put(int key, Object obj) throws InterruptedException {
//        semaphoreWrite.acquire();
//        semaphoreRead.acquire();
//        Node node;
//        if(map.containsKey(key)){
//            node = map.get(key);
//            moveToFirst(node);
//            node.setObj(obj);
//            return;
//        } else if (length == this.capacity){
//            node = deleteLastNode();
//        } else  {
//            node = new Node();
//        }
//        node.setKey(key);
//        node.setObj(obj);
//        insertFirst(node);
//        semaphoreRead.release();
//        semaphoreWrite.release();
//    }
//
//    private Node deleteLastNode(){
//        Node lastNode = this.dummy.getPrevious();
//        delete(lastNode);
//        return lastNode;
//    }   //dummy <-> [1] <-> [2]   delete([2])
//        // <------------------>
//
//    // node is not null
//    private Node moveToFirst(Node node){
//        delete(node);
//        insertFirst(node);
//        return node;
//    }
//
//
//    // node is not null
//    private synchronized void insertFirst(Node node){
//        length++;
//        Node firstNode = this.dummy.getNext();
//        dummy.setNext(node);
//        firstNode.setPrevious(node);
//        node.setNext(firstNode);
//        node.setPrevious(this.dummy);
//        map.put(node.getKey(), node);
//    }// dummy -> first  node ===>   dummy <-> node <-> firstNode
//
//    private synchronized void delete(Node node){
//        length--;
//        Node nextNode = node.getNext();
//        Node previousNode = node.getPrevious();
//        nextNode.setPrevious(previousNode);
//        previousNode.setNext(nextNode);
//        map.remove(node.getKey());
//    } // [1] <-> [2] <-> [3] == > pn = [1] nextnode = [3] node = [2] => [1] <-> [3] => return [2]
//
//    @Override
//    public String toString() {
//        Node node = this.dummy.getNext();
//        StringBuilder sb = new StringBuilder();
//        sb.append("[");
//        while (node != this.dummy){
//            sb.append(node.toString());
//            node = node.getNext();
//        }
//        sb.append("]");
//        return sb.toString();
//    }
//
//    private class Node {
//
//        private Node next;
//        private Node previous;
//        private Object obj;
//        private int key;
//
//        public Node() {
//        }
//
//        public Node(Node next, Node previous, Object obj, int key) {
//            this.next = next;
//            this.previous = previous;
//            this.obj = obj;
//            this.key = key;
//        }
//
//        public void setNext(Node next) {
//            this.next = next;
//        }
//
//        public void setPrevious(Node previous) {
//            this.previous = previous;
//        }
//
//        public void setObj(Object obj) {
//            this.obj = obj;
//        }
//
//        public void setKey(int key) {
//            this.key = key;
//        }
//
//        public Node getNext() {
//            return next;
//        }
//
//        public Node getPrevious() {
//            return previous;
//        }
//
//        public Object getObj() {
//            return obj;
//        }
//
//        public int getKey() {
//            return key;
//        }
//
//        @Override
//        public String toString() {
//            return "Node{" +
//                    "obj=" + obj +
//                    '}';
//        }
//    }
//}
