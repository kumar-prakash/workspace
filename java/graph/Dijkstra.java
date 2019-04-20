import java.util.*;

public class Dijkstra {
    public static void findShortestPath(Map<Integer, List<Entry>> map, Entry source) {
      Queue<Entry> queue = new PriorityQueue<Entry>((Entry e1, Entry e2) -> Integer.compare(e1.getWeight(), e2.getWeight()));
      int [] distanceArr = new int[map.size()];
      int [] pred = new int[map.size()];

      for(int i = 0; i < distanceArr.length; i++) {
        distanceArr[i] = 100000;
      }
      queue.add(source);
      distanceArr[source.getNode()] = 0;

      while(!queue.isEmpty()) {
        Entry current = queue.poll();
        List<Entry> adj = map.get(current.getNode());
        for(Entry entry: adj) {
          int distance = distanceArr[entry.getNode()];
          if(distanceArr[current.getNode()] + entry.getWeight() < distance) {
            // update distance
            distanceArr[entry.getNode()] = distanceArr[current.getNode()] + entry.getWeight();
            // update priority
            entry.setWeight(distanceArr[entry.getNode()]);
            pred[entry.getNode()] = current.getNode();
          }
          if(!queue.contains(entry)) {
            queue.add(entry);
            //pred[entry.getNode()] = current.getNode();
          }
        }
      }

      System.out.println(Arrays.toString(distanceArr));
      System.out.println(Arrays.toString(pred));
    }

    public static void main(String... s) {
        String []arr = {
            "0 = 1,6 - 3,18 - 2,8",
            "1 = 4,11",
            "2 = 3,9",
            "3 =",
            "4 = 5,3",
            "5 = 3,4 - 2,7"
        };

        Map<Integer, List<Entry>> map = GraphUtil.createAdjacencyMap(arr);
        //System.out.println(map);
        findShortestPath(map, new Entry(0, 0));
    }
}
