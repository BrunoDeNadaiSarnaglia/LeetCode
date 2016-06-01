import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * Created by Bruno on 5/31/2016.
 */

public class SummaryRanges {


    public static void main(String[] args){
        SummaryRanges sr = new SummaryRanges();
        for (Integer num : new Integer[]{1, 3, 7, 2, 6}) {
            sr.addNum(num);
        }
        Utils.printArray(sr.getIntervals().toArray());
    }

    HashSet<Integer> set;

    Node root;

    /** Initialize your data structure here. */
    public SummaryRanges() {
        set = new HashSet<Integer>();
        root = null;
    }

    public void addNum(int val) {
        root = addNum(val, root);
    }

    private Node addNum(int val, Node node){
        if(node == null) return new Node(new Interval(val, val));
        if(node.interval.start <= val && val <= node.interval.end)  return node;
        if(val == node.interval.start - 1){
            node.interval.start = val;
            if(node.left == null || node.left.interval.end + 1 != node.interval.start)   return node;
            node.interval.start = node.left.interval.start;
            node.left = deleteRoot(node.left);
            return node;
        }
        if(val == node.interval.end + 1){
            node.interval.end = val;
            if(node.right == null || node.right.interval.start != node.interval.end + 1) return node;
            node.interval.end = node.right.interval.end;
            node.right = deleteRoot(node.right);
            return node;
        }
        if(val < node.interval.start - 1) {
            node.left = addNum(val, node.left);
        } else {
            node.right = addNum(val, node.right);
        }
        return node;
    }

    private Node deleteRoot(Node node){
        if(node == null) return null;
        if(node.left == null) return node.right;
        Node it = node.left;
        while(it.right != null){
            it = it.right;
        }
        it.right = node.right;
        return node.left;
    }

    private void InOrder(Node node, List<Interval> list){
        if(node == null) return;
        InOrder(node.left, list);
        list.add(node.interval);
        InOrder(node.right, list);
    }

    public List<Interval> getIntervals() {
        List<Interval> list = new ArrayList<Interval>();
        InOrder(root, list);
        return list;
    }

    private class Node {
        Interval interval;
        Node left;
        Node right;

        public Node(Interval interval) {
            this.interval = interval;
            this.left = null;
            this.right = null;
        }
    }

    private class Interval {
        int start;
        int end;
        Interval() { start = 0; end = 0; }
        Interval(int s, int e) { start = s; end = e; }

        @Override
        public String toString() {
            return "Interval{" +
                    "start=" + start +
                    ", end=" + end +
                    '}';
        }
    }
}