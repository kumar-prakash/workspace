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

    /**
     * This method finds the mother vertex, there can be more than one mother vertex, 
     * this will return any one of them;
     * Approach: It runs DFS for every vertex and checks whether all other vertex are reachable or not.
     * Note: This DFS is stack based instead of recursion.
     * 
     * @param list adjacency list
     * @return  mother vertex if exist or return -1
     */
    public static int findMotherVertexDFS(LinkedList<Integer> [] list) {
        int mother = -1;
        if(list == null || list.length == 0) {
            throw new IllegalArgumentException("Adjacency list cann't be null or empty.");
        }
        if(list.length == 1) {
            return 1;
        }

        for(int i = 1; i < list.length; i++) {
            boolean [] visited = new boolean[list.length];
            Stack<Integer> stack = new Stack();
            Stack<Iterator<Integer>> itrStack = new Stack();
            stack.push(i);
            itrStack.push(list[i].iterator());
            visited[i] = true;
            boolean isFirstStatement = true;
            int visitedCount = 1;
            start: 
                while(!stack.isEmpty()) {
                    if(isFirstStatement) {
                        visitedCount++;    
                    }
                    while(itrStack.peek().hasNext()) {
                        int vertex = itrStack.peek().next();
                        if(!visited[vertex]) {
                            visited[vertex] = true;
                            stack.push(vertex);
                            itrStack.push(list[vertex].iterator());
                            isFirstStatement = true;
                            
                            continue start;
                        }
                    }
                    while(!itrStack.isEmpty() && !itrStack.peek().hasNext()) {
                        stack.pop();
                        itrStack.pop();
                        isFirstStatement = false;
                    }   
                }
            if(visitedCount == list.length) {
                mother = i;
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

    private static void runTestDFS(String [] data) {
        int motherVertex = findMotherVertexDFS(GraphUtil.createAdjacencyList(data));
        if(motherVertex != -1) {
            System.out.println("The mother vertex is: " + motherVertex);
        } else {
            System.out.println("Mother vertex does not exist");
        }
    }

    private static void test1() {
        runTest(data1);
    }

    private static void test2() {
        runTest(data2);
    }

    private static void test3() {
        runTest(data3);
    }

    private static void testBFS() {
        test1();    
        test2();
        test3();
    }


    private static void test1DFS() {
        runTestDFS(data1);
    }

    private static void test2DFS() {
        runTestDFS(data2);
    }

    private static void test3DFS() {
        runTestDFS(data3);
    }


    private static void testDFS() {
        test1DFS();
        test2DFS();
        test3DFS();
    }
    public static void main(String... s) {
        testBFS();
        testDFS();
    }


    private static String [] data1 = {
        "1=2,6",
        "2=3",
        "3=4,1,5",
        "4=",
        "5=",
        "6="
    };

    private static String [] data2 = {
        "1=2,6",
        "2=",
        "3=2,1,4,5",
        "4=",
        "5=",
        "6="
    };

    private static String [] data3 = {
        "1=2",
        "2=",
        "3=1",
        "4=2"
    };
}