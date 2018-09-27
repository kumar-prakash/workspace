import java.util.*;

public class BFSTest {
    public static void execute(LinkedList<Integer>[] list, int startVertex) {
        if(list == null || list.length == 0) {
            return;
        }
        if(startVertex < 0 || startVertex >= list.length) {
            throw new IllegalArgumentException("Invalid vertex");
        }

        Queue<Integer> queue = new LinkedList<Integer>();
        queue.add(startVertex);
        boolean [] visited = new boolean[list.length];
        visited[startVertex] = true;

        int count = 0;
        while(!queue.isEmpty()) {
            int size = queue.size();
            for(int i = 0; i < size; i++) {
                int vertex = queue.poll();
                for(int element: list[vertex]) {
                    if(!visited[element]) {
                        queue.add(element);
                        visited[element] = true;
                    }
                    count++;
                }
                System.out.print(vertex + ", ");
            }
            System.out.println();
        }

        System.out.println("Total iterations: " + count);
    }

    private static void test1() {
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
        execute(GraphUtil.createAdjacencyList(data), 7);
    }

    public static void main(String... s) {
        test1();
    }
}