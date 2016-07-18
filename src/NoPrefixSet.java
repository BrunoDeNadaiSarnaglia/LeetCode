import java.util.Scanner;

/**
 * Created by Bruno on 7/17/2016.
 */
public class NoPrefixSet {


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        NoPrefixSet aux = new NoPrefixSet();
        while(scanner.hasNext()){
            try {
                aux.insert(scanner.nextLine());
            } catch (Exception e){
                System.out.println("BAD SET");
            }
        }
        System.out.println("GOOD SET");
    }

    private class TrieNode{

        public TrieNode() {
            this.children = new TrieNode[26];
            this.endOfString  = false;
        }

        public TrieNode[] children;
        public boolean endOfString;
    }

    public TrieNode root = null;

    public void insert(String word) throws Exception {
        root = insert(word, 0, root);
    }

    private TrieNode insert(String word, int i, TrieNode node) throws Exception {
        if(i == word.length() && node != null) throw new Exception("Prefix String");
        if(node == null){
            node = new TrieNode();
        }
        if(node.endOfString)    throw new Exception("Prefix String");
        if(i == word.length()){
            node.endOfString = true;
            return node;
        }
        char ch = word.charAt(i);
        node.children[ch - 'a'] = insert(word, i + 1, node.children[ch - 'a']);
        return node;
    }

    public boolean search(String word) {
        TrieNode node = searchNode(word);
        return node != null && node.endOfString;
    }

    public boolean startsWith(String prefix) {
        return searchNode(prefix) != null;
    }


    private TrieNode searchNode(String word){
        return searchNode(word, 0, root);
    }

    private TrieNode searchNode(String word, int i, TrieNode node){
        if(node == null)        return null;
        if(i == word.length())  return node;
        char ch = word.charAt(i);
        return searchNode(word, i + 1, node.children[ch - 'a']);
    }

}
