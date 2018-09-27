import java.util.*;

public class MotherVertex {

    /**
     * This method finds the mother vertex, there can be more than one mother vertex, 
     * this will return any one of them;
     * Approach: It runs BFS for every vertex and checks whether all other vertex are reachable or not.
     * 
     * @param list adjacency list
     * @return  mother vertex if exist or return -1
     */
    public static int findMotherVertex(LinkedList<Integer> [] list) {
        int mother = -1;
        if(list == null || list.length == 0) {
            return mother;
        }
        if(list.length == 1) {
            return 1;
        }
        for(int i = 1; i < list.length; i++) {
            boolean [] visited = new boolean[list.length];
            Queue<Integer> queue = new LinkedList<Integer>();
            queue.add(i);
            visited[i] = true;
            int visitedCount = 1;
            while(!queue.isEmpty()) {
                int current = queue.poll();
                if(list[current] != null) {
                    for(int vertex: list[current]) {
                        if(!visited[vertex]) {
                            visited[vertex] = true;
                            queue.add(vertex);
                            visitedCount++;
                        }
                    }
                }
            }
            if(visitedCount == list.length - 1) {
                mother = i;
                break;
            }
        }
        return mother;
    }

    private static void runTest(String [] data) {
        int motherVertex = findMotherVertex(GraphUtil.createAdjacencyList(data));
        if(motherVertex != -1) {
            System.out.println("The mother vertex is: " + motherVertex);
        } else {
            System.out.println("Mother vertex does not exist");
        }
    }

    private static void test1() {
        String [] data = {
            "1=2,6",
            "2=3",
            "3=4,1,5",
            "4=",
            "5=",
            "6="
        };

        runTest(data);
    }

    private static void test2() {
        String [] data = {
            "1=2,6",
            "2=",
            "3=2,1,4,5",
            "4=",
            "5=",
            "6="
        };

        runTest(data);
    }

    private static void test3() {
        String [] data = {
            "1=2",
            "2=",
            "3=1",
            "4=2"
        };

        runTest(data);
    }
    public static void main(String... s) {
        test1();    
        test2();
        test3();
    }
}