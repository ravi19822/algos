package problems;

import java.util.*;

class AutocompleteSystem {


    Map<String,Integer> map;
    TrieNode root;
    TrieNode curr;
    StringBuilder sb;
    public AutocompleteSystem(String[] sentences, int[] times) {
        map = new HashMap<>();
        sb = new StringBuilder();
        root = new TrieNode();
        curr = root;
        //populate map and build trie
        for(int i=0;i<times.length;i++){
            map.put(sentences[i],times[i]);
            root.add(sentences[i],0);
        }

    }

    public List<String> input(char c) {
        if(c=='#'){
            String newSentence = sb.toString();
            map.put(newSentence,map.getOrDefault(newSentence,0)+1);
            root.add(newSentence,0);
            curr=root;
            sb = new StringBuilder();
            return new ArrayList<>();
        }
        sb.append(c);
        curr=curr.getNextNode(c);
        return curr.topWords;

    }

    public static void main(String[] args) {
        String[] sentences = new String[]{"i love you","island","iroman","i love leetcode"};
        int[] times = new int[]{5,3,2,2};

        AutocompleteSystem obj = new AutocompleteSystem(sentences, times);
    }


    class TrieNode{
        List<String> topWords;
        TrieNode[] next;

        TrieNode(){
            topWords = new ArrayList<>();
            next=  new TrieNode[27];
        }

        public void add(String s,int start){
            if(!topWords.contains(s))
                topWords.add(s);
            Collections.sort(topWords,(o1, o2)->map.get(o1)==map.get(o2)?o1.compareTo(o2):map.get(o2)-map.get(o1));
            if(topWords.size()>3)
                topWords.remove(topWords.size()-1);
            if(start == s.length())
                return;
            getNextNode(s.charAt(start)).add(s,start+1);
        }

        public TrieNode getNextNode(char ch){
            int index = ch==' '?26: ch-'a';
            if(next[index]==null)
                next[index] = new TrieNode();
            return next[index];
        }
    }
}

