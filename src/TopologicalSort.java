import java.util.ArrayList;
import java.util.HashSet;
import java.util.Stack;

/**
 * Created by Bruno on 7/18/2016.
 */
public class TopologicalSort {

    class DirectedGraphNode {
        int label;
        ArrayList<DirectedGraphNode> neighbors;
        DirectedGraphNode(int x) { label = x; neighbors = new ArrayList<DirectedGraphNode>(); }
    }

    public ArrayList<DirectedGraphNode> topSort(ArrayList<DirectedGraphNode> graph) {
        Stack<DirectedGraphNode> stk = new Stack<DirectedGraphNode>();
        HashSet<DirectedGraphNode> set = new HashSet<DirectedGraphNode>();
        for (DirectedGraphNode node: graph) {
            dfs(node, stk, set);
        }
        ArrayList<DirectedGraphNode> listNodes = new ArrayList<DirectedGraphNode>();
        while (!stk.isEmpty()){
            listNodes.add(stk.pop());
        }
        return listNodes;
    }

    private void dfs(DirectedGraphNode node, Stack<DirectedGraphNode> stk, HashSet<DirectedGraphNode> set){
        if(set.contains(node))  return;
        for (DirectedGraphNode neighbourNode: node.neighbors) {
            dfs(neighbourNode, stk, set);
        }
        stk.push(node);
        set.add(node);
    }
}
