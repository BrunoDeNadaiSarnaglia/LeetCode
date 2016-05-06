/**
 * Created by Bruno on 5/6/2016.
 */
public class TrieNode {

    public TrieNode() {
        this.children = new TrieNode[26];
        this.endOfString  = false;
    }

    public TrieNode[] children;
    public boolean endOfString;
}
