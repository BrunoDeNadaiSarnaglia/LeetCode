import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by Bruno on 10/5/2016.
 */
public class BinayTreeSerialization {


    public class TreeNode {
        public int val;
        public TreeNode left, right;
        public TreeNode(int val) {
            this.val = val;
            this.left = this.right = null;
        }
    }



    public String serialize(TreeNode root) {
        if(root == null)    return "#";
        return root.val + "," +  serialize(root.left) + "," + serialize(root.right);
    }

    /**
     * This method will be invoked second, the argument data is what exactly
     * you serialized at method "serialize", that means the data is not given by
     * system, it's given by your own serialize method. So the format of data is
     * designed by yourself, and deserialize it here as you serialize it in
     * "serialize" method.
     */
    public TreeNode deserialize(String data) {
        String[] nodes = data.split(",");
        List<String> l = new ArrayList<String>();
        for (String node: nodes) {
            l.add(node);
        }
        Iterator<String> it = l.iterator();
        return deserialize(it);
    }


    private TreeNode deserialize(Iterator<String> it){
        if(!it.hasNext())   return null;
        String val = it.next();
        if(val.equals("#"))  return null;
        TreeNode node = new TreeNode(Integer.parseInt(val));
        node.left = deserialize(it);
        node.right = deserialize(it);
        return node;
    }
}
