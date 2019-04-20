import java.util.*;

public class Elementry {
    /**
     * This method calculates in degree of every vertex without using any extra space.
     * Running time of this algorithm is O(V(V + E))
     * 
     * @param list adjacency list representation of the given graph
     */
    public static void calculateInDegreeV1(List<List<Integer>> list) {
        int count = 0;
        for(int i = 0; i < list.size(); i++) {
            for(List<Integer> temp: list) {
                for(Integer node: temp) {
                    if(node == i) {
                        count++;
                    }
                }
            }
            System.out.println("In-degree of node " + (i + 1) + " is " + count);
            count = 0;
        }
    }

    /***
     * This method calculated in-degree of every node using O(V) extra space.
     * Running time of this algorithm is O(V + E);
     * 
     * @param list
     */
    public static void calculateInDegreeV2(List<List<Integer>> list) {
        int [] counts = new int[list.size()];
        for(List<Integer> temp: list) {
            for(Integer node: temp) {
                counts[node]++;
            }
        }
        for(int i = 0; i < counts.length; i++) {
            System.out.println("In-degree of node " + (i + 1) + " is " + counts[i]);
        }
    }

    /***
     * Calculates out-degree of the graph represented by adjacency list.
     * Running time of this algorithm is O(V + E);
     * 
     * @param list adjacency list representation of the graph
     */
    public static void calculateOutDegree(List<List<Integer>> list) {
        for(int i = 0; i < list.size(); i++) {
            System.out.println("Out degree of " + (i + 1) + " is " + list.get(i).size());
        }
    }

    /***
     * Creates Adjacency matrix form a binary heap.
     * Running time of this algorithm is O(n), where n = length of heap
     * 
     * @param heap binary heap
     * @return  adjacency matrix
     */
    public static int[][] toAdjacencyMatrixFromBinaryHeap(int [] heap) {
        int [][] matrix = new int [heap.length][heap.length];
        for(int i = 0; i < heap.length; i++) {
            matrix[i] = new int [heap.length];
        }

        for(int i = 0; i < heap.length / 2; i++) {
            int node = heap[i] - 1;
            int left = heap[i * 2 + 1] - 1;
            int right = heap[i * 2 + 2] - 1;
            matrix[node][left] = 1;
            matrix[node][right] = 1;
        }

        return matrix;
    }

    /***
     * Creates traspose of a graph represented by adjacency list.
     * Running time of this algorithm is O(V + E)
     * 
     * @param list adjacency list representation of a graph
     * @return adjacency list representation of the transposed graph
     */
    public static List<List<Integer>> transposeGraphFromAdjacencyList(List<List<Integer>> list) {
        if(list == null) {
            return null;
        }

        // initialize new adjacency list
        List<List<Integer>> transpose = new ArrayList<>();
        for(int i = 0; i < list.size(); i++) {
            transpose.add(new ArrayList<>());
        }

        for(int i = 0; i < list.size(); i++) {
            for(Integer vertex: list.get(i)) {
                transpose.get(vertex).add(i);
            }
        }

        return transpose;
    }

    /***
     * Creates transpose of a graph represented by adjacency matrix.
     * Running time of this algorithm is O(V * V)
     * 
     * @param matrix adjacency matrix representation of the graph
     * @return  adjacency matrix representation of the transposed graph
     */
    public static int [][] transposeGraphFromAdjacencyMatrix(int [][] matrix) {
        if(matrix == null) {
            return null;
        }

        int length = matrix.length;
        int [][] transpose = new int[length][length];
        for(int i = 0; i < length; i++) {
            for(int j = 0; j < length; j++) {
                transpose[j][i] = matrix[i][j];
            }
        }

        return transpose;
    }

    /***
     * Simplifies(removes duplicate edges and self loop) the given multi graph.
     * Running time of this algorithm is O(V + E)
     * 
     * @param list adjacency list representation of a multi-graph
     * @return  adjacency list of simplified graph
     */
    public static List<List<Integer>> simplifyMultiGraph(List<List<Integer>> list) {
        List<List<Integer>> simp = new ArrayList<>();
        Set<Integer> cache = new HashSet<>();
        for(int i = 0; i < list.size(); i++) {
            cache.add(i);
            List<Integer> adList = new ArrayList<>();
            for(Integer vertex: list.get(i)) {
                if(!cache.contains(vertex)) {
                    adList.add(vertex);
                    cache.add(vertex);
                }
            }
            simp.add(i, adList);
            cache.clear();
        }
        return simp;
    }

    public static int findUniversalSink(int [][] matrix) {
        int sink = -1;
        int i = 0;
        int j = 0;
        int n = matrix.length;

        while(i < n && j < n) {
            if(matrix[i][j] == 0) {
                j++;
            } else if(matrix[i][j] == 1) {
                i++;
            }
        }

        // check ith row and column for sink property
        boolean isSink = true;
        for(int k = 0; k < n; k++) {
            if(k != i && matrix[k][i] != 1) {
                isSink = false;
                break;
            }
            if(matrix[i][k] == 1) {
                isSink = false;
                break;
            }
        }

        return isSink ? i : sink;
    }

    public static void main(String... s) {
        String [] arr = {
            "1 = 2, 4",
            "2 = 3, 4",
            "3 = 4, 5",
            "4 = 5",
            "5 =",
        };

        //List<List<Integer>> list = GraphUtil.createAdjacencyList(arr);
        //GraphUtil.printAdjacencyList(list);
        
        //calculateOutDegree(list);
        
        //calculateInDegreeV1(list);
        
        //calculateInDegreeV2(list);
        
        //GraphUtil.printAdjacencyMatrix(toAdjacencyMatrixFromBinaryHeap(new int[] {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11}));
        
        //GraphUtil.printAdjacencyList(transposeGraphFromAdjacencyList(list));
        
        //int [][] matrix = GraphUtil.createAdjacencyMatrix(arr);
        //GraphUtil.printAdjacencyMatrix(matrix);
        //GraphUtil.printAdjacencyMatrix(transposeGraphFromAdjacencyMatrix(matrix));

        /*
        List<List<Integer>> list = GraphUtil.createAdjacencyList(new String[] {
            "1 = 1,2,3,2,3",
            "2=4,3,1,2,1",
            "3=2,4,1,1",
            "4=2,3,4"
        });

        GraphUtil.printAdjacencyList(list);
        System.out.println("");
        GraphUtil.printAdjacencyList(simplifyMultiGraph(list));
        */

        String [] test = {
            "1 = 2, 3, 5",
            "2 = 3",
            "3 =",
            "4 = 2, 3, 5",
            "5 = 3"
        };

        System.out.println(findUniversalSink(GraphUtil.createAdjacencyMatrix(arr)));
    }
}