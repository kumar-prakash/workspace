import java.util.*;

public class BFS {
    public static void runBFS(List<List<Integer>> list) {
        Set<Integer> visited = new HashSet<>();
        Queue<Integer> queue = new LinkedList<>();
        queue.add(0);

        while(!queue.isEmpty()) {
            int current = queue.poll();
            visited.add(current);
            List<Integer> adjacencyList = list.get(current);
            for(Integer temp: adjacencyList) {
                if(!visited.contains(temp)) {
                    System.out.print(temp + " ");
                    queue.add(temp);
                }
            }
            System.out.println("");
        }
    }

    public static Map<Vertex, List<Vertex>> createBFSTree(Map<Vertex, List<Vertex>> map, Vertex source) {
        Map<Vertex, List<Vertex>> tree = new HashMap<>();
        Queue<Vertex> queue = new LinkedList<>();
        queue.add(source);
        source.visited = true;

        while(!queue.isEmpty()) {
            Vertex current = queue.poll();
            List<Vertex> list = map.get(current);
            List<Vertex> treeList = new ArrayList<>();
            for(Vertex node: list) {
                if(!node.visited) {
                    node.pred = current;
                    node.distance = current.distance + 1;
                    queue.add(node);
                    treeList.add(node);
                    node.visited = true;
                }
            }
            tree.put(current, treeList);
        }
        return tree;
    }

    public static void printPath(Vertex source, Vertex dest) {
        while(dest != null) {
            System.out.print(dest + " ");
            dest = dest.pred;
        }
        System.out.println("");
    }

    public static void main(String... s) {
        // List<List<Integer>> list = GraphUtil.createAdjacencyList(new String[] {
        //     "1 = 2, 3, 5",
        //     "2 = 5, 4",
        //     "3 = 6, 5",
        //     "4 = 7",
        //     "5 = 7",
        //     "6 = 5, 8",
        //     "7 =",
        //     "8 = 7"
        // });
        // runBFS(list);

        Map<Vertex, List<Vertex>> map = new HashMap<>();
        Vertex one = new Vertex(1);
        Vertex two = new Vertex(2);
        Vertex three = new Vertex(3);
        Vertex four = new Vertex(4);
        Vertex five = new Vertex(5);
        Vertex six = new Vertex(6);
        Vertex seven = new Vertex(7);
        Vertex eight = new Vertex(8);

        map.put(one, Arrays.asList(two, five, three));
        map.put(two, Arrays.asList(five, one, four));
        map.put(three, Arrays.asList(one, five, six));
        map.put(four, Arrays.asList(two, seven));
        map.put(five, Arrays.asList(two, one, three, seven, six));
        map.put(six, Arrays.asList(five, eight, three));
        map.put(seven, Arrays.asList(four, five, eight));
        map.put(eight, Arrays.asList(seven, six));

        Map<Vertex, List<Vertex>> tree = createBFSTree(map, three);
        System.out.println(tree);
        printPath(three, four);
        printPath(three, seven);
        printPath(three, six);
    }
}