package trie;

import trie.Trie;

public class TrieTest {

  static Trie initTrie() {
    Trie t = new Trie();
    t.addWord("apple");
    t.addWord("angel");
    t.addWord("acid");
    t.addWord("allergy");
    t.addWord("ball");
    t.addWord("ballon");
    t.addWord("batman");
    return t;
  }

  static void containsTest(Trie trie) {
    System.out.println(trie.containsWord("ball"));
    System.out.println(trie.containsWord("ballss"));
    System.out.println(trie.containsWord("bal"));
  }

  static void prefixTest(Trie trie) {
    //System.out.println(trie.getMatches("bat"));
    //System.out.println(trie.getMatches("apple"));
    System.out.println(trie.getMatches("a"));
    System.out.println(trie.getMatches("b"));
  }

  public static void main(String... s) {
      Trie trie = initTrie();
      prefixTest(trie);
  }
}
