import java.util.*;

public class GraphUtil {

	/**
	 * 1 = 2,4 - 3,2
	 * 2 = 1,4 - 5,6
	 */
	public static Map<Integer, List<Entry>> createAdjacencyMap(String [] arr) {
		Map<Integer, List<Entry>> map = new HashMap<>();
		for(String temp: arr) {
			String [] parts = temp.split("=");
			int node = Integer.parseInt(parts[0].trim());
			List<Entry> entryList = new ArrayList<>();
			if(parts.length > 1) {
				String [] edges = parts[1].trim().split("-");
				for(String edge: edges) {
					entryList.add(createEntry(edge));
				}
			}
			map.put(node, entryList);
		}
		return map;
	}

	public static List<List<Integer>> createAdjacencyList(String [] arr) {
		List<List<Integer>> list = new ArrayList<>();
		
		for(String temp: arr) {
			String [] parts = temp.split("=");
			List<Integer> edges = new ArrayList<>();
			if(parts.length > 1) {
				for(String edge: parts[1].trim().split(",")) {
					edges.add(Integer.parseInt(edge.trim()) - 1);
				}
			}
			
			list.add(Integer.parseInt(parts[0].trim()) - 1, edges);
		}

		return list;
	}

	public static int [][] createAdjacencyMatrix(String [] arr) {
		int length = arr.length;
		int [][] matrix = new int[length][length];

		for(String line: arr) {
			String [] parts = line.split("=");
			int vertex = Integer.parseInt(parts[0].trim()) - 1;
			matrix[vertex] = new int[length];
			if(parts.length > 1) {
				for(String edge: parts[1].trim().split(",")) {
					matrix[vertex][Integer.parseInt(edge.trim()) - 1] = 1;
				}
			}
		}

		return matrix;
	}

	public static void printAdjacencyList(List<List<Integer>> list) {
		for(int i = 0; i < list.size(); i++) {
			System.out.print((i + 1) + " = ");
			for(Integer temp: list.get(i)) {
				System.out.print((temp + 1) + ", ");
			}
			System.out.println("");
		}
	}

	private static void printSpace(int times, boolean putLineBreak) {
		for(int i = 0; i < times; i++) {
			System.out.print(" ");
		}
		if(putLineBreak) {
			System.out.println("");
		}
	}

	private static void printHyphen(int times) {
		for(int i = 0; i < times; i++) {
			System.out.print("--");
		}
		System.out.println("");
	}

	public static void printAdjacencyMatrix(int [][] matrix) {
		System.out.print("\n\n");
		printSpace(4, false);
		for(int i = 1; i <= matrix[0].length; i++) {
			System.out.print("  " + i + " ");
		}
		System.out.println("");
		printSpace(4, false);
		printHyphen(matrix[0].length * 2);
		for(int i = 0; i < matrix.length; i++) {
			System.out.print("  " + (i + 1) + " |");
			for(int j = 0; j < matrix[0].length; j++) {
				System.out.print(" " + matrix[i][j] + " " + "|");
			}
			System.out.println("");
			printSpace(4, false);
			printHyphen(matrix[0].length * 2);
		}
		System.out.print("\n");
	}

	private static Entry createEntry(String s) {
		String [] parts = s.split(",");
		return new Entry(Integer.parseInt(parts[0].trim()), Integer.parseInt(parts[1].trim()));
	}
}

class Entry {
	private int node;
	private int weight;

	public Entry(int node, int weight) {
		this.node = node;
		this.weight = weight;
	}

	public int getNode() {
		return this.node;
	}

	public int getWeight() {
		return this.weight;
	}

	public Entry setNode(int node) {
		this.node = node;
		return this;
	}

	public Entry setWeight(int weight) {
		this.weight = weight;
		return this;
	}

	public boolean equals(Entry entry) {
		if(entry == null) {
			return false;
		}
		if(entry.getNode() != this.getNode()) {
			return false;
		}
		return true;
	}
	
	public String toString() {
		return "(" + this.node + ", " + this.weight + ")";
	}
}
