package gt;

import java.util.*;

public class BuildOrder {

  public Map<Character, Set<Character>> createAdjacencyMap(char [] nodes, char [][] edges) {
    Map<Character, Set<Character>> map = new HashMap<>();
    for(char c: nodes) {
      map.put(c, new HashSet<>());
    }

    for(char [] edge: edges) {
      map.get(edge[1]).add(edge[0]);
    }

    return map;
  }

  public void removeNode(Map<Character, Set<Character>> map, char node) {
    for(Map.Entry<Character, Set<Character>> entry: map.entrySet()) {
      entry.getValue().remove(node);
    }
  }

  public List<Character> findBuildOrder(char [] nodes, char [][] edges) {
    List<Character> order = new ArrayList();
    Map<Character, Set<Character>> map = createAdjacencyMap(nodes, edges);
    while(order.size() < nodes.length) {
      boolean isFound = false;
      Character found = null;
      for(Map.Entry<Character, Set<Character>> entry: map.entrySet()) {
        if(entry.getValue().isEmpty()) {
          isFound = true;
          order.add(entry.getKey());
          removeNode(map, entry.getKey());
          found = entry.getKey();
          break;
        }
      }

      if(!isFound) {
        return null;
      } else {
        map.remove(found);
      }
    }

    return order;
  }

  public static void main(String... s) {
    char [] nodes = new char [] {'a', 'b', 'c', 'd', 'e', 'f'};
    char [][] edges = new char [][] {
      {'a', 'd'}, {'f', 'b'}, {'b', 'd'}, {'f', 'a'}, {'d', 'c'}, {'b', 'f'}
    };

    BuildOrder order = new BuildOrder();
    System.out.println(order.findBuildOrder(nodes, edges));
  }
}
