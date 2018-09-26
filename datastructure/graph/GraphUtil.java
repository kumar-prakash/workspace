import java.util.LinkedList;

public class GraphUtil {
    private static LinkedList<Integer> createListFromString(String elements) {
        LinkedList<Integer> list = new LinkedList<Integer>();
        for(String item: elements.split(",")) {
            list.add(Integer.parseInt(item.trim()));
        }
        return list;
    }

    @SuppressWarnings("unchecked")
    public static LinkedList<Integer>[] createAdjacencyList(String [] args) {
        LinkedList<Integer> [] list = new LinkedList[args.length + 1];
        for(String line: args) {
            String [] temp = line.split("=");
            list[Integer.parseInt(temp[0].trim())] = createListFromString(temp[1].trim());
        }
        return list;
    }
}