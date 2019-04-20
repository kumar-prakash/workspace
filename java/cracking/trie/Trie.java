package trie;

import java.util.*;

public class Trie {
  private TrieNode root = new TrieNode((char)0);

  public void addWord(String word) {
    if(word == null || word.isEmpty()) {
      return;
    }

    TrieNode current = root;
    for(int i = 0; i < word.length(); i++) {
      char c = word.charAt(i);
      current = current.addNode(c);
    }
    current.setIsWord(true);
  }

  public boolean containsWord(String word) {
    TrieNode current = root;
    for(char c : word.toCharArray()) {
      int code = ((int)c) - 97;
      if(current.nodes[code] == null) {
        return false;
      } else {
        current = current.nodes[code];
      }
    }

    return current.isWord();
  }

  public List<String> getMatches(String prefix) {
    List<String> result = new ArrayList<>();

    TrieNode current = root;
    for(char c : prefix.toCharArray()) {
      int code = ((int)c) - 97;
      if(current.nodes[code] == null) {
        return result;
      } else {
        current = current.nodes[code];
      }
    }
    findPath(current, prefix.substring(0, prefix.length() - 1), result);
    return result;
  }

  private void findPath(TrieNode node, String prefix, List<String> list) {
    prefix = prefix + node.getValue();
    if(node.isWord()) {
      list.add(prefix);
    }
    for(TrieNode temp: node.nodes) {
      if(temp != null) {
        findPath(temp, prefix, list);
      }
    }
  }

  private class TrieNode {
    private char value;
    private boolean word = false;
    private TrieNode[] nodes = new TrieNode[26];

    public TrieNode(char value) {
      this.value = value;
    }

    public char getValue() {
      return this.value;
    }

    public void setValue(char value) {
      this.value = value;
    }

    public boolean isWord() {
      return word;
    }

    public void setIsWord(boolean word) {
      this.word = word;
    }

    public TrieNode [] getNodes() {
      return this.nodes;
    }

    public boolean exist(char value) {
      return nodes[((int)value) - 97] != null;
    }

    public TrieNode addNode(char value) {
      int index = ((int)value) - 97;
      if(!exist(value)) {
        TrieNode node = new TrieNode(value);
        nodes[index] = node;
        return node;
      } else {
        return nodes[index];
      }
    }

    public String toString() {
      return String.valueOf(value) + " : " + word;
    }
  }
}
