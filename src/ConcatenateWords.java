import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * Created by Bruno on 12/26/2016.
 */
public class ConcatenateWords {


    private class TrieNode {

        public TrieNode() {
            this.children = new TrieNode[26];
            this.endOfString  = false;
        }

        public TrieNode[] children;
        public boolean endOfString;
    }

    private class Trie {

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

        public  List<Integer> seachSubstring(String word, int index){
            return seachSubstring(word, index, root);
        }

        private List<Integer> seachSubstring(String word, int index, TrieNode node){
            List<Integer> l = new ArrayList<Integer>();
            seachSubstring(word, index, node, l);
            return l;
        }

        private void seachSubstring(String word, int index, TrieNode node, List<Integer> acc){
            if(node == null)    return;
            if(index < word.length()){
                char ch = word.charAt(index);
                seachSubstring(word, index + 1, node.children[ch - 'a'], acc);
            }
            if(node.endOfString)    acc.add(index);
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

    private boolean isConcat(String word, Trie t){
        int[] dp = new int[word.length() + 1];
        dp[0] = 1;
        for (int i = 0; i < dp.length; i++) {
            if(dp[i] == 0)  continue;
            List<Integer> l = t.seachSubstring(word, i);
            for (Integer idx : l) {
                dp[idx]++;
            }
            if(dp[dp.length - 1] > 0)   return true;
        }
        return false;
    }



    public List<String> findAllConcatenatedWordsInADict(String[] words) {
        Arrays.sort(words, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.length() - o2.length();
            }
        });
        Trie t = new Trie();
        List<String> l = new ArrayList<String>();
        for (int i = 0; i < words.length; i++) {
            if(words[i].length() == 0)  continue;
            if(isConcat(words[i], t))   l.add(words[i]);
            t.insert(words[i]);
        }
        return l;
    }


}
