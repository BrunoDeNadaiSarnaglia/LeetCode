import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class PalindromePairs {



    public static void main(String[] args){
        PalindromePairs pp = new PalindromePairs();
        System.out.println(pp.palindromePairs(new String[]{"", "a"}));
    }

    public List<List<Integer>> palindromePairs(String[] words) {
        List<List<Integer>> lists = new ArrayList<List<Integer>>();
        List<List<Integer>> lists1 = palindromePairs1(words);
        String[] reversedWords = new String[words.length];
        for (int i = 0; i < words.length; i++) {
            reversedWords[i] = new StringBuilder(words[i]).reverse().toString();
        }
        List<List<Integer>> lists2 = palindromePairs1(reversedWords);
        for (List<Integer> pair : lists2){
            int aux = pair.get(0);
            pair.set(0, pair.get(1));
            pair.set(1, aux);
        }
        List<List<Integer>> lists3 = checkReversed(words);
        lists.addAll(lists1);
        lists.addAll(lists2);
        lists.addAll(lists3);
        return lists;
    }

    public List<List<Integer>> checkReversed(String[] words) {
        List<List<Integer>> lists = new ArrayList<List<Integer>>();
        HashMap<String, Integer> map = new HashMap<String, Integer>();
        for (int i = 0; i < words.length; i++) {
            map.put(words[i], i);
        }
        for (String word : words) {
            String reversedWord = new StringBuilder(word).reverse().toString();
            if(word.equals(reversedWord))   continue;
            if(!map.containsKey(reversedWord)) continue;
            List<Integer> pair = new ArrayList<Integer>();
            pair.add(map.get(word));
            pair.add(map.get(reversedWord));
            lists.add(pair);
        }
        return lists;
    }

    public List<List<Integer>> palindromePairs1(String[] words) {
        List<List<Integer>> lists = new ArrayList<List<Integer>>();
        HashMap<String, Integer> map = new HashMap<String, Integer>();
        for (int i = 0; i < words.length; i++) {
            map.put(words[i], i);
        }
        for (String word : words){
            boolean[] pal = PalindromeChecker.HasPalindromeToEndOfWord(word);
            for (int i = 0; i < pal.length; i++) {
                if(!pal[i]) continue;
                String reversedSecondHalf = new StringBuilder(word.substring(0, i)).reverse().toString();
                if(map.containsKey(reversedSecondHalf)){
                    List<Integer> pair = new ArrayList<Integer>();
                    pair.add(map.get(word));
                    pair.add(map.get(reversedSecondHalf));
                    lists.add(pair);
                }
            }
        }
        return lists;
    }


    private static class PalindromeChecker {

        public static boolean[] HasPalindromeToEndOfWord(String word){
            char[] splittedArray = charArraySplited(word);
            int[] palindromLen = palindromeLen(splittedArray);
            boolean[] palGoesToEndOfWord = new boolean[word.length()];
            for (int i = 0; i < palindromLen.length - 1; i++) {
                if(i + palindromLen[i] == palindromLen.length - 1){
                    palGoesToEndOfWord[(i - palindromLen[i]) / 2] = true;
                }
            }
            return palGoesToEndOfWord;
        }


        private static char[] charArraySplited(String s){
            char[] array = new char[2 * s.length() + 1];
            array[0] = '#';
            for(int i = 0, j = 1; i < s.length(); i++){
                array[j++] = s.charAt(i);
                array[j++] = '#';
            }
            return array;
        }

        private static int[] palindromeLen(char[] splittedString){
            int[] halfSizePalindrome = new int[splittedString.length];
            int centerHalf = 0;
            for(int i = 1; i < splittedString.length; i++){
                if(i <=  centerHalf + halfSizePalindrome[centerHalf]){
                    halfSizePalindrome[i] = Math.min(halfSizePalindrome[centerHalf - (i - centerHalf)], centerHalf + halfSizePalindrome[centerHalf] - i);
                }
                if(i + halfSizePalindrome[i] >= centerHalf + halfSizePalindrome[centerHalf]){
                    centerHalf = i;
                    int j = centerHalf + halfSizePalindrome[centerHalf];
                    int k = centerHalf - halfSizePalindrome[centerHalf];
                    for(;j + 1 < splittedString.length && k - 1 >=0 && splittedString[j + 1] == splittedString[k - 1]; j++, k--);
                    halfSizePalindrome[centerHalf] = j - centerHalf;
                }
            }
            return halfSizePalindrome;
        }
    }

}
//import javax.net.ssl.SSLContext;
//import java.util.*;
//
///**
// * Created by Bruno on 5/6/2016.
// */
//public class PalindromePairs {
//
//    Trie trie = new Trie();
//
//    HashSet<Pair<Integer, Integer>> set = new HashSet<Pair<Integer, Integer>>();
//    HashMap<String, Integer> map = new HashMap<String, Integer>();
//
//    public static void main(String[] args){
//        PalindromePairs pp = new PalindromePairs();
//////        pp.palindromePairs(new String[]{"bc", "a", "abc"});
////        PalindromeChecker pc = new PalindromeChecker();
////        Utils.printArray(pc.HasPalindromeToEndOfWord("adda"));
//        System.out.println(pp.palindromePairs(new String[]{"abcd", "dcba", "lls", "s", "sssll"}));
//    }
//
//    public List<List<Integer>> palindromePairs(String[] words) {
//        for (int i = 0; i < words.length; i++) {
//            map.put(words[i], i);
//        }
//        List<String> wordsSorted = SortByLength(words);
//        for(String word : wordsSorted){
//            findPalindromes(new StringBuilder(word).reverse().toString());
//            trie.insert(word);
//        }
//        List<List<Integer>> listPairs = new ArrayList<List<Integer>>();
//        HashSet<List<Integer>> noDuplicated = new HashSet<List<Integer>>();
//        for(Pair<Integer, Integer> tuple : this.set){
//            List<Integer> aoasdm = new ArrayList<Integer>();
//            aoasdm.add(tuple.getFirst());
//            aoasdm.add(tuple.getSecond());
//            listPairs.add(aoasdm);
//            noDuplicated.add(aoasdm);
//        }
//        set = new HashSet<Pair<Integer, Integer>>();
//        trie = new Trie();
//        for(String word : wordsSorted){
//            findPalindromes(word);
//            trie.insert(new StringBuilder(word).reverse().toString());
//        }
//
//        for(Pair<Integer, Integer> tuple : this.set){
//            List<Integer> aoasdm = new ArrayList<Integer>();
//            aoasdm.add(tuple.getSecond());
//            aoasdm.add(tuple.getFirst());
//            if(!noDuplicated.contains(aoasdm)){
//                listPairs.add(aoasdm);
//            }
//        }
//        return listPairs;
//    }
//
//    private void findPalindromes(String word){
//        PalindromeChecker pc = new PalindromeChecker();
//        findPalindromes(word, 0, pc.HasPalindromeToEndOfWord(word), trie.root, new StringBuilder());
//    }
//
//    private void findPalindromes(String word, int i, boolean[] palMap, TrieNode node, StringBuilder str){
//        if(node == null)    return;
//        if(node.endOfString && i == word.length()){
//            String halfPal = word.substring(0, i);
//            String reversedHalfPal = new StringBuilder(halfPal).reverse().toString();
//            set.add(new Pair<Integer, Integer>(map.get(halfPal), map.get(reversedHalfPal)));
//            set.add(new Pair<Integer, Integer>(map.get(reversedHalfPal), map.get(halfPal)));
//        }
//        if(i == word.length())    return;
//        else if(node.endOfString && palMap[i]){
//            set.add(new Pair<Integer, Integer>(map.get(str.toString()), map.get(new StringBuilder(word).reverse().toString())));
//        }
//        char ch = word.charAt(i);
//        str.append(ch);
//        findPalindromes(word, i + 1, palMap, node.children[ch - 'a'], str);
//    }
//
//    private List<String> SortByLength(String[] words){
//        List<String> list = Arrays.asList(words);
//        Collections.sort(list, new Comparator<String>() {
//            @Override
//            public int compare(String o1, String o2) {
//                return o1.length() - o2.length();
//            }
//        });
//        return list;
//    }
//
//    private static class PalindromeChecker {
//
//        public boolean[] HasPalindromeToEndOfWord(String word){
//            char[] splittedArray = charArraySplited(word);
//            int[] palindromLen = palindromeLen(splittedArray);
//            boolean[] palGoesToEndOfWord = new boolean[word.length()];
//            for (int i = 0; i < palindromLen.length - 1; i++) {
//                if(i + palindromLen[i] == palindromLen.length - 1){
//                    palGoesToEndOfWord[(i - palindromLen[i]) / 2] = true;
//                }
//            }
//            return palGoesToEndOfWord;
//        }
//
//
//        private char[] charArraySplited(String s){
//            char[] array = new char[2 * s.length() + 1];
//            array[0] = '#';
//            for(int i = 0, j = 1; i < s.length(); i++){
//                array[j++] = s.charAt(i);
//                array[j++] = '#';
//            }
//            return array;
//        }
//
//        private int[] palindromeLen(char[] splittedString){
//            int[] halfSizePalindrome = new int[splittedString.length];
//            int centerHalf = 0;
//            for(int i = 1; i < splittedString.length; i++){
//                if(i <=  centerHalf + halfSizePalindrome[centerHalf]){
//                    halfSizePalindrome[i] = Math.min(halfSizePalindrome[centerHalf - (i - centerHalf)], centerHalf + halfSizePalindrome[centerHalf] - i);
//                }
//                if(i + halfSizePalindrome[i] >= centerHalf + halfSizePalindrome[centerHalf]){
//                    centerHalf = i;
//                    int j = centerHalf + halfSizePalindrome[centerHalf];
//                    int k = centerHalf - halfSizePalindrome[centerHalf];
//                    for(;j + 1 < splittedString.length && k - 1 >=0 && splittedString[j + 1] == splittedString[k - 1]; j++, k--);
//                    halfSizePalindrome[centerHalf] = j - centerHalf;
//                }
//            }
//            return halfSizePalindrome;
//        }
//    }
//
//
//    public class Pair<K, T>{
//        private K k;
//        private T t;
//        public Pair(K k, T t){
//            this.k = k;
//            this.t = t;
//        }
//
//        public K getFirst(){
//            return this.k;
//        }
//
//
//        public T getSecond(){
//            return this.t;
//        }
//    }
//
//}
