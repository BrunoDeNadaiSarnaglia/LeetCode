/**
 * Created by Bruno on 5/6/2016.
 */
public class Trie {

    public TrieNode root = null;

    public Trie() {   }

    public void insert(String word) {
        root = insert(word, 0, root);
    }

    private TrieNode insert(String word, int i, TrieNode node) {
        if(node == null){
            node = new TrieNode();
        }
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
