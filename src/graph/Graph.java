package graph;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Graph<T> {

	private Map<T, List<T>> map = new HashMap<>();

	public static void main(String[] args) {

		// Object of graph is created.
		Graph<Integer> g = new Graph<Integer>();

		// edges are added.
		// Since the graph is bidirectional,
		// so boolean bidirectional is passed as true.
		g.addEdge(0, 1, true);
		g.addEdge(0, 4, true);
		g.addEdge(1, 2, true);
		g.addEdge(1, 3, true);
		g.addEdge(1, 4, true);
		g.addEdge(2, 3, true);
		g.addEdge(3, 4, true);

		// print the graph.
		System.out.println("Graph:\n" + g.toString());

	}

	public void addVertex(T s) {
		map.put(s, new LinkedList<T>());
	}

	public void addEdge(T source, T destination, boolean bidirectional) {
		if (!map.containsKey(source)) {
			addVertex(source);
		}
		if (!map.containsKey(destination)) {
			addVertex(destination);
		}
		map.get(source).add(destination);
		if (bidirectional) {
			map.get(destination).add(source);
		}

	}
	
	public void getVertexCount() {
		System.out.println("Graph has "+map.keySet().size()+" vertices");
	}
	
	public void hasEdge(T source, T destination) {
		if(map.containsKey(source)) {
			if(map.get(source).contains(destination)) {
				System.out.println("Graph has edge between "+source+ " and "+destination);
			}
		}
	}
	
	public void hasVertext(T vertex) {
		if(map.containsKey(vertex)) {
			System.out.println("Graph has vertex "+vertex);
		}
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		for(Map.Entry<T, List<T>> entry : map.entrySet()) {
			sb.append(entry.getKey()+": ");
			sb.append(entry.getValue().toString());
			sb.append("\n");
		}
		
		return sb.toString();
	}

}
