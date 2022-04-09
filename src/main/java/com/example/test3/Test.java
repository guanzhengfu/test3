package com.example.test3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class Test {

  class Trie {

    TrieNode root;

    public Trie(String[] words) {
      root = new TrieNode();
      for (String word : words) {
        TrieNode node = root;
        for (char w : word.toCharArray()) {
          int i = w - 'a';
          if (node.next[i] == null) {
            node.next[i] = new TrieNode();
          }
          node = node.next[i];
        }
        node.end = word;
      }
    }

    public List<String> search(String str) {
      TrieNode node = root;
      List<String> res = new ArrayList<>();
      for (char c : str.toCharArray()) {
        int i = c - 'a';
        if (node.next[i] == null) {
          break;
        }
        node = node.next[i];
        if (node.end != null) {
          res.add(node.end);
        }
      }
      return res;
    }
  }

  class TrieNode {

    String end;
    TrieNode[] next = new TrieNode[26];
  }

  public void multiSearch(String big, String[] smalls) {
    Trie trie = new Trie(smalls);
    Map<String, List<Integer>> hit = new HashMap<>();
    for (int i = 0; i < big.length(); i++) {
      List<String> matchs = trie.search(big.substring(i));
      for (String word : matchs) {
        if (!hit.containsKey(word)) {
          hit.put(word, new ArrayList<>());
        }
        hit.get(word).add(i);
      }
    }
    Set<Entry<String, List<Integer>>> entries = hit.entrySet();
    for (Entry<String, List<Integer>> e : entries) {
      System.out.println(e.getKey() + " " + e.getValue());
    }
  }

  public static void main(String[] args) {
    Test test = new Test();
    test.multiSearch("mississippi", new String[]{"is", "ppi", "hi", "sis", "i", "ssippi"});
  }
}
