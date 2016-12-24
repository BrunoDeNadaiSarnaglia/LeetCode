/**
 * Created by Bruno on 12/24/2016.
 */



public class SerializeAndDeserializeBst {


    TreeNode t;

    public SerializeAndDeserializeBst() {
        this.t = new TreeNode(2);
        this.t.left = new TreeNode(1);
        this.t.right = new TreeNode(3);
    }

    public static void main(String[] args){
        SerializeAndDeserializeBst s = new SerializeAndDeserializeBst();
        System.out.print(s.serialize(s.t));
        s.deserialize(s.serialize(s.t));
    }


    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    private class Stream {

        private String str;
        private int i = 0;

        public Stream(String str) {
            this.str = str;
        }

        public boolean hasNext(){
            return i < str.length();
        }

        public char peek(){
            return this.str.charAt(this.i);
        }

        public char next(){
            return this.str.charAt(this.i++);
        }
    }


    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if(root == null)    return "(n)";
        return "(" + root.val + serialize(root.left) + serialize(root.right) + ")";
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data == "n") return null;
        Stream s = new Stream(data);
        s.next();
        return deserialize(s);
    }

    private TreeNode deserialize(Stream stream) {
        char ch = stream.next();
        boolean isNull = false;
        int num = 0;
        while (ch != '(' && ch != ')'){
            if(ch == 'n'){
                isNull = true;
            } else {
                num = 10*num + (ch - '0');
            }
            ch = stream.next();
        }
        if(isNull)  {
            return null;
        }
        TreeNode root = new TreeNode(num);
        root.left = deserialize(stream);
        stream.next();
        root.right = deserialize(stream);
        stream.next();
        return root;
    }

}
