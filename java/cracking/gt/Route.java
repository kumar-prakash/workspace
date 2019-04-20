package gt;

import java.util.*;

public class Route {
  public boolean routeExist(Map<Integer, List<Integer>> adjacencyList, int source, int destination) {
    Set<Integer> visited = new HashSet<>();
    Queue<Integer> queue = new LinkedList<>();
    queue.add(source);
    visited.add(source);

    while(!queue.isEmpty()) {
        int current = queue.poll();
        List<Integer> list = adjacencyList.get(current);
        if(list != null && !list.isEmpty()) {
          for(int node : list) {
            if(node == destination) {
              return true;
            }
            if(!visited.contains(node)) {
              queue.add(node);
              visited.add(node);
            }
          }
        }
    }

    return false;
  }

  public static void main(String... s) {
    Map<Integer, List<Integer>> adjList = new HashMap<>();
    adjList.put(1, Arrays.asList(2, 4));
    adjList.put(2, Arrays.asList(3, 4));
    adjList.put(3, Arrays.asList(4, 5));
    //adjList.put(4, Arrays.asList(6));
    //adjList.put(5, Arrays.asList(6));
    adjList.put(6, Arrays.asList(3));

    Route route = new Route();
    System.out.println(route.routeExist(adjList, 1, 6));
  }
}
