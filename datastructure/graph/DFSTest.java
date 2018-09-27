import java.util.*;

public class DFSTest {

    /**
     * This method runs DFS recursively.
     * 
     * @param list adjacency list
     * @param startVertex  start point
     * @param visited  visited array
     */
    public static void executeWithRecursion(LinkedList<Integer> [] list, int startVertex, boolean [] visited) {
        visited[startVertex] = true;
        System.out.println(startVertex);
        for(int vertex: list[startVertex]) {
            if(!visited[vertex]) {
                executeWithRecursion(list, vertex, visited);
            }
        }
    }

    /**
     * This method runs DFS using a stack, this is not the best DFS
     * 
     * @param list adjacency list
     * @param startVertex   start point
     */
    public static void executeWithStack(LinkedList<Integer> [] list, int startVertex)  {
        boolean [] visited = new boolean[list.length];
        Stack<Integer> stack = new Stack();
        stack.push(startVertex);
        while(!stack.isEmpty()) {
            int current = stack.pop();
            System.out.println(current);
            visited[current] = true;
            for(int vertex: list[current]) {
                if(!visited[vertex]) {
                    stack.push(vertex);
                    visited[vertex] = true;
                }
            }
        }
    }

    /**
     * Runs DFS using a stack.
     * 
     * @param list adjacency list
     * @param startVertex   start point
     */
    public static void executeWithStackV1(LinkedList<Integer> [] list, int startVertex) {
        Stack<Integer> stack = new Stack();
        Stack<Iterator<Integer>> itrStack = new Stack();
        boolean [] visited = new boolean[list.length];
        stack.push(startVertex);
        itrStack.push(list[startVertex].iterator());
        visited[startVertex] = true;

        boolean isStartBlock = true;
        start:
            while(!stack.isEmpty()) {
                if(isStartBlock) {
                    System.out.println(stack.peek());
                }
                while(itrStack.peek().hasNext()) {
                    int vertex = itrStack.peek().next();
                    if(!visited[vertex]) {
                        stack.push(vertex);
                        itrStack.push(list[vertex].iterator());
                        visited[vertex] = true;
                        isStartBlock = true;
                        
                        continue start;
                    }
                }
                while(!itrStack.isEmpty() && !itrStack.peek().hasNext()) {
                    stack.pop();
                    itrStack.pop();
                    isStartBlock = false;
                }
            }

    }

    public static void test1() {
        String [] data = {
            "1=2,3,4,5", 
            "2=1,3",
            "3=8,2,1",
            "8=3,6",
            "6=5,8",
            "5=1,6,4",
            "4=1,7, 5",
            "7=4"
        };
        //executeWithRecursion(GraphUtil.createAdjacencyList(data), 1, new boolean[data.length + 1]);
        executeWithStack(GraphUtil.createAdjacencyList(data), 1);
    }

    public static void test2() {
        String [] data = {
            "1=2,3",
            "2=1",
            "3=1,4",
            "4=3"
        };
        executeWithStack(GraphUtil.createAdjacencyList(data), 1);
    }

    public static void test3() {
        String [] data = {
            "1=2,3,4,5", 
            "2=1,3",
            "3=8,2,1",
            "8=3,6",
            "6=5,8",
            "5=1,6",
            "4=1,7",
            "7=4"
        };
        executeWithRecursion(GraphUtil.createAdjacencyList(data), 1, new boolean[data.length + 1]);
        System.out.println("----------------------");
        executeWithStack(GraphUtil.createAdjacencyList(data), 1);
    }

    public static void test4() {
        String [] data = {
            "1=2,3,4,5", 
            "2=1,3",
            "3=8,2,1",
            "8=3,6",
            "6=5,8",
            "5=1,6",
            "4=1,7",
            "7=4"
        };
        executeWithStackV1(GraphUtil.createAdjacencyList(data), 1);
    }


    public static void main(String... s) {
        test4();
    }
}